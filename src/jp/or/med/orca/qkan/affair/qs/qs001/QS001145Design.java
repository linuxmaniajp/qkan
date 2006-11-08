
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
 * 作成日: 2006/05/18  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防支援費 (QS001145)
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
 * サービスパターン介護予防支援費画面項目デザイン(QS001145) 
 */
public class QS001145Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel preventiveSupportExpensePatterns;

  private ACClearableRadioButtonGroup firstTimeAddRadio;

  private ACLabelContainer firstTimeAddRadioContainer;

  private ACListModelAdapter firstTimeAddRadioModel;

  private ACRadioButtonItem firstTimeAddRadioItem1;

  private ACRadioButtonItem firstTimeAddRadioItem2;

  private ACTextField careManagerNoText;

  private ACLabelContainer careManagerNoTextContainer;

  private ACComboBox careManagerNameCombo;

  private ACLabelContainer careManagerNameComboContainer;

  private ACComboBoxModelAdapter careManagerNameComboModel;

  private ACGroupBox consignmentGroup;

  private ACComboBox consignmentProvider;

  private ACLabelContainer consignmentProviderContainer;

  private ACComboBoxModelAdapter consignmentProviderModel;

  private ACTextField consignmentCareManagerNoText;

  private ACLabelContainer consignmentCareManagerNoTextContainer;

  private ACComboBox consignmentCareManagerNameCombo;

  private ACLabelContainer consignmentCareManagerNameComboContainer;

  private ACComboBoxModelAdapter consignmentCareManagerNameComboModel;

  //getter

  /**
   * 予防支援費パターン領域を取得します。
   * @return 予防支援費パターン領域
   */
  public ACPanel getPreventiveSupportExpensePatterns(){
    if(preventiveSupportExpensePatterns==null){

      preventiveSupportExpensePatterns = new ACPanel();

      addPreventiveSupportExpensePatterns();
    }
    return preventiveSupportExpensePatterns;

  }

  /**
   * 初回加算を取得します。
   * @return 初回加算
   */
  public ACClearableRadioButtonGroup getFirstTimeAddRadio(){
    if(firstTimeAddRadio==null){

      firstTimeAddRadio = new ACClearableRadioButtonGroup();

      getFirstTimeAddRadioContainer().setText("初回加算");

      firstTimeAddRadio.setBindPath("1460101");

      firstTimeAddRadio.setUseClearButton(false);

      firstTimeAddRadio.setModel(getFirstTimeAddRadioModel());

      addFirstTimeAddRadio();
    }
    return firstTimeAddRadio;

  }

  /**
   * 初回加算コンテナを取得します。
   * @return 初回加算コンテナ
   */
  protected ACLabelContainer getFirstTimeAddRadioContainer(){
    if(firstTimeAddRadioContainer==null){
      firstTimeAddRadioContainer = new ACLabelContainer();
      firstTimeAddRadioContainer.setFollowChildEnabled(true);
      firstTimeAddRadioContainer.setVAlignment(VRLayout.CENTER);
      firstTimeAddRadioContainer.add(getFirstTimeAddRadio(), null);
    }
    return firstTimeAddRadioContainer;
  }

  /**
   * 初回加算モデルを取得します。
   * @return 初回加算モデル
   */
  protected ACListModelAdapter getFirstTimeAddRadioModel(){
    if(firstTimeAddRadioModel==null){
      firstTimeAddRadioModel = new ACListModelAdapter();
      addFirstTimeAddRadioModel();
    }
    return firstTimeAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getFirstTimeAddRadioItem1(){
    if(firstTimeAddRadioItem1==null){

      firstTimeAddRadioItem1 = new ACRadioButtonItem();

      firstTimeAddRadioItem1.setText("なし");

      firstTimeAddRadioItem1.setGroup(getFirstTimeAddRadio());

      firstTimeAddRadioItem1.setConstraints(VRLayout.FLOW);

      addFirstTimeAddRadioItem1();
    }
    return firstTimeAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFirstTimeAddRadioItem2(){
    if(firstTimeAddRadioItem2==null){

      firstTimeAddRadioItem2 = new ACRadioButtonItem();

      firstTimeAddRadioItem2.setText("あり");

      firstTimeAddRadioItem2.setGroup(getFirstTimeAddRadio());

      firstTimeAddRadioItem2.setConstraints(VRLayout.FLOW);

      addFirstTimeAddRadioItem2();
    }
    return firstTimeAddRadioItem2;

  }

  /**
   * 介護支援専門員番号を取得します。
   * @return 介護支援専門員番号
   */
  public ACTextField getCareManagerNoText(){
    if(careManagerNoText==null){

      careManagerNoText = new ACTextField();

      getCareManagerNoTextContainer().setText("介護支援専門員番号");

      careManagerNoText.setBindPath("1430107");

      careManagerNoText.setColumns(10);

      careManagerNoText.setCharType(VRCharType.ONLY_DIGIT);

      careManagerNoText.setMaxLength(8);

      addCareManagerNoText();
    }
    return careManagerNoText;

  }

  /**
   * 介護支援専門員番号コンテナを取得します。
   * @return 介護支援専門員番号コンテナ
   */
  protected ACLabelContainer getCareManagerNoTextContainer(){
    if(careManagerNoTextContainer==null){
      careManagerNoTextContainer = new ACLabelContainer();
      careManagerNoTextContainer.setFollowChildEnabled(true);
      careManagerNoTextContainer.setVAlignment(VRLayout.CENTER);
      careManagerNoTextContainer.add(getCareManagerNoText(), null);
    }
    return careManagerNoTextContainer;
  }

  /**
   * 介護支援専門員氏名を取得します。
   * @return 介護支援専門員氏名
   */
  public ACComboBox getCareManagerNameCombo(){
    if(careManagerNameCombo==null){

      careManagerNameCombo = new ACComboBox();

      getCareManagerNameComboContainer().setText("介護支援専門員氏名");

      careManagerNameCombo.setEditable(false);

      careManagerNameCombo.setRenderBindPath("STAFF_NAME");

      careManagerNameCombo.setBlankable(true);

      careManagerNameCombo.setIMEMode(InputSubset.KANJI);

      careManagerNameCombo.setMaxLength(30);

      careManagerNameCombo.setMaxColumns(10);

      careManagerNameCombo.setModel(getCareManagerNameComboModel());

      addCareManagerNameCombo();
    }
    return careManagerNameCombo;

  }

  /**
   * 介護支援専門員氏名コンテナを取得します。
   * @return 介護支援専門員氏名コンテナ
   */
  protected ACLabelContainer getCareManagerNameComboContainer(){
    if(careManagerNameComboContainer==null){
      careManagerNameComboContainer = new ACLabelContainer();
      careManagerNameComboContainer.setFollowChildEnabled(true);
      careManagerNameComboContainer.setVAlignment(VRLayout.CENTER);
      careManagerNameComboContainer.add(getCareManagerNameCombo(), null);
    }
    return careManagerNameComboContainer;
  }

  /**
   * 介護支援専門員氏名モデルを取得します。
   * @return 介護支援専門員氏名モデル
   */
  protected ACComboBoxModelAdapter getCareManagerNameComboModel(){
    if(careManagerNameComboModel==null){
      careManagerNameComboModel = new ACComboBoxModelAdapter();
      addCareManagerNameComboModel();
    }
    return careManagerNameComboModel;
  }

  /**
   * 委託先グループを取得します。
   * @return 委託先グループ
   */
  public ACGroupBox getConsignmentGroup(){
    if(consignmentGroup==null){

      consignmentGroup = new ACGroupBox();

      consignmentGroup.setText("委託先");

      consignmentGroup.setHgap(0);

      consignmentGroup.setLabelMargin(0);

      consignmentGroup.setVgap(0);

      addConsignmentGroup();
    }
    return consignmentGroup;

  }

  /**
   * 委託先事業所を取得します。
   * @return 委託先事業所
   */
  public ACComboBox getConsignmentProvider(){
    if(consignmentProvider==null){

      consignmentProvider = new ACComboBox();

      getConsignmentProviderContainer().setText("委託先事業所");

      consignmentProvider.setBindPath("1460102");

      consignmentProvider.setEditable(false);

      consignmentProvider.setRenderBindPath("PROVIDER_NAME");

      consignmentProvider.setBlankable(true);

      consignmentProvider.setIMEMode(InputSubset.KANJI);

      consignmentProvider.setMaxLength(60);

      consignmentProvider.setMaxColumns(10);

      consignmentProvider.setModel(getConsignmentProviderModel());

      addConsignmentProvider();
    }
    return consignmentProvider;

  }

  /**
   * 委託先事業所コンテナを取得します。
   * @return 委託先事業所コンテナ
   */
  protected ACLabelContainer getConsignmentProviderContainer(){
    if(consignmentProviderContainer==null){
      consignmentProviderContainer = new ACLabelContainer();
      consignmentProviderContainer.setFollowChildEnabled(true);
      consignmentProviderContainer.setVAlignment(VRLayout.CENTER);
      consignmentProviderContainer.add(getConsignmentProvider(), null);
    }
    return consignmentProviderContainer;
  }

  /**
   * 委託先事業所モデルを取得します。
   * @return 委託先事業所モデル
   */
  protected ACComboBoxModelAdapter getConsignmentProviderModel(){
    if(consignmentProviderModel==null){
      consignmentProviderModel = new ACComboBoxModelAdapter();
      addConsignmentProviderModel();
    }
    return consignmentProviderModel;
  }

  /**
   * 介護支援専門員番号を取得します。
   * @return 介護支援専門員番号
   */
  public ACTextField getConsignmentCareManagerNoText(){
    if(consignmentCareManagerNoText==null){

      consignmentCareManagerNoText = new ACTextField();

      getConsignmentCareManagerNoTextContainer().setText("介護支援専門員番号");

      consignmentCareManagerNoText.setBindPath("1460103");

      consignmentCareManagerNoText.setColumns(10);

      consignmentCareManagerNoText.setCharType(VRCharType.ONLY_DIGIT);

      consignmentCareManagerNoText.setMaxLength(8);

      addConsignmentCareManagerNoText();
    }
    return consignmentCareManagerNoText;

  }

  /**
   * 介護支援専門員番号コンテナを取得します。
   * @return 介護支援専門員番号コンテナ
   */
  protected ACLabelContainer getConsignmentCareManagerNoTextContainer(){
    if(consignmentCareManagerNoTextContainer==null){
      consignmentCareManagerNoTextContainer = new ACLabelContainer();
      consignmentCareManagerNoTextContainer.setFollowChildEnabled(true);
      consignmentCareManagerNoTextContainer.setVAlignment(VRLayout.CENTER);
      consignmentCareManagerNoTextContainer.add(getConsignmentCareManagerNoText(), null);
    }
    return consignmentCareManagerNoTextContainer;
  }

  /**
   * 介護支援専門員名を取得します。
   * @return 介護支援専門員名
   */
  public ACComboBox getConsignmentCareManagerNameCombo(){
    if(consignmentCareManagerNameCombo==null){

      consignmentCareManagerNameCombo = new ACComboBox();

      getConsignmentCareManagerNameComboContainer().setText("介護支援専門員氏名");

      consignmentCareManagerNameCombo.setEditable(false);

      consignmentCareManagerNameCombo.setRenderBindPath("CONSIGNMENT_STAFF_NAME");

      consignmentCareManagerNameCombo.setBlankable(true);

      consignmentCareManagerNameCombo.setIMEMode(InputSubset.KANJI);

      consignmentCareManagerNameCombo.setMaxLength(30);

      consignmentCareManagerNameCombo.setMaxColumns(10);

      consignmentCareManagerNameCombo.setModel(getConsignmentCareManagerNameComboModel());

      addConsignmentCareManagerNameCombo();
    }
    return consignmentCareManagerNameCombo;

  }

  /**
   * 介護支援専門員名コンテナを取得します。
   * @return 介護支援専門員名コンテナ
   */
  protected ACLabelContainer getConsignmentCareManagerNameComboContainer(){
    if(consignmentCareManagerNameComboContainer==null){
      consignmentCareManagerNameComboContainer = new ACLabelContainer();
      consignmentCareManagerNameComboContainer.setFollowChildEnabled(true);
      consignmentCareManagerNameComboContainer.setVAlignment(VRLayout.CENTER);
      consignmentCareManagerNameComboContainer.add(getConsignmentCareManagerNameCombo(), null);
    }
    return consignmentCareManagerNameComboContainer;
  }

  /**
   * 介護支援専門員名モデルを取得します。
   * @return 介護支援専門員名モデル
   */
  protected ACComboBoxModelAdapter getConsignmentCareManagerNameComboModel(){
    if(consignmentCareManagerNameComboModel==null){
      consignmentCareManagerNameComboModel = new ACComboBoxModelAdapter();
      addConsignmentCareManagerNameComboModel();
    }
    return consignmentCareManagerNameComboModel;
  }

  /**
   * コンストラクタです。
   */
  public QS001145Design() {

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

    this.add(getPreventiveSupportExpensePatterns(), VRLayout.CLIENT);

  }

  /**
   * 予防支援費パターン領域に内部項目を追加します。
   */
  protected void addPreventiveSupportExpensePatterns(){

    preventiveSupportExpensePatterns.add(getFirstTimeAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveSupportExpensePatterns.add(getCareManagerNoTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveSupportExpensePatterns.add(getCareManagerNameComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveSupportExpensePatterns.add(getConsignmentGroup(), VRLayout.FLOW);

  }

  /**
   * 初回加算に内部項目を追加します。
   */
  protected void addFirstTimeAddRadio(){

  }

  /**
   * 初回加算モデルに内部項目を追加します。
   */
  protected void addFirstTimeAddRadioModel(){

    getFirstTimeAddRadioItem1().setButtonIndex(1);
    getFirstTimeAddRadioModel().add(getFirstTimeAddRadioItem1());

    getFirstTimeAddRadioItem2().setButtonIndex(2);
    getFirstTimeAddRadioModel().add(getFirstTimeAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFirstTimeAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFirstTimeAddRadioItem2(){

  }

  /**
   * 介護支援専門員番号に内部項目を追加します。
   */
  protected void addCareManagerNoText(){

  }

  /**
   * 介護支援専門員氏名に内部項目を追加します。
   */
  protected void addCareManagerNameCombo(){

  }

  /**
   * 介護支援専門員氏名モデルに内部項目を追加します。
   */
  protected void addCareManagerNameComboModel(){

  }

  /**
   * 委託先グループに内部項目を追加します。
   */
  protected void addConsignmentGroup(){

    consignmentGroup.add(getConsignmentProviderContainer(), VRLayout.FLOW_RETURN);

    consignmentGroup.add(getConsignmentCareManagerNoTextContainer(), VRLayout.FLOW_RETURN);

    consignmentGroup.add(getConsignmentCareManagerNameComboContainer(), VRLayout.FLOW);

  }

  /**
   * 委託先事業所に内部項目を追加します。
   */
  protected void addConsignmentProvider(){

  }

  /**
   * 委託先事業所モデルに内部項目を追加します。
   */
  protected void addConsignmentProviderModel(){

  }

  /**
   * 介護支援専門員番号に内部項目を追加します。
   */
  protected void addConsignmentCareManagerNoText(){

  }

  /**
   * 介護支援専門員名に内部項目を追加します。
   */
  protected void addConsignmentCareManagerNameCombo(){

  }

  /**
   * 介護支援専門員名モデルに内部項目を追加します。
   */
  protected void addConsignmentCareManagerNameComboModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001145Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001145Design getThis() {
    return this;
  }
}
