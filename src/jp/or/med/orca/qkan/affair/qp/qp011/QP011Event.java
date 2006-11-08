
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
 * 作成日: 2006/08/19  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書一覧 (011)
 * プログラム 訪問看護療養費領収書一覧 (QP011)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp011;
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
 * 訪問看護療養費領収書一覧イベント定義(QP011) 
 */
public abstract class QP011Event extends QP011SQL {
  /**
   * コンストラクタです。
   */
  public QP011Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getFind().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                findActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetail().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                deleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBills().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                billsSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBills().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    billsMouseClicked(e);
                }
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
   * 「検索」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「詳細画面に遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「新規作成」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void billsSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「画面遷移処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void billsMouseClicked(MouseEvent e) throws Exception;

  //変数定義

  private ACPassiveKey BILL_PASSIVE_CHECK_KEY;
  private Date findTargetDate;
  private Date billDate;
  private int patientID;
  private VRList billData = new VRArrayList();
  private ACTableModelAdapter billTableModel;
  private VRMap findedParam = new VRHashMap();
  //getter/setter

  /**
   * BILL_PASSIVE_CHECK_KEYを返します。
   * @return BILL_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getBILL_PASSIVE_CHECK_KEY(){
    return BILL_PASSIVE_CHECK_KEY;
  }
  /**
   * BILL_PASSIVE_CHECK_KEYを設定します。
   * @param BILL_PASSIVE_CHECK_KEY BILL_PASSIVE_CHECK_KEY
   */
  protected void setBILL_PASSIVE_CHECK_KEY(ACPassiveKey BILL_PASSIVE_CHECK_KEY){
    this.BILL_PASSIVE_CHECK_KEY = BILL_PASSIVE_CHECK_KEY;
  }

  /**
   * findTargetDateを返します。
   * @return findTargetDate
   */
  protected Date getFindTargetDate(){
    return findTargetDate;
  }
  /**
   * findTargetDateを設定します。
   * @param findTargetDate findTargetDate
   */
  protected void setFindTargetDate(Date findTargetDate){
    this.findTargetDate = findTargetDate;
  }

  /**
   * billDateを返します。
   * @return billDate
   */
  protected Date getBillDate(){
    return billDate;
  }
  /**
   * billDateを設定します。
   * @param billDate billDate
   */
  protected void setBillDate(Date billDate){
    this.billDate = billDate;
  }

  /**
   * patientIDを返します。
   * @return patientID
   */
  protected int getPatientID(){
    return patientID;
  }
  /**
   * patientIDを設定します。
   * @param patientID patientID
   */
  protected void setPatientID(int patientID){
    this.patientID = patientID;
  }

  /**
   * billDataを返します。
   * @return billData
   */
  protected VRList getBillData(){
    return billData;
  }
  /**
   * billDataを設定します。
   * @param billData billData
   */
  protected void setBillData(VRList billData){
    this.billData = billData;
  }

  /**
   * billTableModelを返します。
   * @return billTableModel
   */
  protected ACTableModelAdapter getBillTableModel(){
    return billTableModel;
  }
  /**
   * billTableModelを設定します。
   * @param billTableModel billTableModel
   */
  protected void setBillTableModel(ACTableModelAdapter billTableModel){
    this.billTableModel = billTableModel;
  }

  /**
   * findedParamを返します。
   * @return findedParam
   */
  protected VRMap getFindedParam(){
    return findedParam;
  }
  /**
   * findedParamを設定します。
   * @param findedParam findedParam
   */
  protected void setFindedParam(VRMap findedParam){
    this.findedParam = findedParam;
  }
  //内部関数

  /**
   * 「検索」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「画面遷移処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doNext() throws Exception;

}
