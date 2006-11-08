
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
 * 作成日: 2006/05/02  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 介護予防通所介護 (QO004135)
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
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 介護予防通所介護画面項目デザイン(QO004135) 
 */
public class QO004135Design  extends QS001ServicePanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACClearableRadioButtonGroup functionImprovement;

  private ACLabelContainer functionImprovementContainer;

  private ACListModelAdapter functionImprovementModel;

  private ACRadioButtonItem functionImprovementItem1;

  private ACRadioButtonItem functionImprovementItem2;

  private ACClearableRadioButtonGroup nourishmentImprovement;

  private ACLabelContainer nourishmentImprovementContainer;

  private ACListModelAdapter nourishmentImprovementModel;

  private ACRadioButtonItem nourishmentImprovementItem1;

  private ACRadioButtonItem nourishmentImprovementItem2;

  private ACClearableRadioButtonGroup mouthImprovementAdd;

  private ACLabelContainer mouthImprovementAddContainer;

  private ACListModelAdapter mouthImprovementAddModel;

  private ACRadioButtonItem mouthImprovementAddItem1;

  private ACRadioButtonItem mouthImprovementAddItem2;

  private ACClearableRadioButtonGroup providerEvaluation;

  private ACLabelContainer providerEvaluationContainer;

  private ACListModelAdapter providerEvaluationModel;

  private ACRadioButtonItem providerEvaluationItem1;

  private ACRadioButtonItem providerEvaluationItem2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("介護予防通所介護");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループを取得します。
   * @return 職員の欠員による減算の状況ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1650101");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループコンテナを取得します。
   * @return 職員の欠員による減算の状況ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルを取得します。
   * @return 職員の欠員による減算の状況ラジオグループモデル
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
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("なし");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("看護職員");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * 介護職員を取得します。
   * @return 介護職員
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("介護職員");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * 運動器機能向上体制ラジオグループを取得します。
   * @return 運動器機能向上体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getFunctionImprovement(){
    if(functionImprovement==null){

      functionImprovement = new ACClearableRadioButtonGroup();

      getFunctionImprovementContainer().setText("運動器機能向上体制");

      functionImprovement.setBindPath("1650102");

      functionImprovement.setUseClearButton(false);

      functionImprovement.setModel(getFunctionImprovementModel());

      addFunctionImprovement();
    }
    return functionImprovement;

  }

  /**
   * 運動器機能向上体制ラジオグループコンテナを取得します。
   * @return 運動器機能向上体制ラジオグループコンテナ
   */
  protected ACLabelContainer getFunctionImprovementContainer(){
    if(functionImprovementContainer==null){
      functionImprovementContainer = new ACLabelContainer();
      functionImprovementContainer.setFollowChildEnabled(true);
      functionImprovementContainer.setVAlignment(VRLayout.CENTER);
      functionImprovementContainer.add(getFunctionImprovement(), null);
    }
    return functionImprovementContainer;
  }

  /**
   * 運動器機能向上体制ラジオグループモデルを取得します。
   * @return 運動器機能向上体制ラジオグループモデル
   */
  protected ACListModelAdapter getFunctionImprovementModel(){
    if(functionImprovementModel==null){
      functionImprovementModel = new ACListModelAdapter();
      addFunctionImprovementModel();
    }
    return functionImprovementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getFunctionImprovementItem1(){
    if(functionImprovementItem1==null){

      functionImprovementItem1 = new ACRadioButtonItem();

      functionImprovementItem1.setText("なし");

      functionImprovementItem1.setGroup(getFunctionImprovement());

      functionImprovementItem1.setConstraints(VRLayout.FLOW);

      addFunctionImprovementItem1();
    }
    return functionImprovementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFunctionImprovementItem2(){
    if(functionImprovementItem2==null){

      functionImprovementItem2 = new ACRadioButtonItem();

      functionImprovementItem2.setText("あり");

      functionImprovementItem2.setGroup(getFunctionImprovement());

      functionImprovementItem2.setConstraints(VRLayout.FLOW);

      addFunctionImprovementItem2();
    }
    return functionImprovementItem2;

  }

  /**
   * 栄養改善体制ラジオグループを取得します。
   * @return 栄養改善体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getNourishmentImprovement(){
    if(nourishmentImprovement==null){

      nourishmentImprovement = new ACClearableRadioButtonGroup();

      getNourishmentImprovementContainer().setText("栄養改善体制");

      nourishmentImprovement.setBindPath("1650103");

      nourishmentImprovement.setUseClearButton(false);

      nourishmentImprovement.setModel(getNourishmentImprovementModel());

      addNourishmentImprovement();
    }
    return nourishmentImprovement;

  }

  /**
   * 栄養改善体制ラジオグループコンテナを取得します。
   * @return 栄養改善体制ラジオグループコンテナ
   */
  protected ACLabelContainer getNourishmentImprovementContainer(){
    if(nourishmentImprovementContainer==null){
      nourishmentImprovementContainer = new ACLabelContainer();
      nourishmentImprovementContainer.setFollowChildEnabled(true);
      nourishmentImprovementContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementContainer.add(getNourishmentImprovement(), null);
    }
    return nourishmentImprovementContainer;
  }

  /**
   * 栄養改善体制ラジオグループモデルを取得します。
   * @return 栄養改善体制ラジオグループモデル
   */
  protected ACListModelAdapter getNourishmentImprovementModel(){
    if(nourishmentImprovementModel==null){
      nourishmentImprovementModel = new ACListModelAdapter();
      addNourishmentImprovementModel();
    }
    return nourishmentImprovementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentImprovementItem1(){
    if(nourishmentImprovementItem1==null){

      nourishmentImprovementItem1 = new ACRadioButtonItem();

      nourishmentImprovementItem1.setText("なし");

      nourishmentImprovementItem1.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem1.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem1();
    }
    return nourishmentImprovementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentImprovementItem2(){
    if(nourishmentImprovementItem2==null){

      nourishmentImprovementItem2 = new ACRadioButtonItem();

      nourishmentImprovementItem2.setText("あり");

      nourishmentImprovementItem2.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem2.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem2();
    }
    return nourishmentImprovementItem2;

  }

  /**
   * 口腔機能向上体制ラジオグループを取得します。
   * @return 口腔機能向上体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getMouthImprovementAdd(){
    if(mouthImprovementAdd==null){

      mouthImprovementAdd = new ACClearableRadioButtonGroup();

      getMouthImprovementAddContainer().setText("口腔機能向上体制");

      mouthImprovementAdd.setBindPath("1650104");

      mouthImprovementAdd.setUseClearButton(false);

      mouthImprovementAdd.setModel(getMouthImprovementAddModel());

      addMouthImprovementAdd();
    }
    return mouthImprovementAdd;

  }

  /**
   * 口腔機能向上体制ラジオグループコンテナを取得します。
   * @return 口腔機能向上体制ラジオグループコンテナ
   */
  protected ACLabelContainer getMouthImprovementAddContainer(){
    if(mouthImprovementAddContainer==null){
      mouthImprovementAddContainer = new ACLabelContainer();
      mouthImprovementAddContainer.setFollowChildEnabled(true);
      mouthImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      mouthImprovementAddContainer.add(getMouthImprovementAdd(), null);
    }
    return mouthImprovementAddContainer;
  }

  /**
   * 口腔機能向上体制ラジオグループモデルを取得します。
   * @return 口腔機能向上体制ラジオグループモデル
   */
  protected ACListModelAdapter getMouthImprovementAddModel(){
    if(mouthImprovementAddModel==null){
      mouthImprovementAddModel = new ACListModelAdapter();
      addMouthImprovementAddModel();
    }
    return mouthImprovementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMouthImprovementAddItem1(){
    if(mouthImprovementAddItem1==null){

      mouthImprovementAddItem1 = new ACRadioButtonItem();

      mouthImprovementAddItem1.setText("なし");

      mouthImprovementAddItem1.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem1();
    }
    return mouthImprovementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMouthImprovementAddItem2(){
    if(mouthImprovementAddItem2==null){

      mouthImprovementAddItem2 = new ACRadioButtonItem();

      mouthImprovementAddItem2.setText("あり");

      mouthImprovementAddItem2.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem2();
    }
    return mouthImprovementAddItem2;

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループを取得します。
   * @return 事業所評価加算（申出）の有無ラジオグループ
   */
  public ACClearableRadioButtonGroup getProviderEvaluation(){
    if(providerEvaluation==null){

      providerEvaluation = new ACClearableRadioButtonGroup();

      getProviderEvaluationContainer().setText("事業所評価加算（申出）の有無");

      providerEvaluation.setBindPath("1650105");

      providerEvaluation.setUseClearButton(false);

      providerEvaluation.setModel(getProviderEvaluationModel());

      addProviderEvaluation();
    }
    return providerEvaluation;

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループコンテナを取得します。
   * @return 事業所評価加算（申出）の有無ラジオグループコンテナ
   */
  protected ACLabelContainer getProviderEvaluationContainer(){
    if(providerEvaluationContainer==null){
      providerEvaluationContainer = new ACLabelContainer();
      providerEvaluationContainer.setFollowChildEnabled(true);
      providerEvaluationContainer.setVAlignment(VRLayout.CENTER);
      providerEvaluationContainer.add(getProviderEvaluation(), null);
    }
    return providerEvaluationContainer;
  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループモデルを取得します。
   * @return 事業所評価加算（申出）の有無ラジオグループモデル
   */
  protected ACListModelAdapter getProviderEvaluationModel(){
    if(providerEvaluationModel==null){
      providerEvaluationModel = new ACListModelAdapter();
      addProviderEvaluationModel();
    }
    return providerEvaluationModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderEvaluationItem1(){
    if(providerEvaluationItem1==null){

      providerEvaluationItem1 = new ACRadioButtonItem();

      providerEvaluationItem1.setText("なし");

      providerEvaluationItem1.setGroup(getProviderEvaluation());

      providerEvaluationItem1.setConstraints(VRLayout.FLOW);

      addProviderEvaluationItem1();
    }
    return providerEvaluationItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderEvaluationItem2(){
    if(providerEvaluationItem2==null){

      providerEvaluationItem2 = new ACRadioButtonItem();

      providerEvaluationItem2.setText("あり");

      providerEvaluationItem2.setGroup(getProviderEvaluation());

      providerEvaluationItem2.setConstraints(VRLayout.FLOW);

      addProviderEvaluationItem2();
    }
    return providerEvaluationItem2;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("割引率");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

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
   * 社福減免対象事業者を取得します。
   * @return 社福減免対象事業者
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("社会福祉法人等の軽減制度");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

  }

  /**
   * コンストラクタです。
   */
  public QO004135Design() {

    try {
      initialize();

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addMainGroup(){

    mainGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getFunctionImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getProviderEvaluationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

  }

  /**
   * 職員の欠員による減算の状況ラジオグループに内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackItem1(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addStaffLackItem2(){

  }

  /**
   * 介護職員に内部項目を追加します。
   */
  protected void addStaffLackItem3(){

  }

  /**
   * 運動器機能向上体制ラジオグループに内部項目を追加します。
   */
  protected void addFunctionImprovement(){

  }

  /**
   * 運動器機能向上体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addFunctionImprovementModel(){

    getFunctionImprovementItem1().setButtonIndex(1);
    getFunctionImprovementModel().add(getFunctionImprovementItem1());

    getFunctionImprovementItem2().setButtonIndex(2);
    getFunctionImprovementModel().add(getFunctionImprovementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionImprovementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionImprovementItem2(){

  }

  /**
   * 栄養改善体制ラジオグループに内部項目を追加します。
   */
  protected void addNourishmentImprovement(){

  }

  /**
   * 栄養改善体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addNourishmentImprovementModel(){

    getNourishmentImprovementItem1().setButtonIndex(1);
    getNourishmentImprovementModel().add(getNourishmentImprovementItem1());

    getNourishmentImprovementItem2().setButtonIndex(2);
    getNourishmentImprovementModel().add(getNourishmentImprovementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentImprovementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentImprovementItem2(){

  }

  /**
   * 口腔機能向上体制ラジオグループに内部項目を追加します。
   */
  protected void addMouthImprovementAdd(){

  }

  /**
   * 口腔機能向上体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addMouthImprovementAddModel(){

    getMouthImprovementAddItem1().setButtonIndex(1);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem1());

    getMouthImprovementAddItem2().setButtonIndex(2);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMouthImprovementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMouthImprovementAddItem2(){

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループに内部項目を追加します。
   */
  protected void addProviderEvaluation(){

  }

  /**
   * 事業所評価加算（申出）の有無ラジオグループモデルに内部項目を追加します。
   */
  protected void addProviderEvaluationModel(){

    getProviderEvaluationItem1().setButtonIndex(1);
    getProviderEvaluationModel().add(getProviderEvaluationItem1());

    getProviderEvaluationItem2().setButtonIndex(2);
    getProviderEvaluationModel().add(getProviderEvaluationItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderEvaluationItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderEvaluationItem2(){

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addReduceRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 社福減免対象事業者に内部項目を追加します。
   */
  protected void addShahukuReduce(){

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
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO004135Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004135Design getThis() {
    return this;
  }
}
