
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
 * 作成日: 2007/02/27  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (003)
 * プログラム 利用者向け請求詳細編集 (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
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
 * 利用者向け請求詳細編集イベント定義(QP003) 
 */
public abstract class QP003Event extends QP003SQL {
  /**
   * コンストラクタです。
   */
  public QP003Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
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
    getUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                updateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentJikohutanUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentJikohutanUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getContentEtcUse5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                contentEtcUse5FocusLost(e);
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
   * 「DB登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「DB登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「直近の訪問看護計画書情報の読込」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentJikohutanUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「合計金額の計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void contentEtcUse5FocusLost(FocusEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final int STYLE_TYPE_CLAIM_FOR_PATIENT = 30101;
  public static final int CATEGORY_NO_CLAIM_FOR_PATIENT = 16;
  public static final Date DATE_20070401 = ACCastUtilities.toDate("2007/04/01", null);
  private int patientId;
  private int listIndex;
  private int sum;
  private int claimId;
  private int dataFlg;
  private int processMode;
  private String providerId;
  private String insurerId;
  private String insuredId;
  private Date targetDate;
  private Date claimDate;
  private VRList claimList = new VRArrayList();
  private VRList comboSet1 = new VRArrayList();
  private VRList comboSet2 = new VRArrayList();
  private VRMap modelMap = new VRHashMap();
  private VRMap sourceMap = new VRHashMap();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEYを返します。
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEYを設定します。
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * patientIdを返します。
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientIdを設定します。
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * listIndexを返します。
   * @return listIndex
   */
  protected int getListIndex(){
    return listIndex;
  }
  /**
   * listIndexを設定します。
   * @param listIndex listIndex
   */
  protected void setListIndex(int listIndex){
    this.listIndex = listIndex;
  }

  /**
   * sumを返します。
   * @return sum
   */
  protected int getSum(){
    return sum;
  }
  /**
   * sumを設定します。
   * @param sum sum
   */
  protected void setSum(int sum){
    this.sum = sum;
  }

  /**
   * claimIdを返します。
   * @return claimId
   */
  protected int getClaimId(){
    return claimId;
  }
  /**
   * claimIdを設定します。
   * @param claimId claimId
   */
  protected void setClaimId(int claimId){
    this.claimId = claimId;
  }

  /**
   * dataFlgを返します。
   * @return dataFlg
   */
  protected int getDataFlg(){
    return dataFlg;
  }
  /**
   * dataFlgを設定します。
   * @param dataFlg dataFlg
   */
  protected void setDataFlg(int dataFlg){
    this.dataFlg = dataFlg;
  }

  /**
   * processModeを返します。
   * @return processMode
   */
  protected int getProcessMode(){
    return processMode;
  }
  /**
   * processModeを設定します。
   * @param processMode processMode
   */
  protected void setProcessMode(int processMode){
    this.processMode = processMode;
  }

  /**
   * providerIdを返します。
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerIdを設定します。
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
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
   * insuredIdを返します。
   * @return insuredId
   */
  protected String getInsuredId(){
    return insuredId;
  }
  /**
   * insuredIdを設定します。
   * @param insuredId insuredId
   */
  protected void setInsuredId(String insuredId){
    this.insuredId = insuredId;
  }

  /**
   * targetDateを返します。
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDateを設定します。
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  /**
   * claimDateを返します。
   * @return claimDate
   */
  protected Date getClaimDate(){
    return claimDate;
  }
  /**
   * claimDateを設定します。
   * @param claimDate claimDate
   */
  protected void setClaimDate(Date claimDate){
    this.claimDate = claimDate;
  }

  /**
   * claimListを返します。
   * @return claimList
   */
  protected VRList getClaimList(){
    return claimList;
  }
  /**
   * claimListを設定します。
   * @param claimList claimList
   */
  protected void setClaimList(VRList claimList){
    this.claimList = claimList;
  }

  /**
   * comboSet1を返します。
   * @return comboSet1
   */
  protected VRList getComboSet1(){
    return comboSet1;
  }
  /**
   * comboSet1を設定します。
   * @param comboSet1 comboSet1
   */
  protected void setComboSet1(VRList comboSet1){
    this.comboSet1 = comboSet1;
  }

  /**
   * comboSet2を返します。
   * @return comboSet2
   */
  protected VRList getComboSet2(){
    return comboSet2;
  }
  /**
   * comboSet2を設定します。
   * @param comboSet2 comboSet2
   */
  protected void setComboSet2(VRList comboSet2){
    this.comboSet2 = comboSet2;
  }

  /**
   * modelMapを返します。
   * @return modelMap
   */
  protected VRMap getModelMap(){
    return modelMap;
  }
  /**
   * modelMapを設定します。
   * @param modelMap modelMap
   */
  protected void setModelMap(VRMap modelMap){
    this.modelMap = modelMap;
  }

  /**
   * sourceMapを返します。
   * @return sourceMap
   */
  protected VRMap getSourceMap(){
    return sourceMap;
  }
  /**
   * sourceMapを設定します。
   * @param sourceMap sourceMap
   */
  protected void setSourceMap(VRMap sourceMap){
    this.sourceMap = sourceMap;
  }

  //内部関数

  /**
   * 「データ取得、画面展開」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「利用者向け請求詳細情報を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindClaimForPatient() throws Exception;

  /**
   * 「合計金額の計算処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void calcSum() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「画面データチェック・編集」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCheckInput() throws Exception;

  /**
   * 「入力データの値をチェックする。」に関する処理を行ないます。
   *
   * @param himokuCombo ACComboBox
   * @param jikohutanText ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void checkValue(ACComboBox himokuCombo, ACTextField jikohutanText) throws Exception;

  /**
   * 「コンボ候補を設定する。」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void comboInitialize() throws Exception;

}
