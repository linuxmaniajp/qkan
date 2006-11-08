
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
 * 作成日: 2006/02/25  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護老人保健施設 (QO004119)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
import jp.or.med.orca.qkan.text.*;

/**
 * 介護老人保健施設イベント定義(QO004119) 
 */
public abstract class QO004119Event extends QO004119SQL implements iProviderServicePanel {
  /**
   * コンストラクタです。
   */
  public QO004119Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getFacilitiesDivision().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                facilitiesDivisionSelectionChanged(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDinnerMorning().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dinnerMorningFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDinnerNoon().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dinnerNoonFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDinnerNight().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                dinnerNightFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「画面状態設定」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dinnerMorningFocusLost(FocusEvent e) throws Exception;

  /**
   * 「食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dinnerNoonFocusLost(FocusEvent e) throws Exception;

  /**
   * 「食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void dinnerNightFocusLost(FocusEvent e) throws Exception;

  //変数定義

  public static final int FACILITY_TYPE_HOKEN = 1;
  public static final int FACILITY_TYPE_SHOKIBO_HOKEN = 2;
  //getter/setter

  //内部関数

  /**
   * 「食費基準額合計表示処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void totalDinnerMoney() throws Exception;

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * 「パネル状態制御」に関する処理を行ないます。
   *
   * @param state boolean
   * @throws Exception 処理例外
   *
   */
  public abstract void stateManager(boolean state) throws Exception;

  /**
   * 「パネルデータ取得」に関する処理を行ないます。
   *
   * @param map VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void getDetails(VRMap map) throws Exception;

  /**
   * 「無効データ削除」に関する処理を行ないます。
   *
   * @param map VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void removeInvalidData(VRMap map) throws Exception;

}
