
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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/03/11  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定・実績 (001)
 * プログラム 利用・提供票印刷 (QS001031)
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
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrintParameter;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * 利用・提供票印刷イベント定義(QS001031) 
 */
public abstract class QS001031Event extends QS001031SQL {
  /**
   * コンストラクタです。
   */
  public QS001031Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getPlanManufacturer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                planManufacturerActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSupportProviderName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                supportProviderNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getEnd().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                endActionPerformed(e);
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
   * 「居宅サービス作成者変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void planManufacturerActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「事業所名変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void supportProviderNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「利用票/提供票の印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void endActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private int processType;
  private VRList serviceData = new VRArrayList();
  private CareServiceCodeCalcurater calcurater;
  //getter/setter

  /**
   * processTypeを返します。
   * @return processType
   */
  protected int getProcessType(){
    return processType;
  }
  /**
   * processTypeを設定します。
   * @param processType processType
   */
  protected void setProcessType(int processType){
    this.processType = processType;
  }

  /**
   * serviceDataを返します。
   * @return serviceData
   */
  protected VRList getServiceData(){
    return serviceData;
  }
  /**
   * serviceDataを設定します。
   * @param serviceData serviceData
   */
  protected void setServiceData(VRList serviceData){
    this.serviceData = serviceData;
  }

  /**
   * calcuraterを返します。
   * @return calcurater
   */
  protected CareServiceCodeCalcurater getCalcurater(){
    return calcurater;
  }
  /**
   * calcuraterを設定します。
   * @param calcurater calcurater
   */
  protected void setCalcurater(CareServiceCodeCalcurater calcurater){
    this.calcurater = calcurater;
  }

  //内部関数

  /**
   * 「画面展開時イベント」に関する処理を行ないます。
   *
   * @param calcurater QS001ServiceCodeCalcurater
   * @param serviceData VRList
   * @param processType int
   * @throws Exception 処理例外
   *
   */
  public abstract void showModal(CareServiceCodeCalcurater calcurater, VRList serviceData, int processType) throws Exception;

  /**
   * 「初期値設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setInitValue() throws Exception;

  /**
   * 「画面の初期状態の設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setInitState() throws Exception;

  /**
   * 「居宅介護支援事業者事業所欄の状態設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void setProviderComponentState() throws Exception;

  /**
   * 「利用者ID取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getPatientID() throws Exception;

  /**
   * 「特定入居者フラグを取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getInSpecialFacilityFlag() throws Exception;

  /**
   * 「対象年月取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return Date
   */
  public abstract Date getTargetDateSource() throws Exception;

  /**
   * 「要介護認定履歴取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getPatientInsureInfoHistoryList() throws Exception;

  /**
   * 「サービス種類集合取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRList
   */
  public abstract VRList getServiceKindsList() throws Exception;

  /**
   * 「事業所情報ハッシュ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getHashedProviders() throws Exception;

  /**
   * 「本表印刷」に関する処理を行ないます。
   *
   * @param writer ACChotarouXMLWriter
   * @param mainFormat String
   * @param pages List
   * @param invisibles List
   * @param allTexts Map
   * @throws Exception 処理例外
   *
   */
  public abstract void printMainTable(ACChotarouXMLWriter writer, String mainFormat, List pages, List invisibles, Map allTexts) throws Exception;

  /**
   * 「別表印刷」に関する処理を行ないます。
   *
   * @param writer ACChotarouXMLWriter
   * @param subFormat String
   * @param pages List
   * @throws Exception 処理例外
   *
   */
  public abstract void printSubTable(ACChotarouXMLWriter writer, String subFormat, List pages) throws Exception;

  /**
   * 「印刷」に関する処理を行ないます。
   *
   * @param writer ACChotarouXMLWriter
   * @param buildParam QS001ServicePrintParameter
   * @param printMain, String mainFormat, List mainInsuredPages boolean
   * @param allTexts HashMap
   * @param printSub, String subFormat, List subInsuredPages boolean
   * @throws Exception 処理例外
   *
   */
  public abstract void print(ACChotarouXMLWriter writer, CareServicePrintParameter buildParam, boolean printMain, String mainFormat, List mainInsuredPages, HashMap allTexts, boolean printSub, String subFormat, List subInsuredPages) throws Exception;

}
