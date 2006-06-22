
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
 * 作成日: 2006/03/14  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン認知症対応共同生活介護（短期利用以外） (QS001126)
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
 * サービスパターン認知症対応共同生活介護（短期利用以外）画面項目デザイン(QS001126) 
 */
public class QS001126Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel typeSymbiosisNursingForDementiaPatterns;

  private ACClearableRadioButtonGroup typeSymbiosisNursingForDementiaDefaultRadio;

  private ACLabelContainer typeSymbiosisNursingForDementiaDefaultRadioContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaDefaultRadioModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem1;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem2;

  private ACClearableRadioButtonGroup typeSymbiosisNursingForDementiaSubtraction;

  private ACLabelContainer typeSymbiosisNursingForDementiaSubtractionContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaSubtractionModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionPersonLack;

  private ACClearableRadioButtonGroup nightWorkConditionStandardRadio;

  private ACLabelContainer nightWorkConditionStandardRadioContainer;

  private ACListModelAdapter nightWorkConditionStandardRadioModel;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem1;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem2;

  private ACClearableRadioButtonGroup medicalCooperationSystemAddRadio;

  private ACLabelContainer medicalCooperationSystemAddRadioContainer;

  private ACListModelAdapter medicalCooperationSystemAddRadioModel;

  private ACRadioButtonItem medicalCooperationSystemAddRadioItem1;

  private ACRadioButtonItem medicalCooperationSystemAddRadioItem2;

  //getter

  /**
   * 認知症対応共同生活介護（短期利用以外）パターン領域を取得します。
   * @return 認知症対応共同生活介護（短期利用以外）パターン領域
   */
  public ACPanel getTypeSymbiosisNursingForDementiaPatterns(){
    if(typeSymbiosisNursingForDementiaPatterns==null){

      typeSymbiosisNursingForDementiaPatterns = new ACPanel();

      typeSymbiosisNursingForDementiaPatterns.setAutoWrap(false);

      typeSymbiosisNursingForDementiaPatterns.setHgrid(200);

      addTypeSymbiosisNursingForDementiaPatterns();
    }
    return typeSymbiosisNursingForDementiaPatterns;

  }

  /**
   * 初期加算を取得します。
   * @return 初期加算
   */
  public ACClearableRadioButtonGroup getTypeSymbiosisNursingForDementiaDefaultRadio(){
    if(typeSymbiosisNursingForDementiaDefaultRadio==null){

      typeSymbiosisNursingForDementiaDefaultRadio = new ACClearableRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaDefaultRadioContainer().setText("初期加算");

      typeSymbiosisNursingForDementiaDefaultRadio.setBindPath("1320104");

      typeSymbiosisNursingForDementiaDefaultRadio.setModel(getTypeSymbiosisNursingForDementiaDefaultRadioModel());

      typeSymbiosisNursingForDementiaDefaultRadio.setUseClearButton(false);

      addTypeSymbiosisNursingForDementiaDefaultRadio();
    }
    return typeSymbiosisNursingForDementiaDefaultRadio;

  }

  /**
   * 初期加算コンテナを取得します。
   * @return 初期加算コンテナ
   */
  protected ACLabelContainer getTypeSymbiosisNursingForDementiaDefaultRadioContainer(){
    if(typeSymbiosisNursingForDementiaDefaultRadioContainer==null){
      typeSymbiosisNursingForDementiaDefaultRadioContainer = new ACLabelContainer();
      typeSymbiosisNursingForDementiaDefaultRadioContainer.setFollowChildEnabled(true);
      typeSymbiosisNursingForDementiaDefaultRadioContainer.setVAlignment(VRLayout.CENTER);
      typeSymbiosisNursingForDementiaDefaultRadioContainer.add(getTypeSymbiosisNursingForDementiaDefaultRadio(), null);
    }
    return typeSymbiosisNursingForDementiaDefaultRadioContainer;
  }

  /**
   * 初期加算モデルを取得します。
   * @return 初期加算モデル
   */
  protected ACListModelAdapter getTypeSymbiosisNursingForDementiaDefaultRadioModel(){
    if(typeSymbiosisNursingForDementiaDefaultRadioModel==null){
      typeSymbiosisNursingForDementiaDefaultRadioModel = new ACListModelAdapter();
      addTypeSymbiosisNursingForDementiaDefaultRadioModel();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaDefaultRadioItem1(){
    if(typeSymbiosisNursingForDementiaDefaultRadioItem1==null){

      typeSymbiosisNursingForDementiaDefaultRadioItem1 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setText("なし");

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setGroup(getTypeSymbiosisNursingForDementiaDefaultRadio());

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaDefaultRadioItem1();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaDefaultRadioItem2(){
    if(typeSymbiosisNursingForDementiaDefaultRadioItem2==null){

      typeSymbiosisNursingForDementiaDefaultRadioItem2 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setText("あり");

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setGroup(getTypeSymbiosisNursingForDementiaDefaultRadio());

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaDefaultRadioItem2();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getTypeSymbiosisNursingForDementiaSubtraction(){
    if(typeSymbiosisNursingForDementiaSubtraction==null){

      typeSymbiosisNursingForDementiaSubtraction = new ACClearableRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaSubtractionContainer().setText("人員減算");

      typeSymbiosisNursingForDementiaSubtraction.setBindPath("1320105");

      typeSymbiosisNursingForDementiaSubtraction.setModel(getTypeSymbiosisNursingForDementiaSubtractionModel());

      typeSymbiosisNursingForDementiaSubtraction.setUseClearButton(false);

      addTypeSymbiosisNursingForDementiaSubtraction();
    }
    return typeSymbiosisNursingForDementiaSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getTypeSymbiosisNursingForDementiaSubtractionContainer(){
    if(typeSymbiosisNursingForDementiaSubtractionContainer==null){
      typeSymbiosisNursingForDementiaSubtractionContainer = new ACLabelContainer();
      typeSymbiosisNursingForDementiaSubtractionContainer.setFollowChildEnabled(true);
      typeSymbiosisNursingForDementiaSubtractionContainer.setVAlignment(VRLayout.CENTER);
      typeSymbiosisNursingForDementiaSubtractionContainer.add(getTypeSymbiosisNursingForDementiaSubtraction(), null);
    }
    return typeSymbiosisNursingForDementiaSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getTypeSymbiosisNursingForDementiaSubtractionModel(){
    if(typeSymbiosisNursingForDementiaSubtractionModel==null){
      typeSymbiosisNursingForDementiaSubtractionModel = new ACListModelAdapter();
      addTypeSymbiosisNursingForDementiaSubtractionModel();
    }
    return typeSymbiosisNursingForDementiaSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionCapacityNot(){
    if(typeSymbiosisNursingForDementiaSubtractionCapacityNot==null){

      typeSymbiosisNursingForDementiaSubtractionCapacityNot = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setText("なし");

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaSubtractionCapacityNot();
    }
    return typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess(){
    if(typeSymbiosisNursingForDementiaSubtractionCapacityExcess==null){

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setText("定員超過");

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTypeSymbiosisNursingForDementiaSubtractionCapacityExcess();
    }
    return typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  }

  /**
   * 職員不足を取得します。
   * @return 職員不足
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionPersonLack(){
    if(typeSymbiosisNursingForDementiaSubtractionPersonLack==null){

      typeSymbiosisNursingForDementiaSubtractionPersonLack = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setText("介護従業員の不足");

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaSubtractionPersonLack();
    }
    return typeSymbiosisNursingForDementiaSubtractionPersonLack;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACClearableRadioButtonGroup getNightWorkConditionStandardRadio(){
    if(nightWorkConditionStandardRadio==null){

      nightWorkConditionStandardRadio = new ACClearableRadioButtonGroup();

      getNightWorkConditionStandardRadioContainer().setText("夜間勤務条件基準");

      nightWorkConditionStandardRadio.setBindPath("1320106");

      nightWorkConditionStandardRadio.setModel(getNightWorkConditionStandardRadioModel());

      nightWorkConditionStandardRadio.setUseClearButton(false);

      addNightWorkConditionStandardRadio();
    }
    return nightWorkConditionStandardRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getNightWorkConditionStandardRadioContainer(){
    if(nightWorkConditionStandardRadioContainer==null){
      nightWorkConditionStandardRadioContainer = new ACLabelContainer();
      nightWorkConditionStandardRadioContainer.setFollowChildEnabled(true);
      nightWorkConditionStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      nightWorkConditionStandardRadioContainer.add(getNightWorkConditionStandardRadio(), null);
    }
    return nightWorkConditionStandardRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getNightWorkConditionStandardRadioModel(){
    if(nightWorkConditionStandardRadioModel==null){
      nightWorkConditionStandardRadioModel = new ACListModelAdapter();
      addNightWorkConditionStandardRadioModel();
    }
    return nightWorkConditionStandardRadioModel;
  }

  /**
   * 満たしているを取得します。
   * @return 満たしている
   */
  public ACRadioButtonItem getNightWorkConditionStandardRadioItem1(){
    if(nightWorkConditionStandardRadioItem1==null){

      nightWorkConditionStandardRadioItem1 = new ACRadioButtonItem();

      nightWorkConditionStandardRadioItem1.setText("満たしている");

      nightWorkConditionStandardRadioItem1.setGroup(getNightWorkConditionStandardRadio());

      nightWorkConditionStandardRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addNightWorkConditionStandardRadioItem1();
    }
    return nightWorkConditionStandardRadioItem1;

  }

  /**
   * 満たしていないを取得します。
   * @return 満たしていない
   */
  public ACRadioButtonItem getNightWorkConditionStandardRadioItem2(){
    if(nightWorkConditionStandardRadioItem2==null){

      nightWorkConditionStandardRadioItem2 = new ACRadioButtonItem();

      nightWorkConditionStandardRadioItem2.setText("満たしていない");

      nightWorkConditionStandardRadioItem2.setGroup(getNightWorkConditionStandardRadio());

      nightWorkConditionStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addNightWorkConditionStandardRadioItem2();
    }
    return nightWorkConditionStandardRadioItem2;

  }

  /**
   * 医療連携体制加算を取得します。
   * @return 医療連携体制加算
   */
  public ACClearableRadioButtonGroup getMedicalCooperationSystemAddRadio(){
    if(medicalCooperationSystemAddRadio==null){

      medicalCooperationSystemAddRadio = new ACClearableRadioButtonGroup();

      getMedicalCooperationSystemAddRadioContainer().setText("医療連携体制加算");

      medicalCooperationSystemAddRadio.setBindPath("1320107");

      medicalCooperationSystemAddRadio.setModel(getMedicalCooperationSystemAddRadioModel());

      medicalCooperationSystemAddRadio.setUseClearButton(false);

      addMedicalCooperationSystemAddRadio();
    }
    return medicalCooperationSystemAddRadio;

  }

  /**
   * 医療連携体制加算コンテナを取得します。
   * @return 医療連携体制加算コンテナ
   */
  protected ACLabelContainer getMedicalCooperationSystemAddRadioContainer(){
    if(medicalCooperationSystemAddRadioContainer==null){
      medicalCooperationSystemAddRadioContainer = new ACLabelContainer();
      medicalCooperationSystemAddRadioContainer.setFollowChildEnabled(true);
      medicalCooperationSystemAddRadioContainer.setVAlignment(VRLayout.CENTER);
      medicalCooperationSystemAddRadioContainer.add(getMedicalCooperationSystemAddRadio(), null);
    }
    return medicalCooperationSystemAddRadioContainer;
  }

  /**
   * 医療連携体制加算モデルを取得します。
   * @return 医療連携体制加算モデル
   */
  protected ACListModelAdapter getMedicalCooperationSystemAddRadioModel(){
    if(medicalCooperationSystemAddRadioModel==null){
      medicalCooperationSystemAddRadioModel = new ACListModelAdapter();
      addMedicalCooperationSystemAddRadioModel();
    }
    return medicalCooperationSystemAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMedicalCooperationSystemAddRadioItem1(){
    if(medicalCooperationSystemAddRadioItem1==null){

      medicalCooperationSystemAddRadioItem1 = new ACRadioButtonItem();

      medicalCooperationSystemAddRadioItem1.setText("なし");

      medicalCooperationSystemAddRadioItem1.setGroup(getMedicalCooperationSystemAddRadio());

      medicalCooperationSystemAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMedicalCooperationSystemAddRadioItem1();
    }
    return medicalCooperationSystemAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMedicalCooperationSystemAddRadioItem2(){
    if(medicalCooperationSystemAddRadioItem2==null){

      medicalCooperationSystemAddRadioItem2 = new ACRadioButtonItem();

      medicalCooperationSystemAddRadioItem2.setText("あり");

      medicalCooperationSystemAddRadioItem2.setGroup(getMedicalCooperationSystemAddRadio());

      medicalCooperationSystemAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMedicalCooperationSystemAddRadioItem2();
    }
    return medicalCooperationSystemAddRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001126Design() {

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

    this.add(getTypeSymbiosisNursingForDementiaPatterns(), VRLayout.CLIENT);

  }

  /**
   * 認知症対応共同生活介護（短期利用以外）パターン領域に内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaPatterns(){

    typeSymbiosisNursingForDementiaPatterns.add(getTypeSymbiosisNursingForDementiaDefaultRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getTypeSymbiosisNursingForDementiaSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getNightWorkConditionStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    typeSymbiosisNursingForDementiaPatterns.add(getMedicalCooperationSystemAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 初期加算に内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadio(){

  }

  /**
   * 初期加算モデルに内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioModel(){

    getTypeSymbiosisNursingForDementiaDefaultRadioItem1().setButtonIndex(1);
    getTypeSymbiosisNursingForDementiaDefaultRadioModel().add(getTypeSymbiosisNursingForDementiaDefaultRadioItem1());

    getTypeSymbiosisNursingForDementiaDefaultRadioItem2().setButtonIndex(2);
    getTypeSymbiosisNursingForDementiaDefaultRadioModel().add(getTypeSymbiosisNursingForDementiaDefaultRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionModel(){

    getTypeSymbiosisNursingForDementiaSubtractionCapacityNot().setButtonIndex(1);
    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionCapacityNot());

    getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess().setButtonIndex(2);
    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess());

    getTypeSymbiosisNursingForDementiaSubtractionPersonLack().setButtonIndex(3);
    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionPersonLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionCapacityNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionCapacityExcess(){

  }

  /**
   * 職員不足に内部項目を追加します。
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionPersonLack(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addNightWorkConditionStandardRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addNightWorkConditionStandardRadioModel(){

    getNightWorkConditionStandardRadioItem1().setButtonIndex(1);
    getNightWorkConditionStandardRadioModel().add(getNightWorkConditionStandardRadioItem1());

    getNightWorkConditionStandardRadioItem2().setButtonIndex(2);
    getNightWorkConditionStandardRadioModel().add(getNightWorkConditionStandardRadioItem2());

  }

  /**
   * 満たしているに内部項目を追加します。
   */
  protected void addNightWorkConditionStandardRadioItem1(){

  }

  /**
   * 満たしていないに内部項目を追加します。
   */
  protected void addNightWorkConditionStandardRadioItem2(){

  }

  /**
   * 医療連携体制加算に内部項目を追加します。
   */
  protected void addMedicalCooperationSystemAddRadio(){

  }

  /**
   * 医療連携体制加算モデルに内部項目を追加します。
   */
  protected void addMedicalCooperationSystemAddRadioModel(){

    getMedicalCooperationSystemAddRadioItem1().setButtonIndex(1);
    getMedicalCooperationSystemAddRadioModel().add(getMedicalCooperationSystemAddRadioItem1());

    getMedicalCooperationSystemAddRadioItem2().setButtonIndex(2);
    getMedicalCooperationSystemAddRadioModel().add(getMedicalCooperationSystemAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMedicalCooperationSystemAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMedicalCooperationSystemAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001126Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001126Design getThis() {
    return this;
  }
}
