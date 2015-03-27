
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
 * 作成日: 2015/02/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン特定施設入所者生活介護（短期利用） (QS001_12711_201504)
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
 * サービスパターン特定施設入所者生活介護（短期利用）画面項目デザイン(QS001_12711_201504) 
 */
public class QS001_12711_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel specificFacilityPatterns;

  private ACValueArrayRadioButtonGroup specificFacilitySubtractionRadio;

  private ACLabelContainer specificFacilitySubtractionRadioContainer;

  private ACListModelAdapter specificFacilitySubtractionRadioModel;

  private ACRadioButtonItem specificFacilitySubtractionNot;

  private ACRadioButtonItem specificFacilitySubtractionPersonLack;

  private ACValueArrayRadioButtonGroup nightNursingSystemRadio;

  private ACLabelContainer nightNursingSystemRadioContainer;

  private ACListModelAdapter nightNursingSystemRadioModel;

  private ACRadioButtonItem nightNursingSystemRadioItem1;

  private ACRadioButtonItem nightNursingSystemRadioItem2;

  private ACIntegerCheckBox Addition30Orver;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  //getter

  /**
   * 特定施設入所者生活介護（短期利用）パターン領域を取得します。
   * @return 特定施設入所者生活介護（短期利用）パターン領域
   */
  public ACPanel getSpecificFacilityPatterns(){
    if(specificFacilityPatterns==null){

      specificFacilityPatterns = new ACPanel();

      specificFacilityPatterns.setFollowChildEnabled(true);

      addSpecificFacilityPatterns();
    }
    return specificFacilityPatterns;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getSpecificFacilitySubtractionRadio(){
    if(specificFacilitySubtractionRadio==null){

      specificFacilitySubtractionRadio = new ACValueArrayRadioButtonGroup();

      getSpecificFacilitySubtractionRadioContainer().setText("人員減算");

      specificFacilitySubtractionRadio.setBindPath("1270101");

      specificFacilitySubtractionRadio.setUseClearButton(false);

      specificFacilitySubtractionRadio.setModel(getSpecificFacilitySubtractionRadioModel());

      specificFacilitySubtractionRadio.setValues(new int[]{1,2});

      addSpecificFacilitySubtractionRadio();
    }
    return specificFacilitySubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getSpecificFacilitySubtractionRadioContainer(){
    if(specificFacilitySubtractionRadioContainer==null){
      specificFacilitySubtractionRadioContainer = new ACLabelContainer();
      specificFacilitySubtractionRadioContainer.setFollowChildEnabled(true);
      specificFacilitySubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      specificFacilitySubtractionRadioContainer.add(getSpecificFacilitySubtractionRadio(), null);
    }
    return specificFacilitySubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getSpecificFacilitySubtractionRadioModel(){
    if(specificFacilitySubtractionRadioModel==null){
      specificFacilitySubtractionRadioModel = new ACListModelAdapter();
      addSpecificFacilitySubtractionRadioModel();
    }
    return specificFacilitySubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionNot(){
    if(specificFacilitySubtractionNot==null){

      specificFacilitySubtractionNot = new ACRadioButtonItem();

      specificFacilitySubtractionNot.setText("なし");

      specificFacilitySubtractionNot.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionNot.setConstraints(VRLayout.FLOW_RETURN);

      addSpecificFacilitySubtractionNot();
    }
    return specificFacilitySubtractionNot;

  }

  /**
   * 職員不足を取得します。
   * @return 職員不足
   */
  public ACRadioButtonItem getSpecificFacilitySubtractionPersonLack(){
    if(specificFacilitySubtractionPersonLack==null){

      specificFacilitySubtractionPersonLack = new ACRadioButtonItem();

      specificFacilitySubtractionPersonLack.setText("看護・介護職員の不足");

      specificFacilitySubtractionPersonLack.setGroup(getSpecificFacilitySubtractionRadio());

      specificFacilitySubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addSpecificFacilitySubtractionPersonLack();
    }
    return specificFacilitySubtractionPersonLack;

  }

  /**
   * 夜間看護体制加算を取得します。
   * @return 夜間看護体制加算
   */
  public ACValueArrayRadioButtonGroup getNightNursingSystemRadio(){
    if(nightNursingSystemRadio==null){

      nightNursingSystemRadio = new ACValueArrayRadioButtonGroup();

      getNightNursingSystemRadioContainer().setText("夜間看護体制加算");

      nightNursingSystemRadio.setBindPath("1270102");

      nightNursingSystemRadio.setUseClearButton(false);

      nightNursingSystemRadio.setModel(getNightNursingSystemRadioModel());

      nightNursingSystemRadio.setValues(new int[]{1,2});

      addNightNursingSystemRadio();
    }
    return nightNursingSystemRadio;

  }

  /**
   * 夜間看護体制加算コンテナを取得します。
   * @return 夜間看護体制加算コンテナ
   */
  protected ACLabelContainer getNightNursingSystemRadioContainer(){
    if(nightNursingSystemRadioContainer==null){
      nightNursingSystemRadioContainer = new ACLabelContainer();
      nightNursingSystemRadioContainer.setFollowChildEnabled(true);
      nightNursingSystemRadioContainer.setVAlignment(VRLayout.CENTER);
      nightNursingSystemRadioContainer.add(getNightNursingSystemRadio(), null);
    }
    return nightNursingSystemRadioContainer;
  }

  /**
   * 夜間看護体制加算モデルを取得します。
   * @return 夜間看護体制加算モデル
   */
  protected ACListModelAdapter getNightNursingSystemRadioModel(){
    if(nightNursingSystemRadioModel==null){
      nightNursingSystemRadioModel = new ACListModelAdapter();
      addNightNursingSystemRadioModel();
    }
    return nightNursingSystemRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNightNursingSystemRadioItem1(){
    if(nightNursingSystemRadioItem1==null){

      nightNursingSystemRadioItem1 = new ACRadioButtonItem();

      nightNursingSystemRadioItem1.setText("なし");

      nightNursingSystemRadioItem1.setGroup(getNightNursingSystemRadio());

      nightNursingSystemRadioItem1.setConstraints(VRLayout.FLOW);

      addNightNursingSystemRadioItem1();
    }
    return nightNursingSystemRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNightNursingSystemRadioItem2(){
    if(nightNursingSystemRadioItem2==null){

      nightNursingSystemRadioItem2 = new ACRadioButtonItem();

      nightNursingSystemRadioItem2.setText("あり");

      nightNursingSystemRadioItem2.setGroup(getNightNursingSystemRadio());

      nightNursingSystemRadioItem2.setConstraints(VRLayout.FLOW);

      addNightNursingSystemRadioItem2();
    }
    return nightNursingSystemRadioItem2;

  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getAddition30Orver(){
    if(Addition30Orver==null){

      Addition30Orver = new ACIntegerCheckBox();

      Addition30Orver.setText("30日超");

      Addition30Orver.setBindPath("5");

      Addition30Orver.setSelectValue(2);

      Addition30Orver.setUnSelectValue(1);

      addAddition30Orver();
    }
    return Addition30Orver;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1270103");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4,5});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * サービス提供体制強化加算コンテナを取得します。
   * @return サービス提供体制強化加算コンテナ
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * サービス提供体制強化加算モデルを取得します。
   * @return サービス提供体制強化加算モデル
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("なし");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * Iイ型を取得します。
   * @return Iイ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("II型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("III型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * コンストラクタです。
   */
  public QS001_12711_201504Design() {

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

    this.add(getSpecificFacilityPatterns(), VRLayout.CLIENT);

  }

  /**
   * 特定施設入所者生活介護（短期利用）パターン領域に内部項目を追加します。
   */
  protected void addSpecificFacilityPatterns(){

    specificFacilityPatterns.add(getSpecificFacilitySubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    specificFacilityPatterns.add(getNightNursingSystemRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    specificFacilityPatterns.add(getAddition30Orver(), VRLayout.FLOW);

    specificFacilityPatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionRadioModel(){

    getSpecificFacilitySubtractionNot().setButtonIndex(1);

    getSpecificFacilitySubtractionRadioModel().add(getSpecificFacilitySubtractionNot());

    getSpecificFacilitySubtractionPersonLack().setButtonIndex(2);

    getSpecificFacilitySubtractionRadioModel().add(getSpecificFacilitySubtractionPersonLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionNot(){

  }

  /**
   * 職員不足に内部項目を追加します。
   */
  protected void addSpecificFacilitySubtractionPersonLack(){

  }

  /**
   * 夜間看護体制加算に内部項目を追加します。
   */
  protected void addNightNursingSystemRadio(){

  }

  /**
   * 夜間看護体制加算モデルに内部項目を追加します。
   */
  protected void addNightNursingSystemRadioModel(){

    getNightNursingSystemRadioItem1().setButtonIndex(1);

    getNightNursingSystemRadioModel().add(getNightNursingSystemRadioItem1());

    getNightNursingSystemRadioItem2().setButtonIndex(2);

    getNightNursingSystemRadioModel().add(getNightNursingSystemRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNightNursingSystemRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNightNursingSystemRadioItem2(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addAddition30Orver(){

  }

  /**
   * サービス提供体制強化加算に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * サービス提供体制強化加算モデルに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12711_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_12711_201504Design getThis() {
    return this;
  }
}
