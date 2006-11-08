
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
 * プログラム 訪問看護 (QO004003)
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
 * 訪問看護画面項目デザイン(QO004003) 
 */
public class QO004003Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox homonkangoGroup;

  private ACLabelContainer homonkangoDiscountContainer;

  private ACTextField homonkangoDiscountRate;

  private ACLabel percentSign;

  private ACClearableRadioButtonGroup homonkangoFacilitiesDivision;

  private ACLabelContainer homonkangoFacilitiesDivisionContainer;

  private ACListModelAdapter homonkangoFacilitiesDivisionModel;

  private ACRadioButtonItem homonkangoStation;

  private ACRadioButtonItem hospitalOrClinic;

  private ACClearableRadioButtonGroup homonkangoPressingRadio;

  private ACLabelContainer homonkangoPressingRadioContainer;

  private ACListModelAdapter homonkangoPressingRadioModel;

  private ACRadioButtonItem homonkangoPressingRadioItem1;

  private ACRadioButtonItem homonkangoPressingRadioItem2;

  private ACClearableRadioButtonGroup specialManagementSystem;

  private ACLabelContainer specialManagementSystemContainer;

  private ACListModelAdapter specialManagementSystemModel;

  private ACRadioButtonItem specialManagementSystemOn;

  private ACRadioButtonItem specialManagementSystemOff;

  private ACTextField managerName;

  private ACLabelContainer managerNameContainer;

  private ACGroupBox medicalTreatmentInsurance;

  private ACTextField medicalTreatmentInsuranceStationCode;

  private ACLabelContainer medicalTreatmentInsuranceStationCodeContainer;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getHomonkangoGroup(){
    if(homonkangoGroup==null){

      homonkangoGroup = new ACGroupBox();

      homonkangoGroup.setText("訪問看護");

      homonkangoGroup.setFollowChildEnabled(true);

      homonkangoGroup.setHgrid(500);

      addHomonkangoGroup();
    }
    return homonkangoGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getHomonkangoDiscountContainer(){
    if(homonkangoDiscountContainer==null){

      homonkangoDiscountContainer = new ACLabelContainer();

      homonkangoDiscountContainer.setText("割引率");

      homonkangoDiscountContainer.setFollowChildEnabled(true);

      addHomonkangoDiscountContainer();
    }
    return homonkangoDiscountContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getHomonkangoDiscountRate(){
    if(homonkangoDiscountRate==null){

      homonkangoDiscountRate = new ACTextField();

      homonkangoDiscountRate.setBindPath("REDUCT_RATE");

      homonkangoDiscountRate.setColumns(3);

      homonkangoDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      homonkangoDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      homonkangoDiscountRate.setIMEMode(InputSubset.LATIN);

      homonkangoDiscountRate.setMaxLength(3);

      addHomonkangoDiscountRate();
    }
    return homonkangoDiscountRate;

  }

  /**
   * %ラベルを取得します。
   * @return %ラベル
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
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getHomonkangoFacilitiesDivision(){
    if(homonkangoFacilitiesDivision==null){

      homonkangoFacilitiesDivision = new ACClearableRadioButtonGroup();

      getHomonkangoFacilitiesDivisionContainer().setText("施設区分");

      homonkangoFacilitiesDivision.setBindPath("1130101");

      homonkangoFacilitiesDivision.setModel(getHomonkangoFacilitiesDivisionModel());

      homonkangoFacilitiesDivision.setUseClearButton(false);

      addHomonkangoFacilitiesDivision();
    }
    return homonkangoFacilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getHomonkangoFacilitiesDivisionContainer(){
    if(homonkangoFacilitiesDivisionContainer==null){
      homonkangoFacilitiesDivisionContainer = new ACLabelContainer();
      homonkangoFacilitiesDivisionContainer.setFollowChildEnabled(true);
      homonkangoFacilitiesDivisionContainer.add(getHomonkangoFacilitiesDivision(), null);
    }
    return homonkangoFacilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getHomonkangoFacilitiesDivisionModel(){
    if(homonkangoFacilitiesDivisionModel==null){
      homonkangoFacilitiesDivisionModel = new ACListModelAdapter();
      addHomonkangoFacilitiesDivisionModel();
    }
    return homonkangoFacilitiesDivisionModel;
  }

  /**
   * 訪問看護ステーションを取得します。
   * @return 訪問看護ステーション
   */
  public ACRadioButtonItem getHomonkangoStation(){
    if(homonkangoStation==null){

      homonkangoStation = new ACRadioButtonItem();

      homonkangoStation.setText("訪問看護ステーション");

      homonkangoStation.setGroup(getHomonkangoFacilitiesDivision());

      addHomonkangoStation();
    }
    return homonkangoStation;

  }

  /**
   * 病院または診療所を取得します。
   * @return 病院または診療所
   */
  public ACRadioButtonItem getHospitalOrClinic(){
    if(hospitalOrClinic==null){

      hospitalOrClinic = new ACRadioButtonItem();

      hospitalOrClinic.setText("病院又は診療所");

      hospitalOrClinic.setGroup(getHomonkangoFacilitiesDivision());

      addHospitalOrClinic();
    }
    return hospitalOrClinic;

  }

  /**
   * 緊急時訪問看護加算体制を取得します。
   * @return 緊急時訪問看護加算体制
   */
  public ACClearableRadioButtonGroup getHomonkangoPressingRadio(){
    if(homonkangoPressingRadio==null){

      homonkangoPressingRadio = new ACClearableRadioButtonGroup();

      getHomonkangoPressingRadioContainer().setText("緊急時訪問看護加算体制");

      homonkangoPressingRadio.setBindPath("1130104");

      homonkangoPressingRadio.setModel(getHomonkangoPressingRadioModel());

      homonkangoPressingRadio.setUseClearButton(false);

      addHomonkangoPressingRadio();
    }
    return homonkangoPressingRadio;

  }

  /**
   * 緊急時訪問看護加算体制コンテナを取得します。
   * @return 緊急時訪問看護加算体制コンテナ
   */
  protected ACLabelContainer getHomonkangoPressingRadioContainer(){
    if(homonkangoPressingRadioContainer==null){
      homonkangoPressingRadioContainer = new ACLabelContainer();
      homonkangoPressingRadioContainer.setFollowChildEnabled(true);
      homonkangoPressingRadioContainer.add(getHomonkangoPressingRadio(), null);
    }
    return homonkangoPressingRadioContainer;
  }

  /**
   * 緊急時訪問看護加算体制モデルを取得します。
   * @return 緊急時訪問看護加算体制モデル
   */
  protected ACListModelAdapter getHomonkangoPressingRadioModel(){
    if(homonkangoPressingRadioModel==null){
      homonkangoPressingRadioModel = new ACListModelAdapter();
      addHomonkangoPressingRadioModel();
    }
    return homonkangoPressingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem1(){
    if(homonkangoPressingRadioItem1==null){

      homonkangoPressingRadioItem1 = new ACRadioButtonItem();

      homonkangoPressingRadioItem1.setText("なし");

      homonkangoPressingRadioItem1.setGroup(getHomonkangoPressingRadio());

      addHomonkangoPressingRadioItem1();
    }
    return homonkangoPressingRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem2(){
    if(homonkangoPressingRadioItem2==null){

      homonkangoPressingRadioItem2 = new ACRadioButtonItem();

      homonkangoPressingRadioItem2.setText("あり");

      homonkangoPressingRadioItem2.setGroup(getHomonkangoPressingRadio());

      addHomonkangoPressingRadioItem2();
    }
    return homonkangoPressingRadioItem2;

  }

  /**
   * 特別管理体制ラジオグループを取得します。
   * @return 特別管理体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getSpecialManagementSystem(){
    if(specialManagementSystem==null){

      specialManagementSystem = new ACClearableRadioButtonGroup();

      getSpecialManagementSystemContainer().setText("特別管理体制");

      specialManagementSystem.setBindPath("1130102");

      specialManagementSystem.setModel(getSpecialManagementSystemModel());

      specialManagementSystem.setUseClearButton(false);

      addSpecialManagementSystem();
    }
    return specialManagementSystem;

  }

  /**
   * 特別管理体制ラジオグループコンテナを取得します。
   * @return 特別管理体制ラジオグループコンテナ
   */
  protected ACLabelContainer getSpecialManagementSystemContainer(){
    if(specialManagementSystemContainer==null){
      specialManagementSystemContainer = new ACLabelContainer();
      specialManagementSystemContainer.setFollowChildEnabled(true);
      specialManagementSystemContainer.add(getSpecialManagementSystem(), null);
    }
    return specialManagementSystemContainer;
  }

  /**
   * 特別管理体制ラジオグループモデルを取得します。
   * @return 特別管理体制ラジオグループモデル
   */
  protected ACListModelAdapter getSpecialManagementSystemModel(){
    if(specialManagementSystemModel==null){
      specialManagementSystemModel = new ACListModelAdapter();
      addSpecialManagementSystemModel();
    }
    return specialManagementSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecialManagementSystemOn(){
    if(specialManagementSystemOn==null){

      specialManagementSystemOn = new ACRadioButtonItem();

      specialManagementSystemOn.setText("なし");

      specialManagementSystemOn.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemOn();
    }
    return specialManagementSystemOn;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSpecialManagementSystemOff(){
    if(specialManagementSystemOff==null){

      specialManagementSystemOff = new ACRadioButtonItem();

      specialManagementSystemOff.setText("あり");

      specialManagementSystemOff.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemOff();
    }
    return specialManagementSystemOff;

  }

  /**
   * 管理者氏名を取得します。
   * @return 管理者氏名
   */
  public ACTextField getManagerName(){
    if(managerName==null){

      managerName = new ACTextField();

      getManagerNameContainer().setText("管理者氏名");

      managerName.setBindPath("1130103");

      managerName.setColumns(11);

      managerName.setIMEMode(InputSubset.KANJI);

      managerName.setMaxLength(10);

      addManagerName();
    }
    return managerName;

  }

  /**
   * 管理者氏名コンテナを取得します。
   * @return 管理者氏名コンテナ
   */
  protected ACLabelContainer getManagerNameContainer(){
    if(managerNameContainer==null){
      managerNameContainer = new ACLabelContainer();
      managerNameContainer.setFollowChildEnabled(true);
      managerNameContainer.add(getManagerName(), null);
    }
    return managerNameContainer;
  }

  /**
   * ＜＜医療保険分＞＞を取得します。
   * @return ＜＜医療保険分＞＞
   */
  public ACGroupBox getMedicalTreatmentInsurance(){
    if(medicalTreatmentInsurance==null){

      medicalTreatmentInsurance = new ACGroupBox();

      medicalTreatmentInsurance.setText("医療保険分");

      medicalTreatmentInsurance.setFollowChildEnabled(true);

      addMedicalTreatmentInsurance();
    }
    return medicalTreatmentInsurance;

  }

  /**
   * ステーションコードを取得します。
   * @return ステーションコード
   */
  public ACTextField getMedicalTreatmentInsuranceStationCode(){
    if(medicalTreatmentInsuranceStationCode==null){

      medicalTreatmentInsuranceStationCode = new ACTextField();

      getMedicalTreatmentInsuranceStationCodeContainer().setText("ステーションコード");

      medicalTreatmentInsuranceStationCode.setBindPath("2010101");

      medicalTreatmentInsuranceStationCode.setCharType(VRCharType.ONLY_DIGIT);

      medicalTreatmentInsuranceStationCode.setColumns(5);

      medicalTreatmentInsuranceStationCode.setIMEMode(InputSubset.LATIN);

      medicalTreatmentInsuranceStationCode.setMaxLength(7);

      addMedicalTreatmentInsuranceStationCode();
    }
    return medicalTreatmentInsuranceStationCode;

  }

  /**
   * ステーションコードコンテナを取得します。
   * @return ステーションコードコンテナ
   */
  protected ACLabelContainer getMedicalTreatmentInsuranceStationCodeContainer(){
    if(medicalTreatmentInsuranceStationCodeContainer==null){
      medicalTreatmentInsuranceStationCodeContainer = new ACLabelContainer();
      medicalTreatmentInsuranceStationCodeContainer.setFollowChildEnabled(true);
      medicalTreatmentInsuranceStationCodeContainer.add(getMedicalTreatmentInsuranceStationCode(), null);
    }
    return medicalTreatmentInsuranceStationCodeContainer;
  }

  /**
   * コンストラクタです。
   */
  public QO004003Design() {

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

    this.add(getHomonkangoGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addHomonkangoGroup(){

    homonkangoGroup.add(getHomonkangoDiscountContainer(), VRLayout.FLOW_RETURN);

    homonkangoGroup.add(getHomonkangoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonkangoGroup.add(getHomonkangoPressingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonkangoGroup.add(getSpecialManagementSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonkangoGroup.add(getManagerNameContainer(), VRLayout.FLOW_RETURN);

    homonkangoGroup.add(getMedicalTreatmentInsurance(), VRLayout.FLOW_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addHomonkangoDiscountContainer(){

    homonkangoDiscountContainer.add(getHomonkangoDiscountRate(), VRLayout.FLOW);

    homonkangoDiscountContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addHomonkangoDiscountRate(){

  }

  /**
   * %ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addHomonkangoFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addHomonkangoFacilitiesDivisionModel(){

    getHomonkangoStation().setButtonIndex(1);
    getHomonkangoFacilitiesDivisionModel().add(getHomonkangoStation());

    getHospitalOrClinic().setButtonIndex(2);
    getHomonkangoFacilitiesDivisionModel().add(getHospitalOrClinic());

  }

  /**
   * 訪問看護ステーションに内部項目を追加します。
   */
  protected void addHomonkangoStation(){

  }

  /**
   * 病院または診療所に内部項目を追加します。
   */
  protected void addHospitalOrClinic(){

  }

  /**
   * 緊急時訪問看護加算体制に内部項目を追加します。
   */
  protected void addHomonkangoPressingRadio(){

  }

  /**
   * 緊急時訪問看護加算体制モデルに内部項目を追加します。
   */
  protected void addHomonkangoPressingRadioModel(){

    getHomonkangoPressingRadioItem1().setButtonIndex(1);
    getHomonkangoPressingRadioModel().add(getHomonkangoPressingRadioItem1());

    getHomonkangoPressingRadioItem2().setButtonIndex(2);
    getHomonkangoPressingRadioModel().add(getHomonkangoPressingRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHomonkangoPressingRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHomonkangoPressingRadioItem2(){

  }

  /**
   * 特別管理体制ラジオグループに内部項目を追加します。
   */
  protected void addSpecialManagementSystem(){

  }

  /**
   * 特別管理体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addSpecialManagementSystemModel(){

    getSpecialManagementSystemOn().setButtonIndex(1);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemOn());

    getSpecialManagementSystemOff().setButtonIndex(2);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemOff());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecialManagementSystemOn(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSpecialManagementSystemOff(){

  }

  /**
   * 管理者氏名に内部項目を追加します。
   */
  protected void addManagerName(){

  }

  /**
   * ＜＜医療保険分＞＞に内部項目を追加します。
   */
  protected void addMedicalTreatmentInsurance(){

    medicalTreatmentInsurance.add(getMedicalTreatmentInsuranceStationCodeContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ステーションコードに内部項目を追加します。
   */
  protected void addMedicalTreatmentInsuranceStationCode(){

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
      ACFrame.getInstance().getContentPane().add(new QO004003Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004003Design getThis() {
    return this;
  }
}
