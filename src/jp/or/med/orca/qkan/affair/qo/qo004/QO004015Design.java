
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
 * プログラム 特定施設入所者介護 (QO004015)
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
 * 特定施設入所者介護画面項目デザイン(QO004015) 
 */
public class QO004015Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox specificFacilityGroup;

  private ACLabelContainer specificFacilityDiscountContainer;

  private ACTextField specificFacilityDiscountRate;

  private ACLabel specificFacilityDiscountPercentSign;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemOff;

  private ACRadioButtonItem functionTrainingGuidanceSystemOn;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackOff;

  private ACRadioButtonItem staffLackKango;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getSpecificFacilityGroup(){
    if(specificFacilityGroup==null){

      specificFacilityGroup = new ACGroupBox();

      specificFacilityGroup.setText("特定施設入所者介護");

      specificFacilityGroup.setFollowChildEnabled(true);

      specificFacilityGroup.setHgrid(200);

      addSpecificFacilityGroup();
    }
    return specificFacilityGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getSpecificFacilityDiscountContainer(){
    if(specificFacilityDiscountContainer==null){

      specificFacilityDiscountContainer = new ACLabelContainer();

      specificFacilityDiscountContainer.setText("割引率");

      specificFacilityDiscountContainer.setFollowChildEnabled(true);

      addSpecificFacilityDiscountContainer();
    }
    return specificFacilityDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getSpecificFacilityDiscountRate(){
    if(specificFacilityDiscountRate==null){

      specificFacilityDiscountRate = new ACTextField();

      specificFacilityDiscountRate.setBindPath("REDUCT_RATE");

      specificFacilityDiscountRate.setColumns(3);

      specificFacilityDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      specificFacilityDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      specificFacilityDiscountRate.setIMEMode(InputSubset.LATIN);

      specificFacilityDiscountRate.setMaxLength(3);

      addSpecificFacilityDiscountRate();
    }
    return specificFacilityDiscountRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getSpecificFacilityDiscountPercentSign(){
    if(specificFacilityDiscountPercentSign==null){

      specificFacilityDiscountPercentSign = new ACLabel();

      specificFacilityDiscountPercentSign.setText("％");

      addSpecificFacilityDiscountPercentSign();
    }
    return specificFacilityDiscountPercentSign;

  }

  /**
   * 機能訓練指導体制ラジオグループを取得します。
   * @return 機能訓練指導体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("機能訓練指導体制");

      functionTrainingGuidanceSystem.setBindPath("1330101");

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setUseClearButton(false);

      addFunctionTrainingGuidanceSystem();
    }
    return functionTrainingGuidanceSystem;

  }

  /**
   * 機能訓練指導体制ラジオグループコンテナを取得します。
   * @return 機能訓練指導体制ラジオグループコンテナ
   */
  protected ACLabelContainer getFunctionTrainingGuidanceSystemContainer(){
    if(functionTrainingGuidanceSystemContainer==null){
      functionTrainingGuidanceSystemContainer = new ACLabelContainer();
      functionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      functionTrainingGuidanceSystemContainer.add(getFunctionTrainingGuidanceSystem(), null);
    }
    return functionTrainingGuidanceSystemContainer;
  }

  /**
   * 機能訓練指導体制ラジオグループモデルを取得します。
   * @return 機能訓練指導体制ラジオグループモデル
   */
  protected ACListModelAdapter getFunctionTrainingGuidanceSystemModel(){
    if(functionTrainingGuidanceSystemModel==null){
      functionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addFunctionTrainingGuidanceSystemModel();
    }
    return functionTrainingGuidanceSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOff(){
    if(functionTrainingGuidanceSystemOff==null){

      functionTrainingGuidanceSystemOff = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOff.setText("なし");

      functionTrainingGuidanceSystemOff.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOff();
    }
    return functionTrainingGuidanceSystemOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemOn(){
    if(functionTrainingGuidanceSystemOn==null){

      functionTrainingGuidanceSystemOn = new ACRadioButtonItem();

      functionTrainingGuidanceSystemOn.setText("あり");

      functionTrainingGuidanceSystemOn.setGroup(getFunctionTrainingGuidanceSystem());

      addFunctionTrainingGuidanceSystemOn();
    }
    return functionTrainingGuidanceSystemOn;

  }

  /**
   * 人員減算ラジオグループを取得します。
   * @return 人員減算ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("人員減算");

      staffLack.setBindPath("1330102");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 人員減算ラジオグループコンテナを取得します。
   * @return 人員減算ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * 人員減算ラジオグループモデルを取得します。
   * @return 人員減算ラジオグループモデル
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffLackOff(){
    if(staffLackOff==null){

      staffLackOff = new ACRadioButtonItem();

      staffLackOff.setText("なし");

      staffLackOff.setGroup(getStaffLack());

      addStaffLackOff();
    }
    return staffLackOff;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getStaffLackKango(){
    if(staffLackKango==null){

      staffLackKango = new ACRadioButtonItem();

      staffLackKango.setText("看護・介護職員の不足");

      staffLackKango.setGroup(getStaffLack());

      addStaffLackKango();
    }
    return staffLackKango;

  }

  /**
   * コンストラクタです。
   */
  public QO004015Design() {

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

    this.add(getSpecificFacilityGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addSpecificFacilityGroup(){

    specificFacilityGroup.add(getSpecificFacilityDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    specificFacilityGroup.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    specificFacilityGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addSpecificFacilityDiscountContainer(){

    specificFacilityDiscountContainer.add(getSpecificFacilityDiscountRate(), VRLayout.FLOW);

    specificFacilityDiscountContainer.add(getSpecificFacilityDiscountPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addSpecificFacilityDiscountRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addSpecificFacilityDiscountPercentSign(){

  }

  /**
   * 機能訓練指導体制ラジオグループに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystem(){

  }

  /**
   * 機能訓練指導体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemModel(){

    getFunctionTrainingGuidanceSystemOff().setButtonIndex(1);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOff());

    getFunctionTrainingGuidanceSystemOn().setButtonIndex(2);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemOn(){

  }

  /**
   * 人員減算ラジオグループに内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 人員減算ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

    getStaffLackOff().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackOff());

    getStaffLackKango().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackKango());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackOff(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addStaffLackKango(){

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
      ACFrame.getInstance().getContentPane().add(new QO004015Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004015Design getThis() {
    return this;
  }
}
