
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
 * 開発者: 樋口　雅彦
 * 作成日: 2006/03/06  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 医療機関管理 (010)
 * プログラム 医療機関登録 (QO010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo010;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * 医療機関登録画面項目デザイン(QO010) 
 */
public class QO010Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton newData;

  private ACAffairButton clear;

  private ACPanel medicalFacilityContents;

  private ACGroupBox medicalFacilityMainContents;

  private VRLayout medicalFacilityMainContentsLayout;

  private ACTextField medicalFacilityName;

  private ACLabelContainer medicalFacilityNameContainer;

  private ACLabelContainer medicalFacilityPostnoContena;

  private ACTextField medicalFacilityPostnoOn;

  private ACLabel medicalFacilityPostnoHyphen;

  private ACTextField medicalFacilityPostnoUnder;

  private ACTextField medicalFacilityAddress;

  private ACLabelContainer medicalFacilityAddressContainer;

  private ACLabelContainer medicalFacilityTelContena;

  private ACTextField medicalFacilityTelOn;

  private ACLabel medicalFacilityTelHyphen1;

  private ACTextField medicalFacilityTelInside;

  private ACLabel medicalFacilityTelHyphen2;

  private ACTextField medicalFacilityTelUnder;

  private ACLabelContainer medicalFacilityFaxContena;

  private ACTextField medicalFacilityFaxOn;

  private ACLabel medicalFacilityFaxHyphen1;

  private ACTextField medicalFacilityFaxInside;

  private ACLabel medicalFacilityFaxHyphen2;

  private ACTextField medicalFacilityFaxUnder;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("医療機関登録");

      addButtons();
    }
    return buttons;

  }

  /**
   * 登録を取得します。
   * @return 登録
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("登録(S)");

      insert.setToolTipText("現在の内容を登録します。");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      /** @TODO ボタンのキャプションについては、追加の場合は「登録」、編集の場合は「編集」とする。 */

      addInsert();
    }
    return insert;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setToolTipText("現在の内容を更新します。");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * 新規を取得します。
   * @return 新規
   */
  public ACAffairButton getNewData(){
    if(newData==null){

      newData = new ACAffairButton();

      newData.setText("新規(N)");

      newData.setToolTipText("医療機関を新規に作成します。");

      newData.setMnemonic('N');

      newData.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addNewData();
    }
    return newData;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACAffairButton getClear(){
    if(clear==null){

      clear = new ACAffairButton();

      clear.setText("クリア(C)");

      clear.setToolTipText("医療機関の情報をクリアします。");

      clear.setMnemonic('C');

      clear.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClear();
    }
    return clear;

  }

  /**
   * 医療機関情報領域を取得します。
   * @return 医療機関情報領域
   */
  public ACPanel getMedicalFacilityContents(){
    if(medicalFacilityContents==null){

      medicalFacilityContents = new ACPanel();

      addMedicalFacilityContents();
    }
    return medicalFacilityContents;

  }

  /**
   * 医療機関メイン情報領域を取得します。
   * @return 医療機関メイン情報領域
   */
  public ACGroupBox getMedicalFacilityMainContents(){
    if(medicalFacilityMainContents==null){

      medicalFacilityMainContents = new ACGroupBox();

      medicalFacilityMainContents.setText("基本情報");

      medicalFacilityMainContents.setLayout(getMedicalFacilityMainContentsLayout());

      addMedicalFacilityMainContents();
    }
    return medicalFacilityMainContents;

  }

  /**
   * 医療機関メイン情報領域レイアウトを取得します。
   * @return 医療機関メイン情報領域レイアウト
   */
  public VRLayout getMedicalFacilityMainContentsLayout(){
    if(medicalFacilityMainContentsLayout==null){

      medicalFacilityMainContentsLayout = new VRLayout();

      medicalFacilityMainContentsLayout.setHgrid(200);

      addMedicalFacilityMainContentsLayout();
    }
    return medicalFacilityMainContentsLayout;

  }

  /**
   * 医療機関名称を取得します。
   * @return 医療機関名称
   */
  public ACTextField getMedicalFacilityName(){
    if(medicalFacilityName==null){

      medicalFacilityName = new ACTextField();

      getMedicalFacilityNameContainer().setText("医療機関名称");

      medicalFacilityName.setBindPath("MEDICAL_FACILITY_NAME");

      medicalFacilityName.setColumns(64);

      medicalFacilityName.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityName.setIMEMode(InputSubset.KANJI);

      medicalFacilityName.setMaxLength(64);

      addMedicalFacilityName();
    }
    return medicalFacilityName;

  }

  /**
   * 医療機関名称コンテナを取得します。
   * @return 医療機関名称コンテナ
   */
  protected ACLabelContainer getMedicalFacilityNameContainer(){
    if(medicalFacilityNameContainer==null){
      medicalFacilityNameContainer = new ACLabelContainer();
      medicalFacilityNameContainer.setFollowChildEnabled(true);
      medicalFacilityNameContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityNameContainer.add(getMedicalFacilityName(), null);
    }
    return medicalFacilityNameContainer;
  }

  /**
   * 郵便番号コンテナを取得します。
   * @return 郵便番号コンテナ
   */
  public ACLabelContainer getMedicalFacilityPostnoContena(){
    if(medicalFacilityPostnoContena==null){

      medicalFacilityPostnoContena = new ACLabelContainer();

      medicalFacilityPostnoContena.setText("郵便番号");

      addMedicalFacilityPostnoContena();
    }
    return medicalFacilityPostnoContena;

  }

  /**
   * 郵便番号（上を取得します。
   * @return 郵便番号（上
   */
  public ACTextField getMedicalFacilityPostnoOn(){
    if(medicalFacilityPostnoOn==null){

      medicalFacilityPostnoOn = new ACTextField();

      medicalFacilityPostnoOn.setBindPath("MEDICAL_FACILITY_ZIP_FIRST");

      medicalFacilityPostnoOn.setColumns(3);

      medicalFacilityPostnoOn.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityPostnoOn.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityPostnoOn.setIMEMode(InputSubset.LATIN);

      medicalFacilityPostnoOn.setMaxLength(3);

      addMedicalFacilityPostnoOn();
    }
    return medicalFacilityPostnoOn;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getMedicalFacilityPostnoHyphen(){
    if(medicalFacilityPostnoHyphen==null){

      medicalFacilityPostnoHyphen = new ACLabel();

      medicalFacilityPostnoHyphen.setText("-");

      addMedicalFacilityPostnoHyphen();
    }
    return medicalFacilityPostnoHyphen;

  }

  /**
   * 郵便番号（下を取得します。
   * @return 郵便番号（下
   */
  public ACTextField getMedicalFacilityPostnoUnder(){
    if(medicalFacilityPostnoUnder==null){

      medicalFacilityPostnoUnder = new ACTextField();

      medicalFacilityPostnoUnder.setBindPath("MEDICAL_FACILITY_ZIP_SECOND");

      medicalFacilityPostnoUnder.setColumns(4);

      medicalFacilityPostnoUnder.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityPostnoUnder.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityPostnoUnder.setIMEMode(InputSubset.LATIN);

      medicalFacilityPostnoUnder.setMaxLength(4);

      addMedicalFacilityPostnoUnder();
    }
    return medicalFacilityPostnoUnder;

  }

  /**
   * 所在地を取得します。
   * @return 所在地
   */
  public ACTextField getMedicalFacilityAddress(){
    if(medicalFacilityAddress==null){

      medicalFacilityAddress = new ACTextField();

      getMedicalFacilityAddressContainer().setText("所在地");

      medicalFacilityAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      medicalFacilityAddress.setColumns(70);

      medicalFacilityAddress.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityAddress.setIMEMode(InputSubset.KANJI);

      medicalFacilityAddress.setMaxLength(70);

      addMedicalFacilityAddress();
    }
    return medicalFacilityAddress;

  }

  /**
   * 所在地コンテナを取得します。
   * @return 所在地コンテナ
   */
  protected ACLabelContainer getMedicalFacilityAddressContainer(){
    if(medicalFacilityAddressContainer==null){
      medicalFacilityAddressContainer = new ACLabelContainer();
      medicalFacilityAddressContainer.setFollowChildEnabled(true);
      medicalFacilityAddressContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityAddressContainer.add(getMedicalFacilityAddress(), null);
    }
    return medicalFacilityAddressContainer;
  }

  /**
   * 電話番号コンテナを取得します。
   * @return 電話番号コンテナ
   */
  public ACLabelContainer getMedicalFacilityTelContena(){
    if(medicalFacilityTelContena==null){

      medicalFacilityTelContena = new ACLabelContainer();

      medicalFacilityTelContena.setText("電話番号");

      addMedicalFacilityTelContena();
    }
    return medicalFacilityTelContena;

  }

  /**
   * 電話番号（上を取得します。
   * @return 電話番号（上
   */
  public ACTextField getMedicalFacilityTelOn(){
    if(medicalFacilityTelOn==null){

      medicalFacilityTelOn = new ACTextField();

      medicalFacilityTelOn.setBindPath("MEDICAL_FACILITY_TEL_FIRST");

      medicalFacilityTelOn.setColumns(5);

      medicalFacilityTelOn.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityTelOn.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityTelOn.setIMEMode(InputSubset.LATIN);

      medicalFacilityTelOn.setMaxLength(5);

      addMedicalFacilityTelOn();
    }
    return medicalFacilityTelOn;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getMedicalFacilityTelHyphen1(){
    if(medicalFacilityTelHyphen1==null){

      medicalFacilityTelHyphen1 = new ACLabel();

      medicalFacilityTelHyphen1.setText("-");

      addMedicalFacilityTelHyphen1();
    }
    return medicalFacilityTelHyphen1;

  }

  /**
   * 電話番号（中を取得します。
   * @return 電話番号（中
   */
  public ACTextField getMedicalFacilityTelInside(){
    if(medicalFacilityTelInside==null){

      medicalFacilityTelInside = new ACTextField();

      medicalFacilityTelInside.setBindPath("MEDICAL_FACILITY_TEL_SECOND");

      medicalFacilityTelInside.setColumns(4);

      medicalFacilityTelInside.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityTelInside.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityTelInside.setIMEMode(InputSubset.LATIN);

      medicalFacilityTelInside.setMaxLength(4);

      addMedicalFacilityTelInside();
    }
    return medicalFacilityTelInside;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getMedicalFacilityTelHyphen2(){
    if(medicalFacilityTelHyphen2==null){

      medicalFacilityTelHyphen2 = new ACLabel();

      medicalFacilityTelHyphen2.setText("-");

      addMedicalFacilityTelHyphen2();
    }
    return medicalFacilityTelHyphen2;

  }

  /**
   * 電話番号（下を取得します。
   * @return 電話番号（下
   */
  public ACTextField getMedicalFacilityTelUnder(){
    if(medicalFacilityTelUnder==null){

      medicalFacilityTelUnder = new ACTextField();

      medicalFacilityTelUnder.setBindPath("MEDICAL_FACILITY_TEL_THIRD");

      medicalFacilityTelUnder.setColumns(4);

      medicalFacilityTelUnder.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityTelUnder.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityTelUnder.setIMEMode(InputSubset.LATIN);

      medicalFacilityTelUnder.setMaxLength(4);

      addMedicalFacilityTelUnder();
    }
    return medicalFacilityTelUnder;

  }

  /**
   * FAX番号コンテナを取得します。
   * @return FAX番号コンテナ
   */
  public ACLabelContainer getMedicalFacilityFaxContena(){
    if(medicalFacilityFaxContena==null){

      medicalFacilityFaxContena = new ACLabelContainer();

      medicalFacilityFaxContena.setText("FAX番号");

      addMedicalFacilityFaxContena();
    }
    return medicalFacilityFaxContena;

  }

  /**
   * FAX（上を取得します。
   * @return FAX（上
   */
  public ACTextField getMedicalFacilityFaxOn(){
    if(medicalFacilityFaxOn==null){

      medicalFacilityFaxOn = new ACTextField();

      medicalFacilityFaxOn.setBindPath("MEDICAL_FACILITY_FAX_FIRST");

      medicalFacilityFaxOn.setColumns(5);

      medicalFacilityFaxOn.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityFaxOn.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityFaxOn.setIMEMode(InputSubset.LATIN);

      medicalFacilityFaxOn.setMaxLength(5);

      addMedicalFacilityFaxOn();
    }
    return medicalFacilityFaxOn;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getMedicalFacilityFaxHyphen1(){
    if(medicalFacilityFaxHyphen1==null){

      medicalFacilityFaxHyphen1 = new ACLabel();

      medicalFacilityFaxHyphen1.setText("-");

      addMedicalFacilityFaxHyphen1();
    }
    return medicalFacilityFaxHyphen1;

  }

  /**
   * FAX（中を取得します。
   * @return FAX（中
   */
  public ACTextField getMedicalFacilityFaxInside(){
    if(medicalFacilityFaxInside==null){

      medicalFacilityFaxInside = new ACTextField();

      medicalFacilityFaxInside.setBindPath("MEDICAL_FACILITY_FAX_SECOND");

      medicalFacilityFaxInside.setColumns(4);

      medicalFacilityFaxInside.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityFaxInside.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityFaxInside.setIMEMode(InputSubset.LATIN);

      medicalFacilityFaxInside.setMaxLength(4);

      addMedicalFacilityFaxInside();
    }
    return medicalFacilityFaxInside;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getMedicalFacilityFaxHyphen2(){
    if(medicalFacilityFaxHyphen2==null){

      medicalFacilityFaxHyphen2 = new ACLabel();

      medicalFacilityFaxHyphen2.setText("-");

      addMedicalFacilityFaxHyphen2();
    }
    return medicalFacilityFaxHyphen2;

  }

  /**
   * FAX（下を取得します。
   * @return FAX（下
   */
  public ACTextField getMedicalFacilityFaxUnder(){
    if(medicalFacilityFaxUnder==null){

      medicalFacilityFaxUnder = new ACTextField();

      medicalFacilityFaxUnder.setBindPath("MEDICAL_FACILITY_FAX_THIRD");

      medicalFacilityFaxUnder.setColumns(4);

      medicalFacilityFaxUnder.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityFaxUnder.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityFaxUnder.setIMEMode(InputSubset.LATIN);

      medicalFacilityFaxUnder.setMaxLength(4);

      addMedicalFacilityFaxUnder();
    }
    return medicalFacilityFaxUnder;

  }

  /**
   * コンストラクタです。
   */
  public QO010Design() {

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

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getMedicalFacilityContents(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClear(), VRLayout.EAST);
    buttons.add(getNewData(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
  }

  /**
   * 登録に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * 新規に内部項目を追加します。
   */
  protected void addNewData(){

  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addClear(){

  }

  /**
   * 医療機関情報領域に内部項目を追加します。
   */
  protected void addMedicalFacilityContents(){

    medicalFacilityContents.add(getMedicalFacilityMainContents(), VRLayout.NORTH);

  }

  /**
   * 医療機関メイン情報領域に内部項目を追加します。
   */
  protected void addMedicalFacilityMainContents(){

    medicalFacilityMainContents.add(getMedicalFacilityNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityPostnoContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityFaxContena(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 医療機関メイン情報領域レイアウトに内部項目を追加します。
   */
  protected void addMedicalFacilityMainContentsLayout(){

  }

  /**
   * 医療機関名称に内部項目を追加します。
   */
  protected void addMedicalFacilityName(){

  }

  /**
   * 郵便番号コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityPostnoContena(){

    medicalFacilityPostnoContena.add(getMedicalFacilityPostnoOn(), null);

    medicalFacilityPostnoContena.add(getMedicalFacilityPostnoHyphen(), null);

    medicalFacilityPostnoContena.add(getMedicalFacilityPostnoUnder(), null);

  }

  /**
   * 郵便番号（上に内部項目を追加します。
   */
  protected void addMedicalFacilityPostnoOn(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addMedicalFacilityPostnoHyphen(){

  }

  /**
   * 郵便番号（下に内部項目を追加します。
   */
  protected void addMedicalFacilityPostnoUnder(){

  }

  /**
   * 所在地に内部項目を追加します。
   */
  protected void addMedicalFacilityAddress(){

  }

  /**
   * 電話番号コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityTelContena(){

    medicalFacilityTelContena.add(getMedicalFacilityTelOn(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelHyphen1(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelInside(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelHyphen2(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelUnder(), null);

  }

  /**
   * 電話番号（上に内部項目を追加します。
   */
  protected void addMedicalFacilityTelOn(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addMedicalFacilityTelHyphen1(){

  }

  /**
   * 電話番号（中に内部項目を追加します。
   */
  protected void addMedicalFacilityTelInside(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addMedicalFacilityTelHyphen2(){

  }

  /**
   * 電話番号（下に内部項目を追加します。
   */
  protected void addMedicalFacilityTelUnder(){

  }

  /**
   * FAX番号コンテナに内部項目を追加します。
   */
  protected void addMedicalFacilityFaxContena(){

    medicalFacilityFaxContena.add(getMedicalFacilityFaxOn(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxHyphen1(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxInside(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxHyphen2(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxUnder(), null);

  }

  /**
   * FAX（上に内部項目を追加します。
   */
  protected void addMedicalFacilityFaxOn(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addMedicalFacilityFaxHyphen1(){

  }

  /**
   * FAX（中に内部項目を追加します。
   */
  protected void addMedicalFacilityFaxInside(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addMedicalFacilityFaxHyphen2(){

  }

  /**
   * FAX（下に内部項目を追加します。
   */
  protected void addMedicalFacilityFaxUnder(){

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

    return getMedicalFacilityName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO010Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO010Design getThis() {
    return this;
  }
}
