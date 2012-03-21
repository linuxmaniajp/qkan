
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
 * 作成日: 2006/04/07  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (004)
 * プログラム 特定治療費編集画面 (QP004001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;

/**
 * 特定治療費編集画面イベント定義(QP004001) 
 */
public abstract class QP004001Event extends QP004001SQL {
  /**
   * コンストラクタです。
   */
  public QP004001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getMedicalClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalUpdateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getMedicalDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getAplly().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                apllyActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
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
    getMedicalTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                medicalTableSelectionChanged(e);
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
   * 「クリア」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「追加」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「書替」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalUpdateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「OK」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void apllyActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「キャンセル」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「一覧選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void medicalTableSelectionChanged(ListSelectionEvent e) throws Exception;

  //変数定義

  private boolean applied = false;
  private VRList medicalInfos = new VRArrayList();
  private VRList basicInfos = new VRArrayList();
  private VRList totalInfos = new VRArrayList();
  private VRList editMedicalInfos = new VRArrayList();
  //getter/setter

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
   * medicalInfosを返します。
   * @return medicalInfos
   */
  protected VRList getMedicalInfos(){
    return medicalInfos;
  }
  /**
   * medicalInfosを設定します。
   * @param medicalInfos medicalInfos
   */
  protected void setMedicalInfos(VRList medicalInfos){
    this.medicalInfos = medicalInfos;
  }

  /**
   * basicInfosを返します。
   * @return basicInfos
   */
  protected VRList getBasicInfos(){
    return basicInfos;
  }
  /**
   * basicInfosを設定します。
   * @param basicInfos basicInfos
   */
  protected void setBasicInfos(VRList basicInfos){
    this.basicInfos = basicInfos;
  }

  /**
   * totalInfosを返します。
   * @return totalInfos
   */
  protected VRList getTotalInfos(){
    return totalInfos;
  }
  /**
   * totalInfosを設定します。
   * @param totalInfos totalInfos
   */
  protected void setTotalInfos(VRList totalInfos){
    this.totalInfos = totalInfos;
  }

  /**
   * editMedicalInfosを返します。
   * @return editMedicalInfos
   */
  protected VRList getEditMedicalInfos(){
    return editMedicalInfos;
  }
  /**
   * editMedicalInfosを設定します。
   * @param editMedicalInfos editMedicalInfos
   */
  protected void setEditMedicalInfos(VRList editMedicalInfos){
    this.editMedicalInfos = editMedicalInfos;
  }

  //内部関数

  /**
   * 「画面展開」に関する処理を行ないます。
   *
   * @param medicalInfos VRList
   * @param basicInfos VRList
   * @param totalInfos VRList
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean showModal(VRList medicalInfos, VRList basicInfos, VRList totalInfos) throws Exception;

}
