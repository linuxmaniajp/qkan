
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
 * 作成日: 2006/12/25  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン夜間対応型訪問介護 (QS001123)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
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
/**
 * サービスパターン夜間対応型訪問介護画面項目デザイン(QS001123) 
 */
public class QS001123Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel nightTypeVisitCarePatterns;

  private ACClearableRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACClearableRadioButtonGroup serviceDivisionRadio;

  private ACLabelContainer serviceDivisionRadioContainer;

  private ACListModelAdapter serviceDivisionRadioModel;

  private ACRadioButtonItem serviceDivisionRadioItem1;

  private ACRadioButtonItem serviceDivisionRadioItem2;

  private ACClearableRadioButtonGroup anytimeCorrespondenceTypeRadio;

  private ACLabelContainer anytimeCorrespondenceTypeRadioContainer;

  private ACListModelAdapter anytimeCorrespondenceTypeRadioModel;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem1;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem2;

  private ACClearableRadioButtonGroup classEmploymentRadio;

  private ACLabelContainer classEmploymentRadioContainer;

  private ACListModelAdapter classEmploymentRadioModel;

  private ACRadioButtonItem classEmploymentRadioItem1;

  private ACRadioButtonItem classEmploymentRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionBasicOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  //getter

  /**
   * 夜間対応型訪問介護パターン領域を取得します。
   * @return 夜間対応型訪問介護パターン領域
   */
  public ACPanel getNightTypeVisitCarePatterns(){
    if(nightTypeVisitCarePatterns==null){

      nightTypeVisitCarePatterns = new ACPanel();

      nightTypeVisitCarePatterns.setAutoWrap(false);

      nightTypeVisitCarePatterns.setHgrid(200);

      addNightTypeVisitCarePatterns();
    }
    return nightTypeVisitCarePatterns;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACClearableRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACClearableRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("施設等の区分");

      providerDivisionRadio.setBindPath("1710101");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I型を取得します。
   * @return I型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I型");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II型");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * サービス区分を取得します。
   * @return サービス区分
   */
  public ACClearableRadioButtonGroup getServiceDivisionRadio(){
    if(serviceDivisionRadio==null){

      serviceDivisionRadio = new ACClearableRadioButtonGroup();

      getServiceDivisionRadioContainer().setText("サービス区分");

      serviceDivisionRadio.setBindPath("1710102");

      serviceDivisionRadio.setUseClearButton(false);

      serviceDivisionRadio.setModel(getServiceDivisionRadioModel());

      addServiceDivisionRadio();
    }
    return serviceDivisionRadio;

  }

  /**
   * サービス区分コンテナを取得します。
   * @return サービス区分コンテナ
   */
  protected ACLabelContainer getServiceDivisionRadioContainer(){
    if(serviceDivisionRadioContainer==null){
      serviceDivisionRadioContainer = new ACLabelContainer();
      serviceDivisionRadioContainer.setFollowChildEnabled(true);
      serviceDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      serviceDivisionRadioContainer.add(getServiceDivisionRadio(), null);
    }
    return serviceDivisionRadioContainer;
  }

  /**
   * サービス区分モデルを取得します。
   * @return サービス区分モデル
   */
  protected ACListModelAdapter getServiceDivisionRadioModel(){
    if(serviceDivisionRadioModel==null){
      serviceDivisionRadioModel = new ACListModelAdapter();
      addServiceDivisionRadioModel();
    }
    return serviceDivisionRadioModel;
  }

  /**
   * 定期巡回型を取得します。
   * @return 定期巡回型
   */
  public ACRadioButtonItem getServiceDivisionRadioItem1(){
    if(serviceDivisionRadioItem1==null){

      serviceDivisionRadioItem1 = new ACRadioButtonItem();

      serviceDivisionRadioItem1.setText("定期巡回型");

      serviceDivisionRadioItem1.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem1();
    }
    return serviceDivisionRadioItem1;

  }

  /**
   * 随時対応型を取得します。
   * @return 随時対応型
   */
  public ACRadioButtonItem getServiceDivisionRadioItem2(){
    if(serviceDivisionRadioItem2==null){

      serviceDivisionRadioItem2 = new ACRadioButtonItem();

      serviceDivisionRadioItem2.setText("随時対応型");

      serviceDivisionRadioItem2.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem2();
    }
    return serviceDivisionRadioItem2;

  }

  /**
   * 対応人数を取得します。
   * @return 対応人数
   */
  public ACClearableRadioButtonGroup getAnytimeCorrespondenceTypeRadio(){
    if(anytimeCorrespondenceTypeRadio==null){

      anytimeCorrespondenceTypeRadio = new ACClearableRadioButtonGroup();

      getAnytimeCorrespondenceTypeRadioContainer().setText("対応人数");

      anytimeCorrespondenceTypeRadio.setBindPath("1710104");

      anytimeCorrespondenceTypeRadio.setUseClearButton(false);

      anytimeCorrespondenceTypeRadio.setModel(getAnytimeCorrespondenceTypeRadioModel());

      addAnytimeCorrespondenceTypeRadio();
    }
    return anytimeCorrespondenceTypeRadio;

  }

  /**
   * 対応人数コンテナを取得します。
   * @return 対応人数コンテナ
   */
  protected ACLabelContainer getAnytimeCorrespondenceTypeRadioContainer(){
    if(anytimeCorrespondenceTypeRadioContainer==null){
      anytimeCorrespondenceTypeRadioContainer = new ACLabelContainer();
      anytimeCorrespondenceTypeRadioContainer.setFollowChildEnabled(true);
      anytimeCorrespondenceTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      anytimeCorrespondenceTypeRadioContainer.add(getAnytimeCorrespondenceTypeRadio(), null);
    }
    return anytimeCorrespondenceTypeRadioContainer;
  }

  /**
   * 対応人数モデルを取得します。
   * @return 対応人数モデル
   */
  protected ACListModelAdapter getAnytimeCorrespondenceTypeRadioModel(){
    if(anytimeCorrespondenceTypeRadioModel==null){
      anytimeCorrespondenceTypeRadioModel = new ACListModelAdapter();
      addAnytimeCorrespondenceTypeRadioModel();
    }
    return anytimeCorrespondenceTypeRadioModel;
  }

  /**
   * 1人対応を取得します。
   * @return 1人対応
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem1(){
    if(anytimeCorrespondenceTypeRadioItem1==null){

      anytimeCorrespondenceTypeRadioItem1 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem1.setText("1人対応");

      anytimeCorrespondenceTypeRadioItem1.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem1.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem1();
    }
    return anytimeCorrespondenceTypeRadioItem1;

  }

  /**
   * 2人対応を取得します。
   * @return 2人対応
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem2(){
    if(anytimeCorrespondenceTypeRadioItem2==null){

      anytimeCorrespondenceTypeRadioItem2 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem2.setText("2人対応");

      anytimeCorrespondenceTypeRadioItem2.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem2.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem2();
    }
    return anytimeCorrespondenceTypeRadioItem2;

  }

  /**
   * 訪問者の級職を取得します。
   * @return 訪問者の級職
   */
  public ACClearableRadioButtonGroup getClassEmploymentRadio(){
    if(classEmploymentRadio==null){

      classEmploymentRadio = new ACClearableRadioButtonGroup();

      getClassEmploymentRadioContainer().setText("訪問者の級職");

      classEmploymentRadio.setBindPath("1710105");

      classEmploymentRadio.setUseClearButton(false);

      classEmploymentRadio.setModel(getClassEmploymentRadioModel());

      addClassEmploymentRadio();
    }
    return classEmploymentRadio;

  }

  /**
   * 訪問者の級職コンテナを取得します。
   * @return 訪問者の級職コンテナ
   */
  protected ACLabelContainer getClassEmploymentRadioContainer(){
    if(classEmploymentRadioContainer==null){
      classEmploymentRadioContainer = new ACLabelContainer();
      classEmploymentRadioContainer.setFollowChildEnabled(true);
      classEmploymentRadioContainer.setVAlignment(VRLayout.CENTER);
      classEmploymentRadioContainer.add(getClassEmploymentRadio(), null);
    }
    return classEmploymentRadioContainer;
  }

  /**
   * 訪問者の級職モデルを取得します。
   * @return 訪問者の級職モデル
   */
  protected ACListModelAdapter getClassEmploymentRadioModel(){
    if(classEmploymentRadioModel==null){
      classEmploymentRadioModel = new ACListModelAdapter();
      addClassEmploymentRadioModel();
    }
    return classEmploymentRadioModel;
  }

  /**
   * 3級以外を取得します。
   * @return 3級以外
   */
  public ACRadioButtonItem getClassEmploymentRadioItem1(){
    if(classEmploymentRadioItem1==null){

      classEmploymentRadioItem1 = new ACRadioButtonItem();

      classEmploymentRadioItem1.setText("3級以外");

      classEmploymentRadioItem1.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem1();
    }
    return classEmploymentRadioItem1;

  }

  /**
   * 3級を取得します。
   * @return 3級
   */
  public ACRadioButtonItem getClassEmploymentRadioItem2(){
    if(classEmploymentRadioItem2==null){

      classEmploymentRadioItem2 = new ACRadioButtonItem();

      classEmploymentRadioItem2.setText("3級");

      classEmploymentRadioItem2.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem2();
    }
    return classEmploymentRadioItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("算定区分");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,3});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("通常");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * 基本のみを取得します。
   * @return 基本のみ
   */
  public ACRadioButtonItem getCalculationDivisionBasicOnly(){
    if(calculationDivisionBasicOnly==null){

      calculationDivisionBasicOnly = new ACRadioButtonItem();

      calculationDivisionBasicOnly.setText("基本のみ");

      calculationDivisionBasicOnly.setGroup(getCalculationDivision());

      calculationDivisionBasicOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionBasicOnly();
    }
    return calculationDivisionBasicOnly;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1710106");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * コンストラクタです。
   */
  public QS001123Design() {

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

    this.add(getNightTypeVisitCarePatterns(), VRLayout.CLIENT);

  }

  /**
   * 夜間対応型訪問介護パターン領域に内部項目を追加します。
   */
  protected void addNightTypeVisitCarePatterns(){

    nightTypeVisitCarePatterns.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getAnytimeCorrespondenceTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getClassEmploymentRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCrackOnDayCheck(), VRLayout.FLOW);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * サービス区分に内部項目を追加します。
   */
  protected void addServiceDivisionRadio(){

  }

  /**
   * サービス区分モデルに内部項目を追加します。
   */
  protected void addServiceDivisionRadioModel(){

    getServiceDivisionRadioItem1().setButtonIndex(1);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem1());

    getServiceDivisionRadioItem2().setButtonIndex(2);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem2());

  }

  /**
   * 定期巡回型に内部項目を追加します。
   */
  protected void addServiceDivisionRadioItem1(){

  }

  /**
   * 随時対応型に内部項目を追加します。
   */
  protected void addServiceDivisionRadioItem2(){

  }

  /**
   * 対応人数に内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadio(){

  }

  /**
   * 対応人数モデルに内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadioModel(){

    getAnytimeCorrespondenceTypeRadioItem1().setButtonIndex(1);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem1());

    getAnytimeCorrespondenceTypeRadioItem2().setButtonIndex(2);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem2());

  }

  /**
   * 1人対応に内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadioItem1(){

  }

  /**
   * 2人対応に内部項目を追加します。
   */
  protected void addAnytimeCorrespondenceTypeRadioItem2(){

  }

  /**
   * 訪問者の級職に内部項目を追加します。
   */
  protected void addClassEmploymentRadio(){

  }

  /**
   * 訪問者の級職モデルに内部項目を追加します。
   */
  protected void addClassEmploymentRadioModel(){

    getClassEmploymentRadioItem1().setButtonIndex(1);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem1());

    getClassEmploymentRadioItem2().setButtonIndex(2);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem2());

  }

  /**
   * 3級以外に内部項目を追加します。
   */
  protected void addClassEmploymentRadioItem1(){

  }

  /**
   * 3級に内部項目を追加します。
   */
  protected void addClassEmploymentRadioItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivision(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionBasicOnly().setButtonIndex(3);

    getCalculationDivisionModel().add(getCalculationDivisionBasicOnly());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * 基本のみに内部項目を追加します。
   */
  protected void addCalculationDivisionBasicOnly(){

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addCrackOnDayCheck(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001123Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001123Design getThis() {
    return this;
  }
}
