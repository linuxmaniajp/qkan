
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
 * 作成日: 2006/02/16  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン特定施設入所者生活介護 (QS001019)
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
 * サービスパターン特定施設入所者生活介護画面項目デザイン(QS001019) 
 */
public class QS001019Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel specificFacilityPatterns;

  private ACClearableRadioButtonGroup specificFacilityFunctionTrainingRadio;

  private ACLabelContainer specificFacilityFunctionTrainingRadioContainer;

  private ACListModelAdapter specificFacilityFunctionTrainingRadioModel;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem2;

  private ACRadioButtonItem specificFacilityFunctionTrainingRadioItem1;

  private ACClearableRadioButtonGroup specificFacilitySubtractionRadio;

  private ACLabelContainer specificFacilitySubtractionRadioContainer;

  private ACListModelAdapter specificFacilitySubtractionRadioModel;

  private ACRadioButtonItem specificFacilitySubtractionNot;

  private ACRadioButtonItem specificFacilitySubtractionPersonLack;

  //getter

  /**
   * 特定施設入所者生活介護パターン領域を取得します。
   * @return 特定施設入所者生活介護パターン領域
   */
  public ACPanel getSpecificFacilityPatterns(){
    if(specificFacilityPatterns==null){

      specificFacilityPatterns = new ACPanel();

      specificFacilityPatterns.setAutoWrap(false);

      specificFacilityPatterns.setHgrid(200);

      addSpecificFacilityPatterns();
    }
    return specificFacilityPatterns;

  }

  /**
   * 機能訓練体制加算を取得します。
   * @return 機能訓練体制加算
   */
  public ACClearableRadioButtonGroup getSpecificFacilityFunctionTrainingRadio(){
    if(specificFacilityFunctionTrainingRadio==null){

      specificFacilityFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getSpecificFacilityFunctionTrainingRadioContainer().setText("機能訓練加算");

      specificFacilityFunctionTrainingRadio.setBindPath("1330103");

      specificFacilityFunctionTrainingRadio.setModel(getSpecificFacilityFunctionTrainingRadioModel());

      specificFacilityFunctionTrainingRadio.setUseClearButton(false);

      addSpecificFacilityFunctionTrainingRadio();
    }
    return specificFacilityFunctionTrainingRadio;

  }

  /**
   * 機能訓練体制加算コンテナを取得します。
   * @return 機能訓練体制加算コンテナ
   */
  protected ACLabelContainer getSpecificFacilityFunctionTrainingRadioContainer(){
    if(specificFacilityFunctionTrainingRadioContainer==null){
      specificFacilityFunctionTrainingRadioContainer = new ACLabelContainer();
      specificFacilityFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      specificFacilityFunctionTrainingRadioContainer.add(getSpecificFacilityFunctionTrainingRadio(), null);
    }
    return specificFacilityFunctionTrainingRadioContainer;
  }

  /**
   * 機能訓練体制加算モデルを取得します。
   * @return 機能訓練体制加算モデル
   */
  protected ACListModelAdapter getSpecificFacilityFunctionTrainingRadioModel(){
    if(specificFacilityFunctionTrainingRadioModel==null){
      specificFacilityFunctionTrainingRadioModel = new ACListModelAdapter();
      addSpecificFacilityFunctionTrainingRadioModel();
    }
    return specificFacilityFunctionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSpecificFacilityFunctionTrainingRadioItem2(){
    if(specificFacilityFunctionTrainingRadioItem2==null){

      specificFacilityFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      specificFacilityFunctionTrainingRadioItem2.setText("なし");

      specificFacilityFunctionTrainingRadioItem2.setGroup(getSpecificFacilityFunctionTrainingRadio());

      specificFacilityFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addSpecificFacilityFunctionTrainingRadioItem2();
    }
    return specificFacilityFunctionTrainingRadioItem2;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getSpecificFacilityFunctionTrainingRadioItem1(){
    if(specificFacilityFunctionTrainingRadioItem1==null){

      specificFacilityFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      specificFacilityFunctionTrainingRadioItem1.setText("あり");

      specificFacilityFunctionTrainingRadioItem1.setGroup(getSpecificFacilityFunctionTrainingRadio());

      specificFacilityFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addSpecificFacilityFunctionTrainingRadioItem1();
    }
    return specificFacilityFunctionTrainingRadioItem1;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getSpecificFacilitySubtractionRadio(){
    if(specificFacilitySubtractionRadio==null){

      specificFacilitySubtractionRadio = new ACClearableRadioButtonGroup();

      getSpecificFacilitySubtractionRadioContainer().setText("人員減算");

      specificFacilitySubtractionRadio.setBindPath("1330104");

      specificFacilitySubtractionRadio.setModel(getSpecificFacilitySubtractionRadioModel());

      specificFacilitySubtractionRadio.setUseClearButton(false);

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
   * コンストラクタです。
   */
  public QS001019Design() {

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

    this.add(getSpecificFacilityPatterns(), VRLayout.WEST);

  }

  /**
   * 特定施設入所者生活介護パターン領域に内部項目を追加します。
   */
  protected void addSpecificFacilityPatterns(){

    specificFacilityPatterns.add(getSpecificFacilityFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    specificFacilityPatterns.add(getSpecificFacilitySubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 機能訓練体制加算に内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadio(){

  }

  /**
   * 機能訓練体制加算モデルに内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadioModel(){

    getSpecificFacilityFunctionTrainingRadioItem2().setButtonIndex(1);
    getSpecificFacilityFunctionTrainingRadioModel().add(getSpecificFacilityFunctionTrainingRadioItem2());

    getSpecificFacilityFunctionTrainingRadioItem1().setButtonIndex(2);
    getSpecificFacilityFunctionTrainingRadioModel().add(getSpecificFacilityFunctionTrainingRadioItem1());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadioItem2(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addSpecificFacilityFunctionTrainingRadioItem1(){

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
      ACFrame.getInstance().getContentPane().add(new QS001019Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001019Design getThis() {
    return this;
  }
}
