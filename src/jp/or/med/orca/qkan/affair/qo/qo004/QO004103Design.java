
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
 * 開発者: 松本　幸一
 * 作成日: 2006/03/08  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 訪問看護 (QO004103)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
/**
 * 訪問看護画面項目デザイン(QO004103) 
 */
public class QO004103Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACPanel calculationDetails;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACClearableRadioButtonGroup homonkangoPressing;

  private ACLabelContainer homonkangoPressingContainer;

  private ACListModelAdapter homonkangoPressingModel;

  private ACRadioButtonItem homonkangoPressingRadioItem1;

  private ACRadioButtonItem homonkangoPressingRadioItem2;

  private ACClearableRadioButtonGroup specialManagementSystem;

  private ACLabelContainer specialManagementSystemContainer;

  private ACListModelAdapter specialManagementSystemModel;

  private ACRadioButtonItem specialManagementSystemItem1;

  private ACRadioButtonItem specialManagementSystemItem2;

  private ACClearableRadioButtonGroup terminalCare;

  private ACLabelContainer terminalCareContainer;

  private ACListModelAdapter terminalCareModel;

  private ACRadioButtonItem terminalCareItem1;

  private ACRadioButtonItem terminalCareItem2;

  private ACTextField managerName;

  private ACLabelContainer managerNameContainer;

  private ACGroupBox medicalTreatmentInsurance;

  private ACTextField stationCode;

  private ACLabelContainer stationCodeContainer;

  private ACClearableRadioButtonGroup contactAllDay;

  private ACLabelContainer contactAllDayContainer;

  private ACListModelAdapter contactAllDayModel;

  private ACRadioButtonItem contactAllDayItem1;

  private ACRadioButtonItem contactAllDayItem2;

  private ACClearableRadioButtonGroup seriousCaseManagement;

  private ACLabelContainer seriousCaseManagementContainer;

  private ACListModelAdapter seriousCaseManagementModel;

  private ACRadioButtonItem seriousCaseManagementItem1;

  private ACRadioButtonItem seriousCaseManagementItem2;

  private ACPanel calculationDetails2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("訪問看護");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 算定項目領域を取得します。
   * @return 算定項目領域
   */
  public ACPanel getCalculationDetails(){
    if(calculationDetails==null){

      calculationDetails = new ACPanel();

      calculationDetails.setFollowChildEnabled(true);

      calculationDetails.setHgrid(200);

      addCalculationDetails();
    }
    return calculationDetails;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1130101");

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setUseClearButton(false);

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){
      facilitiesDivisionContainer = new ACLabelContainer();
      facilitiesDivisionContainer.setFollowChildEnabled(true);
      facilitiesDivisionContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionContainer.add(getFacilitiesDivision(), null);
    }
    return facilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * 訪問看護ステーションを取得します。
   * @return 訪問看護ステーション
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("訪問看護ステーション");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 病院または診療所を取得します。
   * @return 病院または診療所
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("病院又は診療所");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 緊急時訪問看護加算を取得します。
   * @return 緊急時訪問看護加算
   */
  public ACClearableRadioButtonGroup getHomonkangoPressing(){
    if(homonkangoPressing==null){

      homonkangoPressing = new ACClearableRadioButtonGroup();

      getHomonkangoPressingContainer().setText("緊急時訪問看護加算");

      homonkangoPressing.setBindPath("1130104");

      homonkangoPressing.setModel(getHomonkangoPressingModel());

      homonkangoPressing.setUseClearButton(false);

      addHomonkangoPressing();
    }
    return homonkangoPressing;

  }

  /**
   * 緊急時訪問看護加算コンテナを取得します。
   * @return 緊急時訪問看護加算コンテナ
   */
  protected ACLabelContainer getHomonkangoPressingContainer(){
    if(homonkangoPressingContainer==null){
      homonkangoPressingContainer = new ACLabelContainer();
      homonkangoPressingContainer.setFollowChildEnabled(true);
      homonkangoPressingContainer.setVAlignment(VRLayout.CENTER);
      homonkangoPressingContainer.add(getHomonkangoPressing(), null);
    }
    return homonkangoPressingContainer;
  }

  /**
   * 緊急時訪問看護加算モデルを取得します。
   * @return 緊急時訪問看護加算モデル
   */
  protected ACListModelAdapter getHomonkangoPressingModel(){
    if(homonkangoPressingModel==null){
      homonkangoPressingModel = new ACListModelAdapter();
      addHomonkangoPressingModel();
    }
    return homonkangoPressingModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHomonkangoPressingRadioItem1(){
    if(homonkangoPressingRadioItem1==null){

      homonkangoPressingRadioItem1 = new ACRadioButtonItem();

      homonkangoPressingRadioItem1.setText("なし");

      homonkangoPressingRadioItem1.setGroup(getHomonkangoPressing());

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

      homonkangoPressingRadioItem2.setGroup(getHomonkangoPressing());

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
      specialManagementSystemContainer.setVAlignment(VRLayout.CENTER);
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
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getSpecialManagementSystemItem1(){
    if(specialManagementSystemItem1==null){

      specialManagementSystemItem1 = new ACRadioButtonItem();

      specialManagementSystemItem1.setText("対応不可");

      specialManagementSystemItem1.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemItem1();
    }
    return specialManagementSystemItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getSpecialManagementSystemItem2(){
    if(specialManagementSystemItem2==null){

      specialManagementSystemItem2 = new ACRadioButtonItem();

      specialManagementSystemItem2.setText("対応可");

      specialManagementSystemItem2.setGroup(getSpecialManagementSystem());

      addSpecialManagementSystemItem2();
    }
    return specialManagementSystemItem2;

  }

  /**
   * ターミナルケア体制ラジオグループを取得します。
   * @return ターミナルケア体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getTerminalCare(){
    if(terminalCare==null){

      terminalCare = new ACClearableRadioButtonGroup();

      getTerminalCareContainer().setText("ターミナルケア体制");

      terminalCare.setBindPath("1130105");

      terminalCare.setModel(getTerminalCareModel());

      terminalCare.setUseClearButton(false);

      addTerminalCare();
    }
    return terminalCare;

  }

  /**
   * ターミナルケア体制ラジオグループコンテナを取得します。
   * @return ターミナルケア体制ラジオグループコンテナ
   */
  protected ACLabelContainer getTerminalCareContainer(){
    if(terminalCareContainer==null){
      terminalCareContainer = new ACLabelContainer();
      terminalCareContainer.setFollowChildEnabled(true);
      terminalCareContainer.setVAlignment(VRLayout.CENTER);
      terminalCareContainer.add(getTerminalCare(), null);
    }
    return terminalCareContainer;
  }

  /**
   * ターミナルケア体制ラジオグループモデルを取得します。
   * @return ターミナルケア体制ラジオグループモデル
   */
  protected ACListModelAdapter getTerminalCareModel(){
    if(terminalCareModel==null){
      terminalCareModel = new ACListModelAdapter();
      addTerminalCareModel();
    }
    return terminalCareModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTerminalCareItem1(){
    if(terminalCareItem1==null){

      terminalCareItem1 = new ACRadioButtonItem();

      terminalCareItem1.setText("なし");

      terminalCareItem1.setGroup(getTerminalCare());

      addTerminalCareItem1();
    }
    return terminalCareItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTerminalCareItem2(){
    if(terminalCareItem2==null){

      terminalCareItem2 = new ACRadioButtonItem();

      terminalCareItem2.setText("あり");

      terminalCareItem2.setGroup(getTerminalCare());

      addTerminalCareItem2();
    }
    return terminalCareItem2;

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
      managerNameContainer.setVAlignment(VRLayout.CENTER);
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
  public ACTextField getStationCode(){
    if(stationCode==null){

      stationCode = new ACTextField();

      getStationCodeContainer().setText("ステーションコード");

      stationCode.setBindPath("2010101");

      stationCode.setCharType(VRCharType.ONLY_DIGIT);

      stationCode.setColumns(5);

      stationCode.setIMEMode(InputSubset.LATIN);

      stationCode.setMaxLength(7);

      addStationCode();
    }
    return stationCode;

  }

  /**
   * ステーションコードコンテナを取得します。
   * @return ステーションコードコンテナ
   */
  protected ACLabelContainer getStationCodeContainer(){
    if(stationCodeContainer==null){
      stationCodeContainer = new ACLabelContainer();
      stationCodeContainer.setFollowChildEnabled(true);
      stationCodeContainer.setVAlignment(VRLayout.CENTER);
      stationCodeContainer.add(getStationCode(), null);
    }
    return stationCodeContainer;
  }

  /**
   * 24時間連絡体制加算ラジオグループを取得します。
   * @return 24時間連絡体制加算ラジオグループ
   */
  public ACClearableRadioButtonGroup getContactAllDay(){
    if(contactAllDay==null){

      contactAllDay = new ACClearableRadioButtonGroup();

      getContactAllDayContainer().setText("24時間連絡体制加算");

      contactAllDay.setBindPath("2010102");

      contactAllDay.setModel(getContactAllDayModel());

      contactAllDay.setUseClearButton(false);

      addContactAllDay();
    }
    return contactAllDay;

  }

  /**
   * 24時間連絡体制加算ラジオグループコンテナを取得します。
   * @return 24時間連絡体制加算ラジオグループコンテナ
   */
  protected ACLabelContainer getContactAllDayContainer(){
    if(contactAllDayContainer==null){
      contactAllDayContainer = new ACLabelContainer();
      contactAllDayContainer.setFollowChildEnabled(true);
      contactAllDayContainer.setVAlignment(VRLayout.CENTER);
      contactAllDayContainer.add(getContactAllDay(), null);
    }
    return contactAllDayContainer;
  }

  /**
   * 24時間連絡体制加算ラジオグループモデルを取得します。
   * @return 24時間連絡体制加算ラジオグループモデル
   */
  protected ACListModelAdapter getContactAllDayModel(){
    if(contactAllDayModel==null){
      contactAllDayModel = new ACListModelAdapter();
      addContactAllDayModel();
    }
    return contactAllDayModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getContactAllDayItem1(){
    if(contactAllDayItem1==null){

      contactAllDayItem1 = new ACRadioButtonItem();

      contactAllDayItem1.setText("なし");

      contactAllDayItem1.setGroup(getContactAllDay());

      addContactAllDayItem1();
    }
    return contactAllDayItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getContactAllDayItem2(){
    if(contactAllDayItem2==null){

      contactAllDayItem2 = new ACRadioButtonItem();

      contactAllDayItem2.setText("あり");

      contactAllDayItem2.setGroup(getContactAllDay());

      addContactAllDayItem2();
    }
    return contactAllDayItem2;

  }

  /**
   * 重症者管理加算ラジオグループを取得します。
   * @return 重症者管理加算ラジオグループ
   */
  public ACClearableRadioButtonGroup getSeriousCaseManagement(){
    if(seriousCaseManagement==null){

      seriousCaseManagement = new ACClearableRadioButtonGroup();

      getSeriousCaseManagementContainer().setText("重症者管理加算");

      seriousCaseManagement.setBindPath("2010103");

      seriousCaseManagement.setModel(getSeriousCaseManagementModel());

      seriousCaseManagement.setUseClearButton(false);

      addSeriousCaseManagement();
    }
    return seriousCaseManagement;

  }

  /**
   * 重症者管理加算ラジオグループコンテナを取得します。
   * @return 重症者管理加算ラジオグループコンテナ
   */
  protected ACLabelContainer getSeriousCaseManagementContainer(){
    if(seriousCaseManagementContainer==null){
      seriousCaseManagementContainer = new ACLabelContainer();
      seriousCaseManagementContainer.setFollowChildEnabled(true);
      seriousCaseManagementContainer.setVAlignment(VRLayout.CENTER);
      seriousCaseManagementContainer.add(getSeriousCaseManagement(), null);
    }
    return seriousCaseManagementContainer;
  }

  /**
   * 重症者管理加算ラジオグループモデルを取得します。
   * @return 重症者管理加算ラジオグループモデル
   */
  protected ACListModelAdapter getSeriousCaseManagementModel(){
    if(seriousCaseManagementModel==null){
      seriousCaseManagementModel = new ACListModelAdapter();
      addSeriousCaseManagementModel();
    }
    return seriousCaseManagementModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSeriousCaseManagementItem1(){
    if(seriousCaseManagementItem1==null){

      seriousCaseManagementItem1 = new ACRadioButtonItem();

      seriousCaseManagementItem1.setText("なし");

      seriousCaseManagementItem1.setGroup(getSeriousCaseManagement());

      addSeriousCaseManagementItem1();
    }
    return seriousCaseManagementItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSeriousCaseManagementItem2(){
    if(seriousCaseManagementItem2==null){

      seriousCaseManagementItem2 = new ACRadioButtonItem();

      seriousCaseManagementItem2.setText("あり");

      seriousCaseManagementItem2.setGroup(getSeriousCaseManagement());

      addSeriousCaseManagementItem2();
    }
    return seriousCaseManagementItem2;

  }

  /**
   * 算定項目領域2を取得します。
   * @return 算定項目領域2
   */
  public ACPanel getCalculationDetails2(){
    if(calculationDetails2==null){

      calculationDetails2 = new ACPanel();

      calculationDetails2.setFollowChildEnabled(true);

      calculationDetails2.setHgrid(200);

      addCalculationDetails2();
    }
    return calculationDetails2;

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
   * コンストラクタです。
   */
  public QO004103Design() {

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

    mainGroup.add(getCalculationDetails(), VRLayout.NORTH);

    mainGroup.add(getMedicalTreatmentInsurance(), VRLayout.NORTH);

    mainGroup.add(getCalculationDetails2(), VRLayout.NORTH);

  }

  /**
   * 算定項目領域に内部項目を追加します。
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getHomonkangoPressingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getSpecialManagementSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getTerminalCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getManagerNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addFacilitiesDivisionModel(){

    getFacilitiesDivisionItem1().setButtonIndex(1);
    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem1());

    getFacilitiesDivisionItem2().setButtonIndex(2);
    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem2());

  }

  /**
   * 訪問看護ステーションに内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 病院または診療所に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 緊急時訪問看護加算に内部項目を追加します。
   */
  protected void addHomonkangoPressing(){

  }

  /**
   * 緊急時訪問看護加算モデルに内部項目を追加します。
   */
  protected void addHomonkangoPressingModel(){

    getHomonkangoPressingRadioItem1().setButtonIndex(1);
    getHomonkangoPressingModel().add(getHomonkangoPressingRadioItem1());

    getHomonkangoPressingRadioItem2().setButtonIndex(2);
    getHomonkangoPressingModel().add(getHomonkangoPressingRadioItem2());

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

    getSpecialManagementSystemItem1().setButtonIndex(1);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemItem1());

    getSpecialManagementSystemItem2().setButtonIndex(2);
    getSpecialManagementSystemModel().add(getSpecialManagementSystemItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addSpecialManagementSystemItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addSpecialManagementSystemItem2(){

  }

  /**
   * ターミナルケア体制ラジオグループに内部項目を追加します。
   */
  protected void addTerminalCare(){

  }

  /**
   * ターミナルケア体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addTerminalCareModel(){

    getTerminalCareItem1().setButtonIndex(1);
    getTerminalCareModel().add(getTerminalCareItem1());

    getTerminalCareItem2().setButtonIndex(2);
    getTerminalCareModel().add(getTerminalCareItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTerminalCareItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTerminalCareItem2(){

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

    medicalTreatmentInsurance.add(getStationCodeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentInsurance.add(getContactAllDayContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalTreatmentInsurance.add(getSeriousCaseManagementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ステーションコードに内部項目を追加します。
   */
  protected void addStationCode(){

  }

  /**
   * 24時間連絡体制加算ラジオグループに内部項目を追加します。
   */
  protected void addContactAllDay(){

  }

  /**
   * 24時間連絡体制加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addContactAllDayModel(){

    getContactAllDayItem1().setButtonIndex(1);
    getContactAllDayModel().add(getContactAllDayItem1());

    getContactAllDayItem2().setButtonIndex(2);
    getContactAllDayModel().add(getContactAllDayItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addContactAllDayItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addContactAllDayItem2(){

  }

  /**
   * 重症者管理加算ラジオグループに内部項目を追加します。
   */
  protected void addSeriousCaseManagement(){

  }

  /**
   * 重症者管理加算ラジオグループモデルに内部項目を追加します。
   */
  protected void addSeriousCaseManagementModel(){

    getSeriousCaseManagementItem1().setButtonIndex(1);
    getSeriousCaseManagementModel().add(getSeriousCaseManagementItem1());

    getSeriousCaseManagementItem2().setButtonIndex(2);
    getSeriousCaseManagementModel().add(getSeriousCaseManagementItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSeriousCaseManagementItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSeriousCaseManagementItem2(){

  }

  /**
   * 算定項目領域2に内部項目を追加します。
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * %ラベルに内部項目を追加します。
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
      ACFrame.debugStart(new ACAffairInfo(QO004103Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004103Design getThis() {
    return this;
  }
}
