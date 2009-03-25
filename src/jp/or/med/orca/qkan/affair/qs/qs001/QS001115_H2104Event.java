
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
 * 作成日: 2009/03/07  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン特定施設入所者生活介護 (QS001115_H2104)
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
 * サービスパターン特定施設入所者生活介護イベント定義(QS001115_H2104) 
 */
public abstract class QS001115_H2104Event extends QS001115_H2104State implements QS001Service {
  /**
   * コンストラクタです。
   */
  public QS001115_H2104Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getOutsideServiceRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                outsideServiceRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getFacilitiesDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                facilitiesDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSpecificFacilityBeginTime().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                specificFacilityBeginTimeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitNursingCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitNursingComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpertPlaceNursingCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expertPlaceNursingComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpertPlaceRehabiliCombo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expertPlaceRehabiliComboActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitNursingFacilitiesDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitNursingFacilitiesDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitNursingStaffDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitNursingStaffDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getExpertPlaceNursingRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                expertPlaceNursingRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                providerDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTimeDivisionRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                timeDivisionRadioSelectionChanged(e);
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
   * 「区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void outsideServiceRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「施設区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void facilitiesDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「開始時刻選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void specificFacilityBeginTimeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「訪問介護時間区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「訪問看護時間区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitNursingComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「通所介護時間区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void expertPlaceNursingComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「通所リハ時間区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void expertPlaceRehabiliComboActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「訪問看護施設区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitNursingFacilitiesDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「訪問看護職員区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitNursingStaffDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「通所介護施設区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void expertPlaceNursingRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「認知症対応通所介護施設区分」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「認知症対応型通所介護時間区分選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private boolean functionTrainingFlag;
  private boolean nightNurseFlag;
  //getter/setter

  /**
   * functionTrainingFlagを返します。
   * @return functionTrainingFlag
   */
  protected boolean getFunctionTrainingFlag(){
    return functionTrainingFlag;
  }
  /**
   * functionTrainingFlagを設定します。
   * @param functionTrainingFlag functionTrainingFlag
   */
  protected void setFunctionTrainingFlag(boolean functionTrainingFlag){
    this.functionTrainingFlag = functionTrainingFlag;
  }

  /**
   * nightNurseFlagを返します。
   * @return nightNurseFlag
   */
  protected boolean getNightNurseFlag(){
    return nightNurseFlag;
  }
  /**
   * nightNurseFlagを設定します。
   * @param nightNurseFlag nightNurseFlag
   */
  protected void setNightNurseFlag(boolean nightNurseFlag){
    this.nightNurseFlag = nightNurseFlag;
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
   * 「終了時間設定処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkEndTime() throws Exception;

  /**
   * 「訪問看護時間取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getHoumonKangoTime() throws Exception;

  /**
   * 「訪問看護時間取得_指定訪問看護ステーション」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getHoumonKangoTimeSpecial() throws Exception;

  /**
   * 「訪問介護時間取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getKangoTime() throws Exception;

  /**
   * 「認知症対応型通所介護時間取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getNintiTaiouTusyoKaigoTime() throws Exception;

  /**
   * 「通所介護時間取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getTuusyoKaigoTime() throws Exception;

  /**
   * 「通所介護時間取得_2」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getTuusyoKaigoTimeSpecial() throws Exception;

  /**
   * 「通所リハ時間取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getTuusyoRihaTime() throws Exception;

  /**
   * 「サービス法改正区分取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getServiceLowVersion() throws Exception;

}
