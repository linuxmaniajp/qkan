
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
 * 作成日: 2006/06/05  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 計画単位数編集画面 (QS001032)
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 計画単位数編集画面イベント定義(QS001032) 
 */
public abstract class QS001032Event extends QS001032SQL {
  /**
   * コンストラクタです。
   */
  public QS001032Event(){
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
    getOk().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                okActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProvider().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerActionPerformed(e);
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
   * 「破棄して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「保存して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void okActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象事業所選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private VRList planUnitModelValue = new VRArrayList();
  private VRMap planUnits = new VRHashMap();
  private boolean applied = false;
  private String selectedProviderID;
  //getter/setter

  /**
   * planUnitModelValueを返します。
   * @return planUnitModelValue
   */
  protected VRList getPlanUnitModelValue(){
    return planUnitModelValue;
  }
  /**
   * planUnitModelValueを設定します。
   * @param planUnitModelValue planUnitModelValue
   */
  protected void setPlanUnitModelValue(VRList planUnitModelValue){
    this.planUnitModelValue = planUnitModelValue;
  }

  /**
   * planUnitsを返します。
   * @return planUnits
   */
  protected VRMap getPlanUnits(){
    return planUnits;
  }
  /**
   * planUnitsを設定します。
   * @param planUnits planUnits
   */
  protected void setPlanUnits(VRMap planUnits){
    this.planUnits = planUnits;
  }

  /**
   * appliedを返します。
   * @return applied
   */
  protected boolean getApplied(){
    return applied;
  }
  /**
   * appliedを設定します。
   * @param applied applied
   */
  protected void setApplied(boolean applied){
    this.applied = applied;
  }

  /**
   * selectedProviderIDを返します。
   * @return selectedProviderID
   */
  protected String getSelectedProviderID(){
    return selectedProviderID;
  }
  /**
   * selectedProviderIDを設定します。
   * @param selectedProviderID selectedProviderID
   */
  protected void setSelectedProviderID(String selectedProviderID){
    this.selectedProviderID = selectedProviderID;
  }

  //内部関数

  /**
   * 「初期設定」に関する処理を行ないます。
   *
   * @param planUnit VRMap
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean showModal(VRMap planUnit) throws Exception;

  /**
   * 「入力中の計画単位数の取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getSelectedPlanUnits() throws Exception;

  /**
   * 「確定した計画単位数を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getAppliedValue() throws Exception;

}
