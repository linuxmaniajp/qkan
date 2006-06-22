
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
 * 作成日: 2006/01/22  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 保険者管理 (001)
 * プログラム 保険者一覧 (QO001)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo001;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
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
import jp.or.med.orca.qkan.lib.*;

/**
 * 保険者一覧イベント定義(QO001) 
 */
public abstract class QO001Event extends QO001SQL {
  /**
   * コンストラクタです。
   */
  public QO001Event(){
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
            }catch(Exception ex){
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
            }catch(Exception ex){
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
            }catch(Exception ex){
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
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insurerInfoTableSelectionChanged(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsurerInfoTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    insurerInfoTableMouseClicked(e);
                }
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
   * 「検索処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「保険者登録画面に遷移（更新）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「保険者登録画面に遷移（新規）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面制御」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「画面遷移処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insurerInfoTableMouseClicked(MouseEvent e) throws Exception;

  //変数定義

  private ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY;
  private int PROCESS_MODE;
  private String insurerId;
  private VRMap affairMap = new VRHashMap();
  private VRList insurerInfoList = new VRArrayList();
  private VRList insurerLimitRateList = new VRArrayList();
  private VRList insurerLImitRateDetailList = new VRArrayList();
  private ACTableModelAdapter insurerInfoTableModel;
  //getter/setter

  /**
   * INSURER_INFO_PASSIVE_CHECK_KEYを返します。
   * @return INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getINSURER_INFO_PASSIVE_CHECK_KEY(){
    return INSURER_INFO_PASSIVE_CHECK_KEY;
  }
  /**
   * INSURER_INFO_PASSIVE_CHECK_KEYを設定します。
   * @param INSURER_INFO_PASSIVE_CHECK_KEY INSURER_INFO_PASSIVE_CHECK_KEY
   */
  protected void setINSURER_INFO_PASSIVE_CHECK_KEY(ACPassiveKey INSURER_INFO_PASSIVE_CHECK_KEY){
    this.INSURER_INFO_PASSIVE_CHECK_KEY = INSURER_INFO_PASSIVE_CHECK_KEY;
  }

  /**
   * PROCESS_MODEを返します。
   * @return PROCESS_MODE
   */
  protected int getPROCESS_MODE(){
    return PROCESS_MODE;
  }
  /**
   * PROCESS_MODEを設定します。
   * @param PROCESS_MODE PROCESS_MODE
   */
  protected void setPROCESS_MODE(int PROCESS_MODE){
    this.PROCESS_MODE = PROCESS_MODE;
  }

  /**
   * insurerIdを返します。
   * @return insurerId
   */
  protected String getInsurerId(){
    return insurerId;
  }
  /**
   * insurerIdを設定します。
   * @param insurerId insurerId
   */
  protected void setInsurerId(String insurerId){
    this.insurerId = insurerId;
  }

  /**
   * affairMapを返します。
   * @return affairMap
   */
  protected VRMap getAffairMap(){
    return affairMap;
  }
  /**
   * affairMapを設定します。
   * @param affairMap affairMap
   */
  protected void setAffairMap(VRMap affairMap){
    this.affairMap = affairMap;
  }

  /**
   * insurerInfoListを返します。
   * @return insurerInfoList
   */
  protected VRList getInsurerInfoList(){
    return insurerInfoList;
  }
  /**
   * insurerInfoListを設定します。
   * @param insurerInfoList insurerInfoList
   */
  protected void setInsurerInfoList(VRList insurerInfoList){
    this.insurerInfoList = insurerInfoList;
  }

  /**
   * insurerLimitRateListを返します。
   * @return insurerLimitRateList
   */
  protected VRList getInsurerLimitRateList(){
    return insurerLimitRateList;
  }
  /**
   * insurerLimitRateListを設定します。
   * @param insurerLimitRateList insurerLimitRateList
   */
  protected void setInsurerLimitRateList(VRList insurerLimitRateList){
    this.insurerLimitRateList = insurerLimitRateList;
  }

  /**
   * insurerLImitRateDetailListを返します。
   * @return insurerLImitRateDetailList
   */
  protected VRList getInsurerLImitRateDetailList(){
    return insurerLImitRateDetailList;
  }
  /**
   * insurerLImitRateDetailListを設定します。
   * @param insurerLImitRateDetailList insurerLImitRateDetailList
   */
  protected void setInsurerLImitRateDetailList(VRList insurerLImitRateDetailList){
    this.insurerLImitRateDetailList = insurerLImitRateDetailList;
  }

  /**
   * insurerInfoTableModelを返します。
   * @return insurerInfoTableModel
   */
  protected ACTableModelAdapter getInsurerInfoTableModel(){
    return insurerInfoTableModel;
  }
  /**
   * insurerInfoTableModelを設定します。
   * @param insurerInfoTableModel insurerInfoTableModel
   */
  protected void setInsurerInfoTableModel(ACTableModelAdapter insurerInfoTableModel){
    this.insurerInfoTableModel = insurerInfoTableModel;
  }

  //内部関数

  /**
   * 「レコードを取得し画面に設定する。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「全保険者情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindInsurerInfo() throws Exception;

  /**
   * 「選択保険者削除処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doDelete() throws Exception;

  /**
   * 「検索処理を行う。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindData() throws Exception;

  /**
   * 「保険者番号が使用されているかチェックする」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkInsurerId() throws Exception;

}
