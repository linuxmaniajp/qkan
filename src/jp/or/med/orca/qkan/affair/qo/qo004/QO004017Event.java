
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
 * 作成日: 2006/02/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護老人保健施設 (QO004017)
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

/**
 * 介護老人保健施設イベント定義(QO004017) 
 */
public abstract class QO004017Event extends QO004017Design implements iProviderServicePanel {
  /**
   * コンストラクタです。
   */
  public QO004017Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getCareOldPeopleHealthFacilitiesMorningDinnerStandeirdMoney().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCareOldPeopleHealthFacilitiesNoonDinnerStandeirdMoney().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyFocusLost(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCareOldPeopleHealthFacilitiesNightDinnerStandeirdMoney().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyFocusLost(e);
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
   * 「介護老人保健施設食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void careOldPeopleHealthFacilitiesMorningDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception;

  /**
   * 「介護老人保健施設食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void careOldPeopleHealthFacilitiesNoonDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception;

  /**
   * 「介護老人保健施設食費基準基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void careOldPeopleHealthFacilitiesNightDinnerStandeirdMoneyFocusLost(FocusEvent e) throws Exception;

  //変数定義

  //getter/setter

  //内部関数

  /**
   * 「介護老人保健施設食費基準基準額合計処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void dinnerStandeirdMoneyTotal() throws Exception;

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

}
