
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/02/18  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 訪問入浴 (QO004002)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 訪問入浴画面項目デザイン(QO004002) 
 */
public class QO004002Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox homonnyuyokukaigoGroup;

  private ACLabelContainer homonnyuyokukaigoDiscountContena;

  private ACTextField homonnyuyokukaigoDiscountRate;

  private ACLabel percentSign;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getHomonnyuyokukaigoGroup(){
    if(homonnyuyokukaigoGroup==null){

      homonnyuyokukaigoGroup = new ACGroupBox();

      homonnyuyokukaigoGroup.setText("訪問入浴介護");

      homonnyuyokukaigoGroup.setFollowChildEnabled(true);

      addHomonnyuyokukaigoGroup();
    }
    return homonnyuyokukaigoGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getHomonnyuyokukaigoDiscountContena(){
    if(homonnyuyokukaigoDiscountContena==null){

      homonnyuyokukaigoDiscountContena = new ACLabelContainer();

      homonnyuyokukaigoDiscountContena.setText("割引率");

      homonnyuyokukaigoDiscountContena.setFollowChildEnabled(true);

      addHomonnyuyokukaigoDiscountContena();
    }
    return homonnyuyokukaigoDiscountContena;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getHomonnyuyokukaigoDiscountRate(){
    if(homonnyuyokukaigoDiscountRate==null){

      homonnyuyokukaigoDiscountRate = new ACTextField();

      homonnyuyokukaigoDiscountRate.setBindPath("REDUCT_RATE");

      homonnyuyokukaigoDiscountRate.setColumns(3);

      homonnyuyokukaigoDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      homonnyuyokukaigoDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      homonnyuyokukaigoDiscountRate.setIMEMode(InputSubset.LATIN);

      homonnyuyokukaigoDiscountRate.setMaxLength(3);

      addHomonnyuyokukaigoDiscountRate();
    }
    return homonnyuyokukaigoDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("％");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * コンストラクタです。
   */
  public QO004002Design() {

    try {
      initialize();

      initAffair(null);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身の設定を行ないます。
   */
  protected void initThis(){
  }

  /**
   * thisに内部項目を追加します。
   */
  protected void addThis(){

    this.add(getHomonnyuyokukaigoGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addHomonnyuyokukaigoGroup(){

    homonnyuyokukaigoGroup.add(getHomonnyuyokukaigoDiscountContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addHomonnyuyokukaigoDiscountContena(){

    homonnyuyokukaigoDiscountContena.add(getHomonnyuyokukaigoDiscountRate(), VRLayout.FLOW);

    homonnyuyokukaigoDiscountContena.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addHomonnyuyokukaigoDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * コンポーネントを初期化します。
   * @throws Exception 初期化例外
   */
  private void initialize() throws Exception {
    initThis();
    addThis();
  }
  public boolean canBack(VRMap parameters) throws Exception {
    return true;
  }
  public Component getFirstFocusComponent() {
    return null;
  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.getInstance().getContentPane().add(new QO004002Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004002Design getThis() {
    return this;
  }
}
