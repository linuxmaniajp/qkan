
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
 * プログラム 訪問リハ (QO004004)
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
import jp.or.med.orca.qkan.text.*;
/**
 * 訪問リハ画面項目デザイン(QO004004) 
 */
public class QO004004Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox homonrehabilitationGroup;

  private ACLabelContainer homonrehabilitationDiscountContainer;

  private ACTextField homonrehabilitationDiscountRate;

  private ACLabel homonrehabilitationPercentSign;

  private ACClearableRadioButtonGroup homonrehabilitationInstitutionDivisionRadio;

  private ACLabelContainer homonrehabilitationInstitutionDivisionRadioContainer;

  private ACListModelAdapter homonrehabilitationInstitutionDivisionRadioModel;

  private ACRadioButtonItem homonrehabilitationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem homonrehabilitationInstitutionDivisionRadioItem2;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getHomonrehabilitationGroup(){
    if(homonrehabilitationGroup==null){

      homonrehabilitationGroup = new ACGroupBox();

      homonrehabilitationGroup.setText("訪問リハビリテーション");

      homonrehabilitationGroup.setFollowChildEnabled(true);

      addHomonrehabilitationGroup();
    }
    return homonrehabilitationGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getHomonrehabilitationDiscountContainer(){
    if(homonrehabilitationDiscountContainer==null){

      homonrehabilitationDiscountContainer = new ACLabelContainer();

      homonrehabilitationDiscountContainer.setText("割引率");

      homonrehabilitationDiscountContainer.setFollowChildEnabled(true);

      addHomonrehabilitationDiscountContainer();
    }
    return homonrehabilitationDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getHomonrehabilitationDiscountRate(){
    if(homonrehabilitationDiscountRate==null){

      homonrehabilitationDiscountRate = new ACTextField();

      homonrehabilitationDiscountRate.setBindPath("REDUCT_RATE");

      homonrehabilitationDiscountRate.setColumns(3);

      homonrehabilitationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      homonrehabilitationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      homonrehabilitationDiscountRate.setIMEMode(InputSubset.LATIN);

      homonrehabilitationDiscountRate.setMaxLength(3);

      addHomonrehabilitationDiscountRate();
    }
    return homonrehabilitationDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getHomonrehabilitationPercentSign(){
    if(homonrehabilitationPercentSign==null){

      homonrehabilitationPercentSign = new ACLabel();

      homonrehabilitationPercentSign.setText("％");

      addHomonrehabilitationPercentSign();
    }
    return homonrehabilitationPercentSign;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getHomonrehabilitationInstitutionDivisionRadio(){
    if(homonrehabilitationInstitutionDivisionRadio==null){

      homonrehabilitationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getHomonrehabilitationInstitutionDivisionRadioContainer().setText("施設区分");

      homonrehabilitationInstitutionDivisionRadio.setBindPath("1140101");

      homonrehabilitationInstitutionDivisionRadio.setModel(getHomonrehabilitationInstitutionDivisionRadioModel());

      homonrehabilitationInstitutionDivisionRadio.setUseClearButton(false);

      addHomonrehabilitationInstitutionDivisionRadio();
    }
    return homonrehabilitationInstitutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getHomonrehabilitationInstitutionDivisionRadioContainer(){
    if(homonrehabilitationInstitutionDivisionRadioContainer==null){
      homonrehabilitationInstitutionDivisionRadioContainer = new ACLabelContainer();
      homonrehabilitationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      homonrehabilitationInstitutionDivisionRadioContainer.add(getHomonrehabilitationInstitutionDivisionRadio(), null);
    }
    return homonrehabilitationInstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getHomonrehabilitationInstitutionDivisionRadioModel(){
    if(homonrehabilitationInstitutionDivisionRadioModel==null){
      homonrehabilitationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addHomonrehabilitationInstitutionDivisionRadioModel();
    }
    return homonrehabilitationInstitutionDivisionRadioModel;
  }

  /**
   * 病院または診療所を取得します。
   * @return 病院または診療所
   */
  public ACRadioButtonItem getHomonrehabilitationInstitutionDivisionRadioItem1(){
    if(homonrehabilitationInstitutionDivisionRadioItem1==null){

      homonrehabilitationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      homonrehabilitationInstitutionDivisionRadioItem1.setText("病院又は診療所");

      homonrehabilitationInstitutionDivisionRadioItem1.setGroup(getHomonrehabilitationInstitutionDivisionRadio());

      homonrehabilitationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addHomonrehabilitationInstitutionDivisionRadioItem1();
    }
    return homonrehabilitationInstitutionDivisionRadioItem1;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getHomonrehabilitationInstitutionDivisionRadioItem2(){
    if(homonrehabilitationInstitutionDivisionRadioItem2==null){

      homonrehabilitationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      homonrehabilitationInstitutionDivisionRadioItem2.setText("介護老人保健施設");

      homonrehabilitationInstitutionDivisionRadioItem2.setGroup(getHomonrehabilitationInstitutionDivisionRadio());

      homonrehabilitationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addHomonrehabilitationInstitutionDivisionRadioItem2();
    }
    return homonrehabilitationInstitutionDivisionRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QO004004Design() {

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

    this.add(getHomonrehabilitationGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addHomonrehabilitationGroup(){

    homonrehabilitationGroup.add(getHomonrehabilitationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonrehabilitationGroup.add(getHomonrehabilitationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addHomonrehabilitationDiscountContainer(){

    homonrehabilitationDiscountContainer.add(getHomonrehabilitationDiscountRate(), VRLayout.FLOW);

    homonrehabilitationDiscountContainer.add(getHomonrehabilitationPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addHomonrehabilitationDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addHomonrehabilitationPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addHomonrehabilitationInstitutionDivisionRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addHomonrehabilitationInstitutionDivisionRadioModel(){

    getHomonrehabilitationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getHomonrehabilitationInstitutionDivisionRadioModel().add(getHomonrehabilitationInstitutionDivisionRadioItem1());

    getHomonrehabilitationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getHomonrehabilitationInstitutionDivisionRadioModel().add(getHomonrehabilitationInstitutionDivisionRadioItem2());

  }

  /**
   * 病院または診療所に内部項目を追加します。
   */
  protected void addHomonrehabilitationInstitutionDivisionRadioItem1(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addHomonrehabilitationInstitutionDivisionRadioItem2(){

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
      ACFrame.getInstance().getContentPane().add(new QO004004Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004004Design getThis() {
    return this;
  }
}
