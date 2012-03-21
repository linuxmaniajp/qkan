
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
 * 作成日: 2012/02/24  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 保険者一覧登録 (002)
 * プログラム 保険者一覧登録 (QO002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
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
 * 保険者一覧登録画面項目デザイン(QO002) 
 */
public class QO002Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton newData;

  private ACAffairButton clear;

  private ACPanel contents;

  private ACGroupBox insurerSetInfos;

  private ACPanel insurerInfos;

  private ACTextField insurerId;

  private ACLabelContainer insurerIdContainer;

  private ACButton insurerSelectButton;

  private ACTextField insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACLabelContainer insurerZipConteinar;

  private ACTextField insurerZip1;

  private ACLabel insurerZipLabel;

  private ACTextField insurerZip2;

  private ACTextField insurerAddress;

  private ACLabelContainer insurerAddressContainer;

  private ACLabelContainer insurerTelConteinar;

  private ACTextField insurerTel1;

  private ACLabel insurerTelLabel1;

  private ACTextField insurerTel2;

  private ACLabel insurerTelLabel2;

  private ACTextField insurerTel3;

  private ACClearableRadioButtonGroup insurerType;

  private ACLabelContainer insurerTypeContainer;

  private ACListModelAdapter insurerTypeModel;

  private ACRadioButtonItem insurerTypeCare;

  private ACRadioButtonItem insurerTypeMedical;

  private ACLabel insurerTypeInfomation;

  private ACPanel insurerLimitPanel;

  private ACIntegerCheckBox insurerLimitRateEnableCheck;

  private ACGroupBox insurerLimitRateInfos;

  private ACPanel insurerLimitRateInfo;

  private ACPanel insurerLimitRatePanel;

  private ACTable insurerLimitRateTable;

  private VRTableColumnModel insurerLimitRateTableColumnModel;

  private ACTableColumn insurerLimitRateTableColum1;

  private ACTableColumn insurerLimitRateTableColum10;

  private ACTableColumn insurerLimitRateTableColum11;

  private ACTableColumn insurerLimitRateTableColum2;

  private ACTableColumn insurerLimitRateTableColum3;

  private ACTableColumn insurerLimitRateTableColum4;

  private ACTableColumn insurerLimitRateTableColum5;

  private ACTableColumn insurerLimitRateTableColum6;

  private ACTableColumn insurerLimitRateTableColum7;

  private ACTableColumn insurerLimitRateTableColum8;

  private ACTableColumn insurerLimitRateTableColum9;

  private ACPanel validPeriodPanel;

  private ACPanel validPeriodRight;

  private ACPanel insurerLimitRateButtons;

  private ACButton insurerLimitRateRegularButton;

  private ACButton insurerLimitRateInsertButton;

  private ACButton insurerLimitRateEditButton;

  private ACButton insurerLimitRateDeleteButton;

  private ACPanel validPeriodLeft;

  private ACLabelContainer validPeriodCpntena;

  private QkanDateTextField validPeriodStart;

  private ACLabel validPeriodLabel;

  private QkanDateTextField validPeriodEnd;

  private ACTextField yosien1;

  private ACLabelContainer yosien1Container;

  private ACTextField yosien2;

  private ACLabelContainer yosien2Container;

  private ACTextField yosien;

  private ACLabelContainer yosienContainer;

  private ACTextField yokaigo1;

  private ACLabelContainer yokaigo1Container;

  private ACTextField yokaigo2;

  private ACLabelContainer yokaigo2Container;

  private ACTextField yokaigo3;

  private ACLabelContainer yokaigo3Container;

  private ACTextField yokaigo4;

  private ACLabelContainer yokaigo4Container;

  private ACTextField yokaigo5;

  private ACLabelContainer yokaigo5Container;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("保険者登録");

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

      newData.setToolTipText("保険者を新規に作成します。");

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

      clear.setToolTipText("保険者の情報をクリアします。");

      clear.setMnemonic('C');

      clear.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClear();
    }
    return clear;

  }

  /**
   * 入力領域を取得します。
   * @return 入力領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 保険者情報設定領域を取得します。
   * @return 保険者情報設定領域
   */
  public ACGroupBox getInsurerSetInfos(){
    if(insurerSetInfos==null){

      insurerSetInfos = new ACGroupBox();

      insurerSetInfos.setText("基本情報");

      insurerSetInfos.setVgap(5);

      addInsurerSetInfos();
    }
    return insurerSetInfos;

  }

  /**
   * 保険者情報入力領域を取得します。
   * @return 保険者情報入力領域
   */
  public ACPanel getInsurerInfos(){
    if(insurerInfos==null){

      insurerInfos = new ACPanel();

      insurerInfos.setHgap(1);

      addInsurerInfos();
    }
    return insurerInfos;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getInsurerId(){
    if(insurerId==null){

      insurerId = new ACTextField();

      getInsurerIdContainer().setText("保険者番号");

      insurerId.setBindPath("INSURER_ID");

      insurerId.setColumns(5);

      insurerId.setCharType(VRCharType.ONLY_DIGIT);

      insurerId.setHorizontalAlignment(SwingConstants.LEFT);

      insurerId.setIMEMode(InputSubset.LATIN);

      insurerId.setMaxLength(6);

      addInsurerId();
    }
    return insurerId;

  }

  /**
   * 保険者番号コンテナを取得します。
   * @return 保険者番号コンテナ
   */
  protected ACLabelContainer getInsurerIdContainer(){
    if(insurerIdContainer==null){
      insurerIdContainer = new ACLabelContainer();
      insurerIdContainer.setFollowChildEnabled(true);
      insurerIdContainer.setVAlignment(VRLayout.CENTER);
      insurerIdContainer.add(getInsurerId(), null);
    }
    return insurerIdContainer;
  }

  /**
   * 保険者選択を取得します。
   * @return 保険者選択
   */
  public ACButton getInsurerSelectButton(){
    if(insurerSelectButton==null){

      insurerSelectButton = new ACButton();

      insurerSelectButton.setText("保険者選択(I)");

      insurerSelectButton.setToolTipText("保険者を一覧より選択します。");

      insurerSelectButton.setMnemonic('I');

      addInsurerSelectButton();
    }
    return insurerSelectButton;

  }

  /**
   * 保険者名称を取得します。
   * @return 保険者名称
   */
  public ACTextField getInsurerName(){
    if(insurerName==null){

      insurerName = new ACTextField();

      getInsurerNameContainer().setText("保険者名称");

      insurerName.setBindPath("INSURER_NAME");

      insurerName.setColumns(32);

      insurerName.setHorizontalAlignment(SwingConstants.LEFT);

      insurerName.setIMEMode(InputSubset.KANJI);

      insurerName.setMaxLength(32);

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * 保険者名称コンテナを取得します。
   * @return 保険者名称コンテナ
   */
  protected ACLabelContainer getInsurerNameContainer(){
    if(insurerNameContainer==null){
      insurerNameContainer = new ACLabelContainer();
      insurerNameContainer.setFollowChildEnabled(true);
      insurerNameContainer.setVAlignment(VRLayout.CENTER);
      insurerNameContainer.add(getInsurerName(), null);
    }
    return insurerNameContainer;
  }

  /**
   * 保険者郵便番号・コンテナを取得します。
   * @return 保険者郵便番号・コンテナ
   */
  public ACLabelContainer getInsurerZipConteinar(){
    if(insurerZipConteinar==null){

      insurerZipConteinar = new ACLabelContainer();

      insurerZipConteinar.setText("郵便番号");

      addInsurerZipConteinar();
    }
    return insurerZipConteinar;

  }

  /**
   * 保険者郵便番号入力領域1を取得します。
   * @return 保険者郵便番号入力領域1
   */
  public ACTextField getInsurerZip1(){
    if(insurerZip1==null){

      insurerZip1 = new ACTextField();

      insurerZip1.setBindPath("INSURER_ZIP_FIRST");

      insurerZip1.setColumns(2);

      insurerZip1.setCharType(VRCharType.ONLY_DIGIT);

      insurerZip1.setIMEMode(InputSubset.LATIN);

      insurerZip1.setMaxLength(3);

      addInsurerZip1();
    }
    return insurerZip1;

  }

  /**
   * 保険者郵便番号ラベルを取得します。
   * @return 保険者郵便番号ラベル
   */
  public ACLabel getInsurerZipLabel(){
    if(insurerZipLabel==null){

      insurerZipLabel = new ACLabel();

      insurerZipLabel.setText("-");

      addInsurerZipLabel();
    }
    return insurerZipLabel;

  }

  /**
   * 保険者郵便番号入力領域2を取得します。
   * @return 保険者郵便番号入力領域2
   */
  public ACTextField getInsurerZip2(){
    if(insurerZip2==null){

      insurerZip2 = new ACTextField();

      insurerZip2.setBindPath("INSURER_ZIP_SECOND");

      insurerZip2.setColumns(3);

      insurerZip2.setCharType(VRCharType.ONLY_DIGIT);

      insurerZip2.setIMEMode(InputSubset.LATIN);

      insurerZip2.setMaxLength(4);

      addInsurerZip2();
    }
    return insurerZip2;

  }

  /**
   * 保険者所在地を取得します。
   * @return 保険者所在地
   */
  public ACTextField getInsurerAddress(){
    if(insurerAddress==null){

      insurerAddress = new ACTextField();

      getInsurerAddressContainer().setText("所在地");

      insurerAddress.setBindPath("INSURER_ADDRESS");

      insurerAddress.setColumns(64);

      insurerAddress.setHorizontalAlignment(SwingConstants.LEFT);

      insurerAddress.setIMEMode(InputSubset.KANJI);

      insurerAddress.setMaxLength(64);

      addInsurerAddress();
    }
    return insurerAddress;

  }

  /**
   * 保険者所在地コンテナを取得します。
   * @return 保険者所在地コンテナ
   */
  protected ACLabelContainer getInsurerAddressContainer(){
    if(insurerAddressContainer==null){
      insurerAddressContainer = new ACLabelContainer();
      insurerAddressContainer.setFollowChildEnabled(true);
      insurerAddressContainer.setVAlignment(VRLayout.CENTER);
      insurerAddressContainer.add(getInsurerAddress(), null);
    }
    return insurerAddressContainer;
  }

  /**
   * 保険者電話番号・コンテナを取得します。
   * @return 保険者電話番号・コンテナ
   */
  public ACLabelContainer getInsurerTelConteinar(){
    if(insurerTelConteinar==null){

      insurerTelConteinar = new ACLabelContainer();

      insurerTelConteinar.setText("電話番号");

      addInsurerTelConteinar();
    }
    return insurerTelConteinar;

  }

  /**
   * 保険者電話番号入力領域1を取得します。
   * @return 保険者電話番号入力領域1
   */
  public ACTextField getInsurerTel1(){
    if(insurerTel1==null){

      insurerTel1 = new ACTextField();

      insurerTel1.setBindPath("INSURER_TEL_FIRST");

      insurerTel1.setColumns(4);

      insurerTel1.setCharType(VRCharType.ONLY_DIGIT);

      insurerTel1.setIMEMode(InputSubset.LATIN);

      insurerTel1.setMaxLength(6);

      addInsurerTel1();
    }
    return insurerTel1;

  }

  /**
   * 保険者電話番号ラベルを取得します。
   * @return 保険者電話番号ラベル
   */
  public ACLabel getInsurerTelLabel1(){
    if(insurerTelLabel1==null){

      insurerTelLabel1 = new ACLabel();

      insurerTelLabel1.setText("-");

      addInsurerTelLabel1();
    }
    return insurerTelLabel1;

  }

  /**
   * 保険者電話番号入力領域2を取得します。
   * @return 保険者電話番号入力領域2
   */
  public ACTextField getInsurerTel2(){
    if(insurerTel2==null){

      insurerTel2 = new ACTextField();

      insurerTel2.setBindPath("INSURER_TEL_SECOND");

      insurerTel2.setColumns(3);

      insurerTel2.setCharType(VRCharType.ONLY_DIGIT);

      insurerTel2.setIMEMode(InputSubset.LATIN);

      insurerTel2.setMaxLength(4);

      addInsurerTel2();
    }
    return insurerTel2;

  }

  /**
   * 保険者電話番号ラベルを取得します。
   * @return 保険者電話番号ラベル
   */
  public ACLabel getInsurerTelLabel2(){
    if(insurerTelLabel2==null){

      insurerTelLabel2 = new ACLabel();

      insurerTelLabel2.setText("-");

      addInsurerTelLabel2();
    }
    return insurerTelLabel2;

  }

  /**
   * 保険者電話番号入力領域3を取得します。
   * @return 保険者電話番号入力領域3
   */
  public ACTextField getInsurerTel3(){
    if(insurerTel3==null){

      insurerTel3 = new ACTextField();

      insurerTel3.setBindPath("INSURER_TEL_THIRD");

      insurerTel3.setColumns(3);

      insurerTel3.setCharType(VRCharType.ONLY_DIGIT);

      insurerTel3.setIMEMode(InputSubset.LATIN);

      insurerTel3.setMaxLength(4);

      addInsurerTel3();
    }
    return insurerTel3;

  }

  /**
   * 保険者区分を取得します。
   * @return 保険者区分
   */
  public ACClearableRadioButtonGroup getInsurerType(){
    if(insurerType==null){

      insurerType = new ACClearableRadioButtonGroup();

      getInsurerTypeContainer().setText("保険者区分");

      insurerType.setBindPath("INSURER_TYPE");

      insurerType.setModel(getInsurerTypeModel());

      addInsurerType();
    }
    return insurerType;

  }

  /**
   * 保険者区分コンテナを取得します。
   * @return 保険者区分コンテナ
   */
  protected ACLabelContainer getInsurerTypeContainer(){
    if(insurerTypeContainer==null){
      insurerTypeContainer = new ACLabelContainer();
      insurerTypeContainer.setFollowChildEnabled(true);
      insurerTypeContainer.setVAlignment(VRLayout.CENTER);
      insurerTypeContainer.add(getInsurerType(), null);
    }
    return insurerTypeContainer;
  }

  /**
   * 保険者区分モデルを取得します。
   * @return 保険者区分モデル
   */
  protected ACListModelAdapter getInsurerTypeModel(){
    if(insurerTypeModel==null){
      insurerTypeModel = new ACListModelAdapter();
      addInsurerTypeModel();
    }
    return insurerTypeModel;
  }

  /**
   * 介護を取得します。
   * @return 介護
   */
  public ACRadioButtonItem getInsurerTypeCare(){
    if(insurerTypeCare==null){

      insurerTypeCare = new ACRadioButtonItem();

      insurerTypeCare.setText("介護");

      insurerTypeCare.setGroup(getInsurerType());

      addInsurerTypeCare();
    }
    return insurerTypeCare;

  }

  /**
   * 医療を取得します。
   * @return 医療
   */
  public ACRadioButtonItem getInsurerTypeMedical(){
    if(insurerTypeMedical==null){

      insurerTypeMedical = new ACRadioButtonItem();

      insurerTypeMedical.setText("医療");

      insurerTypeMedical.setGroup(getInsurerType());

      addInsurerTypeMedical();
    }
    return insurerTypeMedical;

  }

  /**
   * 保険者区分説明を取得します。
   * @return 保険者区分説明
   */
  public ACLabel getInsurerTypeInfomation(){
    if(insurerTypeInfomation==null){

      insurerTypeInfomation = new ACLabel();

      insurerTypeInfomation.setText("同一の保険者番号で介護と医療を対象にしている保険者は、クリアボタンで保険者区分を未選択状態にして登録します。");

      insurerTypeInfomation.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addInsurerTypeInfomation();
    }
    return insurerTypeInfomation;

  }

  /**
   * パネルを取得します。
   * @return パネル
   */
  public ACPanel getInsurerLimitPanel(){
    if(insurerLimitPanel==null){

      insurerLimitPanel = new ACPanel();

      addInsurerLimitPanel();
    }
    return insurerLimitPanel;

  }

  /**
   * 支給限度額有効切り替えチェックを取得します。
   * @return 支給限度額有効切り替えチェック
   */
  public ACIntegerCheckBox getInsurerLimitRateEnableCheck(){
    if(insurerLimitRateEnableCheck==null){

      insurerLimitRateEnableCheck = new ACIntegerCheckBox();

      insurerLimitRateEnableCheck.setText("区分支給限度額を変更する");

      addInsurerLimitRateEnableCheck();
    }
    return insurerLimitRateEnableCheck;

  }

  /**
   * 保険者支給限度額情報領域を取得します。
   * @return 保険者支給限度額情報領域
   */
  public ACGroupBox getInsurerLimitRateInfos(){
    if(insurerLimitRateInfos==null){

      insurerLimitRateInfos = new ACGroupBox();

      insurerLimitRateInfos.setText("区分支給限度額情報");

      insurerLimitRateInfos.setFollowChildEnabled(true);

      insurerLimitRateInfos.setVgap(5);

      addInsurerLimitRateInfos();
    }
    return insurerLimitRateInfos;

  }

  /**
   * 保険者支給限度額情報パネルを取得します。
   * @return 保険者支給限度額情報パネル
   */
  public ACPanel getInsurerLimitRateInfo(){
    if(insurerLimitRateInfo==null){

      insurerLimitRateInfo = new ACPanel();

      insurerLimitRateInfo.setEnabled(false);

      insurerLimitRateInfo.setAutoWrap(false);

      insurerLimitRateInfo.setFollowChildEnabled(true);

      insurerLimitRateInfo.setHgap(0);

      insurerLimitRateInfo.setLabelMargin(0);

      insurerLimitRateInfo.setVgap(5);

      addInsurerLimitRateInfo();
    }
    return insurerLimitRateInfo;

  }

  /**
   * 支給限度額情報パネルを取得します。
   * @return 支給限度額情報パネル
   */
  public ACPanel getInsurerLimitRatePanel(){
    if(insurerLimitRatePanel==null){

      insurerLimitRatePanel = new ACPanel();

      insurerLimitRatePanel.setFollowChildEnabled(true);

      addInsurerLimitRatePanel();
    }
    return insurerLimitRatePanel;

  }

  /**
   * 支給限度額情報テーブルを取得します。
   * @return 支給限度額情報テーブル
   */
  public ACTable getInsurerLimitRateTable(){
    if(insurerLimitRateTable==null){

      insurerLimitRateTable = new ACTable();

      insurerLimitRateTable.setColumnModel(getInsurerLimitRateTableColumnModel());

      addInsurerLimitRateTable();
    }
    return insurerLimitRateTable;

  }

  /**
   * 支給限度額情報テーブルカラムモデルを取得します。
   * @return 支給限度額情報テーブルカラムモデル
   */
  protected VRTableColumnModel getInsurerLimitRateTableColumnModel(){
    if(insurerLimitRateTableColumnModel==null){
      insurerLimitRateTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addInsurerLimitRateTableColumnModel();
    }
    return insurerLimitRateTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getInsurerLimitRateTableColum1(){
    if(insurerLimitRateTableColum1==null){

      insurerLimitRateTableColum1 = new ACTableColumn();

      insurerLimitRateTableColum1.setHeaderValue("No.");

      insurerLimitRateTableColum1.setColumns(3);

      insurerLimitRateTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      insurerLimitRateTableColum1.setSortable(false);

      addInsurerLimitRateTableColum1();
    }
    return insurerLimitRateTableColum1;

  }

  /**
   * 要支援1を取得します。
   * @return 要支援1
   */
  public ACTableColumn getInsurerLimitRateTableColum10(){
    if(insurerLimitRateTableColum10==null){

      insurerLimitRateTableColum10 = new ACTableColumn(0);

      insurerLimitRateTableColum10.setHeaderValue("要支援1");

      insurerLimitRateTableColum10.setColumns(6);

      addInsurerLimitRateTableColum10();
    }
    return insurerLimitRateTableColum10;

  }

  /**
   * 要支援2を取得します。
   * @return 要支援2
   */
  public ACTableColumn getInsurerLimitRateTableColum11(){
    if(insurerLimitRateTableColum11==null){

      insurerLimitRateTableColum11 = new ACTableColumn(1);

      insurerLimitRateTableColum11.setHeaderValue("要支援2");

      insurerLimitRateTableColum11.setColumns(7);

      addInsurerLimitRateTableColum11();
    }
    return insurerLimitRateTableColum11;

  }

  /**
   * 経過的要介護を取得します。
   * @return 経過的要介護
   */
  public ACTableColumn getInsurerLimitRateTableColum2(){
    if(insurerLimitRateTableColum2==null){

      insurerLimitRateTableColum2 = new ACTableColumn(2);

      insurerLimitRateTableColum2.setHeaderValue("経過的要介護");

      insurerLimitRateTableColum2.setColumns(7);

      addInsurerLimitRateTableColum2();
    }
    return insurerLimitRateTableColum2;

  }

  /**
   * 要介護1を取得します。
   * @return 要介護1
   */
  public ACTableColumn getInsurerLimitRateTableColum3(){
    if(insurerLimitRateTableColum3==null){

      insurerLimitRateTableColum3 = new ACTableColumn(3);

      insurerLimitRateTableColum3.setHeaderValue("要介護1");

      insurerLimitRateTableColum3.setColumns(7);

      addInsurerLimitRateTableColum3();
    }
    return insurerLimitRateTableColum3;

  }

  /**
   * 要介護2を取得します。
   * @return 要介護2
   */
  public ACTableColumn getInsurerLimitRateTableColum4(){
    if(insurerLimitRateTableColum4==null){

      insurerLimitRateTableColum4 = new ACTableColumn(4);

      insurerLimitRateTableColum4.setHeaderValue("要介護2");

      insurerLimitRateTableColum4.setColumns(7);

      addInsurerLimitRateTableColum4();
    }
    return insurerLimitRateTableColum4;

  }

  /**
   * 要介護3を取得します。
   * @return 要介護3
   */
  public ACTableColumn getInsurerLimitRateTableColum5(){
    if(insurerLimitRateTableColum5==null){

      insurerLimitRateTableColum5 = new ACTableColumn(5);

      insurerLimitRateTableColum5.setHeaderValue("要介護3");

      insurerLimitRateTableColum5.setColumns(7);

      addInsurerLimitRateTableColum5();
    }
    return insurerLimitRateTableColum5;

  }

  /**
   * 要介護4を取得します。
   * @return 要介護4
   */
  public ACTableColumn getInsurerLimitRateTableColum6(){
    if(insurerLimitRateTableColum6==null){

      insurerLimitRateTableColum6 = new ACTableColumn(6);

      insurerLimitRateTableColum6.setHeaderValue("要介護4");

      insurerLimitRateTableColum6.setColumns(7);

      addInsurerLimitRateTableColum6();
    }
    return insurerLimitRateTableColum6;

  }

  /**
   * 要介護5を取得します。
   * @return 要介護5
   */
  public ACTableColumn getInsurerLimitRateTableColum7(){
    if(insurerLimitRateTableColum7==null){

      insurerLimitRateTableColum7 = new ACTableColumn(7);

      insurerLimitRateTableColum7.setHeaderValue("要介護5");

      insurerLimitRateTableColum7.setColumns(7);

      addInsurerLimitRateTableColum7();
    }
    return insurerLimitRateTableColum7;

  }

  /**
   * 保険者情報有効期間(開始）を取得します。
   * @return 保険者情報有効期間(開始）
   */
  public ACTableColumn getInsurerLimitRateTableColum8(){
    if(insurerLimitRateTableColum8==null){

      insurerLimitRateTableColum8 = new ACTableColumn(8);

      insurerLimitRateTableColum8.setHeaderValue("有効期間(開始）");

      insurerLimitRateTableColum8.setColumns(12);

      insurerLimitRateTableColum8.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addInsurerLimitRateTableColum8();
    }
    return insurerLimitRateTableColum8;

  }

  /**
   * 保険者情報有効期間(終了）を取得します。
   * @return 保険者情報有効期間(終了）
   */
  public ACTableColumn getInsurerLimitRateTableColum9(){
    if(insurerLimitRateTableColum9==null){

      insurerLimitRateTableColum9 = new ACTableColumn(9);

      insurerLimitRateTableColum9.setHeaderValue("有効期間(終了）");

      insurerLimitRateTableColum9.setColumns(12);

      insurerLimitRateTableColum9.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addInsurerLimitRateTableColum9();
    }
    return insurerLimitRateTableColum9;

  }

  /**
   * 有効期間領域を取得します。
   * @return 有効期間領域
   */
  public ACPanel getValidPeriodPanel(){
    if(validPeriodPanel==null){

      validPeriodPanel = new ACPanel();

      validPeriodPanel.setAutoWrap(false);

      validPeriodPanel.setFollowChildEnabled(true);

      addValidPeriodPanel();
    }
    return validPeriodPanel;

  }

  /**
   * 有効期間領域右を取得します。
   * @return 有効期間領域右
   */
  public ACPanel getValidPeriodRight(){
    if(validPeriodRight==null){

      validPeriodRight = new ACPanel();

      validPeriodRight.setFollowChildEnabled(true);

      addValidPeriodRight();
    }
    return validPeriodRight;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getInsurerLimitRateButtons(){
    if(insurerLimitRateButtons==null){

      insurerLimitRateButtons = new ACPanel();

      insurerLimitRateButtons.setFollowChildEnabled(true);

      addInsurerLimitRateButtons();
    }
    return insurerLimitRateButtons;

  }

  /**
   * 規定を取得します。
   * @return 規定
   */
  public ACButton getInsurerLimitRateRegularButton(){
    if(insurerLimitRateRegularButton==null){

      insurerLimitRateRegularButton = new ACButton();

      insurerLimitRateRegularButton.setText("規定");

      insurerLimitRateRegularButton.setToolTipText("厚生労働省規定の支給限度額を設定します。");

      insurerLimitRateRegularButton.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addInsurerLimitRateRegularButton();
    }
    return insurerLimitRateRegularButton;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getInsurerLimitRateInsertButton(){
    if(insurerLimitRateInsertButton==null){

      insurerLimitRateInsertButton = new ACButton();

      insurerLimitRateInsertButton.setText("追加");

      insurerLimitRateInsertButton.setToolTipText("保険者の支給限度額情報を追加します。");

      insurerLimitRateInsertButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addInsurerLimitRateInsertButton();
    }
    return insurerLimitRateInsertButton;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getInsurerLimitRateEditButton(){
    if(insurerLimitRateEditButton==null){

      insurerLimitRateEditButton = new ACButton();

      insurerLimitRateEditButton.setText("書替");

      insurerLimitRateEditButton.setToolTipText("選択中の支給限度額情報を編集します。");

      insurerLimitRateEditButton.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addInsurerLimitRateEditButton();
    }
    return insurerLimitRateEditButton;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getInsurerLimitRateDeleteButton(){
    if(insurerLimitRateDeleteButton==null){

      insurerLimitRateDeleteButton = new ACButton();

      insurerLimitRateDeleteButton.setText("削除");

      insurerLimitRateDeleteButton.setToolTipText("選択中の保険者の全情報を削除します。");

      insurerLimitRateDeleteButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addInsurerLimitRateDeleteButton();
    }
    return insurerLimitRateDeleteButton;

  }

  /**
   * 有効期間領域左を取得します。
   * @return 有効期間領域左
   */
  public ACPanel getValidPeriodLeft(){
    if(validPeriodLeft==null){

      validPeriodLeft = new ACPanel();

      validPeriodLeft.setAutoWrap(true);

      validPeriodLeft.setFollowChildEnabled(true);

      validPeriodLeft.setHgap(0);

      validPeriodLeft.setLabelMargin(0);

      addValidPeriodLeft();
    }
    return validPeriodLeft;

  }

  /**
   * 有効期間コンテナを取得します。
   * @return 有効期間コンテナ
   */
  public ACLabelContainer getValidPeriodCpntena(){
    if(validPeriodCpntena==null){

      validPeriodCpntena = new ACLabelContainer();

      validPeriodCpntena.setText("有効期間");

      validPeriodCpntena.setFollowChildEnabled(true);

      addValidPeriodCpntena();
    }
    return validPeriodCpntena;

  }

  /**
   * 有効期間テキスト（開始）を取得します。
   * @return 有効期間テキスト（開始）
   */
  public QkanDateTextField getValidPeriodStart(){
    if(validPeriodStart==null){

      validPeriodStart = new QkanDateTextField();

      validPeriodStart.setBindPath("LIMIT_RATE_VALID_START");

      addValidPeriodStart();
    }
    return validPeriodStart;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getValidPeriodLabel(){
    if(validPeriodLabel==null){

      validPeriodLabel = new ACLabel();

      validPeriodLabel.setText("から");

      addValidPeriodLabel();
    }
    return validPeriodLabel;

  }

  /**
   * 有効期間テキスト（終了）を取得します。
   * @return 有効期間テキスト（終了）
   */
  public QkanDateTextField getValidPeriodEnd(){
    if(validPeriodEnd==null){

      validPeriodEnd = new QkanDateTextField();

      validPeriodEnd.setBindPath("LIMIT_RATE_VALID_END");

      addValidPeriodEnd();
    }
    return validPeriodEnd;

  }

  /**
   * 要支援1テキストを取得します。
   * @return 要支援1テキスト
   */
  public ACTextField getYosien1(){
    if(yosien1==null){

      yosien1 = new ACTextField();

      getYosien1Container().setText("要支援１");

      yosien1.setBindPath("12");

      yosien1.setColumns(4);

      yosien1.setCharType(VRCharType.ONLY_DIGIT);

      yosien1.setHorizontalAlignment(SwingConstants.RIGHT);

      yosien1.setIMEMode(InputSubset.LATIN);

      yosien1.setMaxLength(5);

      addYosien1();
    }
    return yosien1;

  }

  /**
   * 要支援1テキストコンテナを取得します。
   * @return 要支援1テキストコンテナ
   */
  protected ACLabelContainer getYosien1Container(){
    if(yosien1Container==null){
      yosien1Container = new ACLabelContainer();
      yosien1Container.setFollowChildEnabled(true);
      yosien1Container.setVAlignment(VRLayout.CENTER);
      yosien1Container.add(getYosien1(), null);
    }
    return yosien1Container;
  }

  /**
   * 要支援2テキストを取得します。
   * @return 要支援2テキスト
   */
  public ACTextField getYosien2(){
    if(yosien2==null){

      yosien2 = new ACTextField();

      getYosien2Container().setText("要支援２");

      yosien2.setBindPath("13");

      yosien2.setColumns(4);

      yosien2.setCharType(VRCharType.ONLY_DIGIT);

      yosien2.setHorizontalAlignment(SwingConstants.RIGHT);

      yosien2.setIMEMode(InputSubset.LATIN);

      yosien2.setMaxLength(5);

      addYosien2();
    }
    return yosien2;

  }

  /**
   * 要支援2テキストコンテナを取得します。
   * @return 要支援2テキストコンテナ
   */
  protected ACLabelContainer getYosien2Container(){
    if(yosien2Container==null){
      yosien2Container = new ACLabelContainer();
      yosien2Container.setFollowChildEnabled(true);
      yosien2Container.setVAlignment(VRLayout.CENTER);
      yosien2Container.add(getYosien2(), null);
    }
    return yosien2Container;
  }

  /**
   * 経過的要介護テキストを取得します。
   * @return 経過的要介護テキスト
   */
  public ACTextField getYosien(){
    if(yosien==null){

      yosien = new ACTextField();

      getYosienContainer().setText("経過的要介護");

      yosien.setBindPath("11");

      yosien.setColumns(4);

      yosien.setCharType(VRCharType.ONLY_DIGIT);

      yosien.setHorizontalAlignment(SwingConstants.RIGHT);

      yosien.setIMEMode(InputSubset.LATIN);

      yosien.setMaxLength(5);

      addYosien();
    }
    return yosien;

  }

  /**
   * 経過的要介護テキストコンテナを取得します。
   * @return 経過的要介護テキストコンテナ
   */
  protected ACLabelContainer getYosienContainer(){
    if(yosienContainer==null){
      yosienContainer = new ACLabelContainer();
      yosienContainer.setFollowChildEnabled(true);
      yosienContainer.setVAlignment(VRLayout.CENTER);
      yosienContainer.add(getYosien(), null);
    }
    return yosienContainer;
  }

  /**
   * 要介護度1テキストを取得します。
   * @return 要介護度1テキスト
   */
  public ACTextField getYokaigo1(){
    if(yokaigo1==null){

      yokaigo1 = new ACTextField();

      getYokaigo1Container().setText("要介護１");

      yokaigo1.setBindPath("21");

      yokaigo1.setColumns(4);

      yokaigo1.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo1.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo1.setIMEMode(InputSubset.LATIN);

      yokaigo1.setMaxLength(5);

      addYokaigo1();
    }
    return yokaigo1;

  }

  /**
   * 要介護度1テキストコンテナを取得します。
   * @return 要介護度1テキストコンテナ
   */
  protected ACLabelContainer getYokaigo1Container(){
    if(yokaigo1Container==null){
      yokaigo1Container = new ACLabelContainer();
      yokaigo1Container.setFollowChildEnabled(true);
      yokaigo1Container.setVAlignment(VRLayout.CENTER);
      yokaigo1Container.add(getYokaigo1(), null);
    }
    return yokaigo1Container;
  }

  /**
   * 要介護度2テキストを取得します。
   * @return 要介護度2テキスト
   */
  public ACTextField getYokaigo2(){
    if(yokaigo2==null){

      yokaigo2 = new ACTextField();

      getYokaigo2Container().setText("要介護２");

      yokaigo2.setBindPath("22");

      yokaigo2.setColumns(4);

      yokaigo2.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo2.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo2.setIMEMode(InputSubset.LATIN);

      yokaigo2.setMaxLength(5);

      addYokaigo2();
    }
    return yokaigo2;

  }

  /**
   * 要介護度2テキストコンテナを取得します。
   * @return 要介護度2テキストコンテナ
   */
  protected ACLabelContainer getYokaigo2Container(){
    if(yokaigo2Container==null){
      yokaigo2Container = new ACLabelContainer();
      yokaigo2Container.setFollowChildEnabled(true);
      yokaigo2Container.setVAlignment(VRLayout.CENTER);
      yokaigo2Container.add(getYokaigo2(), null);
    }
    return yokaigo2Container;
  }

  /**
   * 要介護度3テキストを取得します。
   * @return 要介護度3テキスト
   */
  public ACTextField getYokaigo3(){
    if(yokaigo3==null){

      yokaigo3 = new ACTextField();

      getYokaigo3Container().setText("要介護３");

      yokaigo3.setBindPath("23");

      yokaigo3.setColumns(4);

      yokaigo3.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo3.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo3.setIMEMode(InputSubset.LATIN);

      yokaigo3.setMaxLength(5);

      addYokaigo3();
    }
    return yokaigo3;

  }

  /**
   * 要介護度3テキストコンテナを取得します。
   * @return 要介護度3テキストコンテナ
   */
  protected ACLabelContainer getYokaigo3Container(){
    if(yokaigo3Container==null){
      yokaigo3Container = new ACLabelContainer();
      yokaigo3Container.setFollowChildEnabled(true);
      yokaigo3Container.setVAlignment(VRLayout.CENTER);
      yokaigo3Container.add(getYokaigo3(), null);
    }
    return yokaigo3Container;
  }

  /**
   * 要介護度4テキストを取得します。
   * @return 要介護度4テキスト
   */
  public ACTextField getYokaigo4(){
    if(yokaigo4==null){

      yokaigo4 = new ACTextField();

      getYokaigo4Container().setText("要介護４");

      yokaigo4.setBindPath("24");

      yokaigo4.setColumns(4);

      yokaigo4.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo4.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo4.setIMEMode(InputSubset.LATIN);

      yokaigo4.setMaxLength(5);

      addYokaigo4();
    }
    return yokaigo4;

  }

  /**
   * 要介護度4テキストコンテナを取得します。
   * @return 要介護度4テキストコンテナ
   */
  protected ACLabelContainer getYokaigo4Container(){
    if(yokaigo4Container==null){
      yokaigo4Container = new ACLabelContainer();
      yokaigo4Container.setFollowChildEnabled(true);
      yokaigo4Container.setVAlignment(VRLayout.CENTER);
      yokaigo4Container.add(getYokaigo4(), null);
    }
    return yokaigo4Container;
  }

  /**
   * 要介護度5テキストを取得します。
   * @return 要介護度5テキスト
   */
  public ACTextField getYokaigo5(){
    if(yokaigo5==null){

      yokaigo5 = new ACTextField();

      getYokaigo5Container().setText("要介護５");

      yokaigo5.setBindPath("25");

      yokaigo5.setColumns(4);

      yokaigo5.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo5.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo5.setIMEMode(InputSubset.LATIN);

      yokaigo5.setMaxLength(5);

      addYokaigo5();
    }
    return yokaigo5;

  }

  /**
   * 要介護度5テキストコンテナを取得します。
   * @return 要介護度5テキストコンテナ
   */
  protected ACLabelContainer getYokaigo5Container(){
    if(yokaigo5Container==null){
      yokaigo5Container = new ACLabelContainer();
      yokaigo5Container.setFollowChildEnabled(true);
      yokaigo5Container.setVAlignment(VRLayout.CENTER);
      yokaigo5Container.add(getYokaigo5(), null);
    }
    return yokaigo5Container;
  }

  /**
   * コンストラクタです。
   */
  public QO002Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

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
   * 入力領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getInsurerSetInfos(), VRLayout.NORTH);

    contents.add(getInsurerLimitPanel(), VRLayout.NORTH);

    contents.add(getInsurerLimitRateInfos(), VRLayout.NORTH);

  }

  /**
   * 保険者情報設定領域に内部項目を追加します。
   */
  protected void addInsurerSetInfos(){

    insurerSetInfos.add(getInsurerInfos(), VRLayout.FLOW_RETURN);

  }

  /**
   * 保険者情報入力領域に内部項目を追加します。
   */
  protected void addInsurerInfos(){

    insurerInfos.add(getInsurerIdContainer(), VRLayout.FLOW_INSETLINE);

    insurerInfos.add(getInsurerSelectButton(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerZipConteinar(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerTelConteinar(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerTypeContainer(), VRLayout.FLOW_INSETLINE);

    insurerInfos.add(getInsurerTypeInfomation(), VRLayout.FLOW_RETURN);

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addInsurerId(){

  }

  /**
   * 保険者選択に内部項目を追加します。
   */
  protected void addInsurerSelectButton(){

  }

  /**
   * 保険者名称に内部項目を追加します。
   */
  protected void addInsurerName(){

  }

  /**
   * 保険者郵便番号・コンテナに内部項目を追加します。
   */
  protected void addInsurerZipConteinar(){

    insurerZipConteinar.add(getInsurerZip1(), VRLayout.FLOW);

    insurerZipConteinar.add(getInsurerZipLabel(), VRLayout.FLOW);

    insurerZipConteinar.add(getInsurerZip2(), VRLayout.FLOW);

  }

  /**
   * 保険者郵便番号入力領域1に内部項目を追加します。
   */
  protected void addInsurerZip1(){

  }

  /**
   * 保険者郵便番号ラベルに内部項目を追加します。
   */
  protected void addInsurerZipLabel(){

  }

  /**
   * 保険者郵便番号入力領域2に内部項目を追加します。
   */
  protected void addInsurerZip2(){

  }

  /**
   * 保険者所在地に内部項目を追加します。
   */
  protected void addInsurerAddress(){

  }

  /**
   * 保険者電話番号・コンテナに内部項目を追加します。
   */
  protected void addInsurerTelConteinar(){

    insurerTelConteinar.add(getInsurerTel1(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTelLabel1(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTel2(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTelLabel2(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTel3(), VRLayout.FLOW);

  }

  /**
   * 保険者電話番号入力領域1に内部項目を追加します。
   */
  protected void addInsurerTel1(){

  }

  /**
   * 保険者電話番号ラベルに内部項目を追加します。
   */
  protected void addInsurerTelLabel1(){

  }

  /**
   * 保険者電話番号入力領域2に内部項目を追加します。
   */
  protected void addInsurerTel2(){

  }

  /**
   * 保険者電話番号ラベルに内部項目を追加します。
   */
  protected void addInsurerTelLabel2(){

  }

  /**
   * 保険者電話番号入力領域3に内部項目を追加します。
   */
  protected void addInsurerTel3(){

  }

  /**
   * 保険者区分に内部項目を追加します。
   */
  protected void addInsurerType(){

  }

  /**
   * 保険者区分モデルに内部項目を追加します。
   */
  protected void addInsurerTypeModel(){

    getInsurerTypeCare().setButtonIndex(1);

    getInsurerTypeModel().add(getInsurerTypeCare());

    getInsurerTypeMedical().setButtonIndex(2);

    getInsurerTypeModel().add(getInsurerTypeMedical());

  }

  /**
   * 介護に内部項目を追加します。
   */
  protected void addInsurerTypeCare(){

  }

  /**
   * 医療に内部項目を追加します。
   */
  protected void addInsurerTypeMedical(){

  }

  /**
   * 保険者区分説明に内部項目を追加します。
   */
  protected void addInsurerTypeInfomation(){

  }

  /**
   * パネルに内部項目を追加します。
   */
  protected void addInsurerLimitPanel(){

    insurerLimitPanel.add(getInsurerLimitRateEnableCheck(), VRLayout.FLOW_RETURN);

  }

  /**
   * 支給限度額有効切り替えチェックに内部項目を追加します。
   */
  protected void addInsurerLimitRateEnableCheck(){

  }

  /**
   * 保険者支給限度額情報領域に内部項目を追加します。
   */
  protected void addInsurerLimitRateInfos(){

    insurerLimitRateInfos.add(getInsurerLimitRateInfo(), VRLayout.CLIENT);

  }

  /**
   * 保険者支給限度額情報パネルに内部項目を追加します。
   */
  protected void addInsurerLimitRateInfo(){

    insurerLimitRateInfo.add(getInsurerLimitRatePanel(), VRLayout.NORTH);

    insurerLimitRateInfo.add(getValidPeriodPanel(), VRLayout.CLIENT);

  }

  /**
   * 支給限度額情報パネルに内部項目を追加します。
   */
  protected void addInsurerLimitRatePanel(){

    insurerLimitRatePanel.add(getInsurerLimitRateTable(), VRLayout.CLIENT);

  }

  /**
   * 支給限度額情報テーブルに内部項目を追加します。
   */
  protected void addInsurerLimitRateTable(){

  }

  /**
   * 支給限度額情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColumnModel(){

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum1());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum10());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum11());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum2());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum3());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum4());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum5());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum6());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum7());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum8());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum9());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum1(){

  }

  /**
   * 要支援1に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum10(){

  }

  /**
   * 要支援2に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum11(){

  }

  /**
   * 経過的要介護に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum2(){

  }

  /**
   * 要介護1に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum3(){

  }

  /**
   * 要介護2に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum4(){

  }

  /**
   * 要介護3に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum5(){

  }

  /**
   * 要介護4に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum6(){

  }

  /**
   * 要介護5に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum7(){

  }

  /**
   * 保険者情報有効期間(開始）に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum8(){

  }

  /**
   * 保険者情報有効期間(終了）に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum9(){

  }

  /**
   * 有効期間領域に内部項目を追加します。
   */
  protected void addValidPeriodPanel(){

    validPeriodPanel.add(getValidPeriodRight(), VRLayout.NORTH);

    validPeriodPanel.add(getValidPeriodLeft(), VRLayout.NORTH);

  }

  /**
   * 有効期間領域右に内部項目を追加します。
   */
  protected void addValidPeriodRight(){

    validPeriodRight.add(getInsurerLimitRateButtons(), VRLayout.EAST);
  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addInsurerLimitRateButtons(){

    insurerLimitRateButtons.add(getInsurerLimitRateDeleteButton(), VRLayout.EAST);
    insurerLimitRateButtons.add(getInsurerLimitRateEditButton(), VRLayout.EAST);
    insurerLimitRateButtons.add(getInsurerLimitRateInsertButton(), VRLayout.EAST);
    insurerLimitRateButtons.add(getInsurerLimitRateRegularButton(), VRLayout.EAST);
  }

  /**
   * 規定に内部項目を追加します。
   */
  protected void addInsurerLimitRateRegularButton(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addInsurerLimitRateInsertButton(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addInsurerLimitRateEditButton(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addInsurerLimitRateDeleteButton(){

  }

  /**
   * 有効期間領域左に内部項目を追加します。
   */
  protected void addValidPeriodLeft(){

    validPeriodLeft.add(getValidPeriodCpntena(), VRLayout.FLOW_RETURN);

    validPeriodLeft.add(getYosien1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosien2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosienContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    validPeriodLeft.add(getYokaigo1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo3Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo4Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo5Container(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 有効期間コンテナに内部項目を追加します。
   */
  protected void addValidPeriodCpntena(){

    validPeriodCpntena.add(getValidPeriodStart(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodLabel(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodEnd(), VRLayout.FLOW);

  }

  /**
   * 有効期間テキスト（開始）に内部項目を追加します。
   */
  protected void addValidPeriodStart(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addValidPeriodLabel(){

  }

  /**
   * 有効期間テキスト（終了）に内部項目を追加します。
   */
  protected void addValidPeriodEnd(){

  }

  /**
   * 要支援1テキストに内部項目を追加します。
   */
  protected void addYosien1(){

  }

  /**
   * 要支援2テキストに内部項目を追加します。
   */
  protected void addYosien2(){

  }

  /**
   * 経過的要介護テキストに内部項目を追加します。
   */
  protected void addYosien(){

  }

  /**
   * 要介護度1テキストに内部項目を追加します。
   */
  protected void addYokaigo1(){

  }

  /**
   * 要介護度2テキストに内部項目を追加します。
   */
  protected void addYokaigo2(){

  }

  /**
   * 要介護度3テキストに内部項目を追加します。
   */
  protected void addYokaigo3(){

  }

  /**
   * 要介護度4テキストに内部項目を追加します。
   */
  protected void addYokaigo4(){

  }

  /**
   * 要介護度5テキストに内部項目を追加します。
   */
  protected void addYokaigo5(){

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
      ACFrame.debugStart(new ACAffairInfo(QO002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO002Design getThis() {
    return this;
  }
}
