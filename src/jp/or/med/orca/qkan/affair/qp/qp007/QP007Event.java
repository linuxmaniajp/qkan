
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
 * 開発者: 藤原　伸
 * 作成日: 2010/11/12  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 利用者向け印刷 (007)
 * プログラム 利用者向請求書印刷設定 (QP007)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp007;
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
 * 利用者向請求書印刷設定イベント定義(QP007) 
 */
public abstract class QP007Event extends QP007SQL {
  /**
   * コンストラクタです。
   */
  public QP007Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getPatientBillSetupPapersRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                patientBillSetupPapersRadioSelectionChanged(e);
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

  }
  //コンポーネントイベント

  /**
   * 「印刷条件Enabled変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void patientBillSetupPapersRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「印刷押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「閉じる押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void closeActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private VRMap values = new VRHashMap();
  private VRList providerNameList = new VRArrayList();
  private int providerFixedFormId;
  //getter/setter

  /**
   * valuesを返します。
   * @return values
   */
  protected VRMap getValues(){
    return values;
  }
  /**
   * valuesを設定します。
   * @param values values
   */
  protected void setValues(VRMap values){
    this.values = values;
  }

  /**
   * providerNameListを返します。
   * @return providerNameList
   */
  protected VRList getProviderNameList(){
    return providerNameList;
  }
  /**
   * providerNameListを設定します。
   * @param providerNameList providerNameList
   */
  protected void setProviderNameList(VRList providerNameList){
    this.providerNameList = providerNameList;
  }

  /**
   * providerFixedFormIdを返します。
   * @return providerFixedFormId
   */
  protected int getProviderFixedFormId(){
    return providerFixedFormId;
  }
  /**
   * providerFixedFormIdを設定します。
   * @param providerFixedFormId providerFixedFormId
   */
  protected void setProviderFixedFormId(int providerFixedFormId){
    this.providerFixedFormId = providerFixedFormId;
  }

  //内部関数

  /**
   * 「事業所名称取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void getProviderNames() throws Exception;

  /**
   * 「事業所名称の保存」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void saveProviderNames() throws Exception;

}
