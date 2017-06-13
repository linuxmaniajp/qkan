
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
 * 作成日: 2016/09/29  日本コンピューター株式会社 小笠　貴志 新規作成
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

  private ACListModelAdapter insurerTypeModel;

  private ACRadioButtonItem insurerTypeCare;

  private ACRadioButtonItem insurerTypeMedical;

  private ACLabel insurerTypeInfomation;

  private JTabbedPane tabs;

  private ACPanel tabInsurerUnitPrice;

  private ACPanel insurerUnitPricePanel;

  private ACGroupBox insurerUnitPriceInfos;

  private ACPanel unitPriceSetInfos;

  private ACPanel unitPriceSetPanel;

  private ACComboBox unitPriceType;

  private ACLabelContainer unitPriceTypeContainer;

  private ACComboBoxModelAdapter unitPriceTypeModel;

  private ACPanel unitPriceServicePanel1;

  private ACComboBox unitPriceServiceA2;

  private ACLabelContainer unitPriceServiceA2Container;

  private ACComboBoxModelAdapter unitPriceServiceA2Model;

  private ACComboBox unitPriceServiceA3;

  private ACLabelContainer unitPriceServiceA3Container;

  private ACComboBoxModelAdapter unitPriceServiceA3Model;

  private ACComboBox unitPriceServiceA4;

  private ACLabelContainer unitPriceServiceA4Container;

  private ACComboBoxModelAdapter unitPriceServiceA4Model;

  private ACComboBox unitPriceServiceA9;

  private ACLabelContainer unitPriceServiceA9Container;

  private ACComboBoxModelAdapter unitPriceServiceA9Model;

  private ACComboBox unitPriceServiceAB;

  private ACLabelContainer unitPriceServiceABContainer;

  private ACComboBoxModelAdapter unitPriceServiceABModel;

  private ACComboBox unitPriceServiceAD;

  private ACLabelContainer unitPriceServiceADContainer;

  private ACComboBoxModelAdapter unitPriceServiceADModel;

  private ACPanel unitPriceServicePanel2;

  private ACComboBox unitPriceServiceA6;

  private ACLabelContainer unitPriceServiceA6Container;

  private ACComboBoxModelAdapter unitPriceServiceA6Model;

  private ACComboBox unitPriceServiceA7;

  private ACLabelContainer unitPriceServiceA7Container;

  private ACComboBoxModelAdapter unitPriceServiceA7Model;

  private ACComboBox unitPriceServiceA8;

  private ACLabelContainer unitPriceServiceA8Container;

  private ACComboBoxModelAdapter unitPriceServiceA8Model;

  private ACComboBox unitPriceServiceAA;

  private ACLabelContainer unitPriceServiceAAContainer;

  private ACComboBoxModelAdapter unitPriceServiceAAModel;

  private ACComboBox unitPriceServiceAC;

  private ACLabelContainer unitPriceServiceACContainer;

  private ACComboBoxModelAdapter unitPriceServiceACModel;

  private ACComboBox unitPriceServiceAE;

  private ACLabelContainer unitPriceServiceAEContainer;

  private ACComboBoxModelAdapter unitPriceServiceAEModel;

  private ACPanel unitPriceServicePanel3;

  private ACComboBox unitPriceServiceAF;

  private ACLabelContainer unitPriceServiceAFContainer;

  private ACComboBoxModelAdapter unitPriceServiceAFModel;

  private ACLabelContainer unitPriceValidPeriodContena;

  private QkanDateTextField unitPriceValidStart;

  private ACLabel unitPriceValidLabel;

  private QkanDateTextField unitPriceValidEnd;

  private ACPanel unitPriceButtonPanel;

  private ACPanel unitPriceButtons;

  private ACButton unitPriceRegularButton;

  private ACButton unitPriceInsertButton;

  private ACButton unitPriceEditButton;

  private ACButton unitPriceDeleteButton;

  private ACPanel unitPriceInfo;

  private ACTable unitPriceTable;

  private VRTableColumnModel unitPriceTableColumnModel;

  private ACTableColumn unitPriceTableColum1;

  private ACTableColumn unitPriceTableColum2;

  private ACTableColumn unitPriceTableColum3;

  private ACTableColumn unitPriceTableColum4;

  private ACPanel tabInsurerLimitRate;

  private ACPanel insurerLimitPanel;

  private ACIntegerCheckBox insurerLimitRateEnableCheck;

  private ACGroupBox insurerLimitRateInfos;

  private ACPanel insurerLimitRateInfo;

  private ACPanel validPeriodPanel;

  private ACPanel validPeriodLeft;

  private ACTextField jigyoTaishosha;

  private ACLabelContainer jigyoTaishoshaContainer;

  private ACTextField jigyoTaishoshaOver;

  private ACLabelContainer jigyoTaishoshaOverContainer;

  private ACLabel jigyoTaishoshaOverComment;

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

  private ACLabelContainer validPeriodCpntena;

  private QkanDateTextField validPeriodStart;

  private ACLabel validPeriodLabel;

  private QkanDateTextField validPeriodEnd;

  private ACPanel validPeriodRight;

  private ACPanel insurerLimitRateButtons;

  private ACButton insurerLimitRateRegularButton;

  private ACButton insurerLimitRateInsertButton;

  private ACButton insurerLimitRateEditButton;

  private ACButton insurerLimitRateDeleteButton;

  private ACPanel insurerLimitRatePanel;

  private ACTable insurerLimitRateTable;

  private VRTableColumnModel insurerLimitRateTableColumnModel;

  private ACTableColumn insurerLimitRateTableColum1;

  private ACTableColumn insurerLimitRateTableColum8;

  private ACTableColumn insurerLimitRateTableColum9;

  private ACTableColumn insurerLimitRateTableColum12;

  private ACTableColumn insurerLimitRateTableColum13;

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

      insurerType.setBindPath("INSURER_TYPE");

      insurerType.setVisible(false);

      insurerType.setModel(getInsurerTypeModel());

      addInsurerType();
    }
    return insurerType;

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

      insurerTypeInfomation.setVisible(false);

      insurerTypeInfomation.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addInsurerTypeInfomation();
    }
    return insurerTypeInfomation;

  }

  /**
   * Tabを取得します。
   * @return Tab
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * Tab「総合事業 単位数単価」を取得します。
   * @return Tab「総合事業 単位数単価」
   */
  public ACPanel getTabInsurerUnitPrice(){
    if(tabInsurerUnitPrice==null){

      tabInsurerUnitPrice = new ACPanel();

      addTabInsurerUnitPrice();
    }
    return tabInsurerUnitPrice;

  }

  /**
   * パネルを取得します。
   * @return パネル
   */
  public ACPanel getInsurerUnitPricePanel(){
    if(insurerUnitPricePanel==null){

      insurerUnitPricePanel = new ACPanel();

      addInsurerUnitPricePanel();
    }
    return insurerUnitPricePanel;

  }

  /**
   * 総合事業単位数単価情報領域を取得します。
   * @return 総合事業単位数単価情報領域
   */
  public ACGroupBox getInsurerUnitPriceInfos(){
    if(insurerUnitPriceInfos==null){

      insurerUnitPriceInfos = new ACGroupBox();

      insurerUnitPriceInfos.setText("総合事業単位数単価情報");

      insurerUnitPriceInfos.setFollowChildEnabled(true);

      insurerUnitPriceInfos.setVgap(5);

      addInsurerUnitPriceInfos();
    }
    return insurerUnitPriceInfos;

  }

  /**
   * 単位数単価設定領域を取得します。
   * @return 単位数単価設定領域
   */
  public ACPanel getUnitPriceSetInfos(){
    if(unitPriceSetInfos==null){

      unitPriceSetInfos = new ACPanel();

      unitPriceSetInfos.setAutoWrap(false);

      unitPriceSetInfos.setFollowChildEnabled(true);

      addUnitPriceSetInfos();
    }
    return unitPriceSetInfos;

  }

  /**
   * 単位数単価入力領域を取得します。
   * @return 単位数単価入力領域
   */
  public ACPanel getUnitPriceSetPanel(){
    if(unitPriceSetPanel==null){

      unitPriceSetPanel = new ACPanel();

      unitPriceSetPanel.setAutoWrap(true);

      unitPriceSetPanel.setFollowChildEnabled(true);

      unitPriceSetPanel.setHgap(0);

      unitPriceSetPanel.setLabelMargin(0);

      addUnitPriceSetPanel();
    }
    return unitPriceSetPanel;

  }

  /**
   * 地域区分コンボを取得します。
   * @return 地域区分コンボ
   */
  public ACComboBox getUnitPriceType(){
    if(unitPriceType==null){

      unitPriceType = new ACComboBox();

      getUnitPriceTypeContainer().setText("地域区分");

      unitPriceType.setBindPath("UNIT_PRICE_TYPE");

      unitPriceType.setEditable(false);

      unitPriceType.setModelBindPath("UNIT_PRICE_TYPE");

      unitPriceType.setRenderBindPath("CONTENT");

      unitPriceType.setModel(getUnitPriceTypeModel());

      addUnitPriceType();
    }
    return unitPriceType;

  }

  /**
   * 地域区分コンボコンテナを取得します。
   * @return 地域区分コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceTypeContainer(){
    if(unitPriceTypeContainer==null){
      unitPriceTypeContainer = new ACLabelContainer();
      unitPriceTypeContainer.setFollowChildEnabled(true);
      unitPriceTypeContainer.setVAlignment(VRLayout.CENTER);
      unitPriceTypeContainer.add(getUnitPriceType(), null);
    }
    return unitPriceTypeContainer;
  }

  /**
   * 地域区分コンボモデルを取得します。
   * @return 地域区分コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceTypeModel(){
    if(unitPriceTypeModel==null){
      unitPriceTypeModel = new ACComboBoxModelAdapter();
      addUnitPriceTypeModel();
    }
    return unitPriceTypeModel;
  }

  /**
   * 単位数単価パネル１を取得します。
   * @return 単位数単価パネル１
   */
  public ACPanel getUnitPriceServicePanel1(){
    if(unitPriceServicePanel1==null){

      unitPriceServicePanel1 = new ACPanel();

      addUnitPriceServicePanel1();
    }
    return unitPriceServicePanel1;

  }

  /**
   * A2コンボを取得します。
   * @return A2コンボ
   */
  public ACComboBox getUnitPriceServiceA2(){
    if(unitPriceServiceA2==null){

      unitPriceServiceA2 = new ACComboBox();

      getUnitPriceServiceA2Container().setText("A2:訪問型(独自)");

      unitPriceServiceA2.setBindPath("50211");

      unitPriceServiceA2.setEditable(false);

      unitPriceServiceA2.setModelBindPath("50211");

      unitPriceServiceA2.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA2.setBlankable(true);

      unitPriceServiceA2.setModel(getUnitPriceServiceA2Model());

      addUnitPriceServiceA2();
    }
    return unitPriceServiceA2;

  }

  /**
   * A2コンボコンテナを取得します。
   * @return A2コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceA2Container(){
    if(unitPriceServiceA2Container==null){
      unitPriceServiceA2Container = new ACLabelContainer();
      unitPriceServiceA2Container.setFollowChildEnabled(true);
      unitPriceServiceA2Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA2Container.add(getUnitPriceServiceA2(), null);
    }
    return unitPriceServiceA2Container;
  }

  /**
   * A2コンボモデルを取得します。
   * @return A2コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA2Model(){
    if(unitPriceServiceA2Model==null){
      unitPriceServiceA2Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA2Model();
    }
    return unitPriceServiceA2Model;
  }

  /**
   * A3コンボを取得します。
   * @return A3コンボ
   */
  public ACComboBox getUnitPriceServiceA3(){
    if(unitPriceServiceA3==null){

      unitPriceServiceA3 = new ACComboBox();

      getUnitPriceServiceA3Container().setText("A3:訪問型(定率)");

      unitPriceServiceA3.setBindPath("50311");

      unitPriceServiceA3.setEditable(false);

      unitPriceServiceA3.setModelBindPath("50311");

      unitPriceServiceA3.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA3.setBlankable(true);

      unitPriceServiceA3.setModel(getUnitPriceServiceA3Model());

      addUnitPriceServiceA3();
    }
    return unitPriceServiceA3;

  }

  /**
   * A3コンボコンテナを取得します。
   * @return A3コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceA3Container(){
    if(unitPriceServiceA3Container==null){
      unitPriceServiceA3Container = new ACLabelContainer();
      unitPriceServiceA3Container.setFollowChildEnabled(true);
      unitPriceServiceA3Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA3Container.add(getUnitPriceServiceA3(), null);
    }
    return unitPriceServiceA3Container;
  }

  /**
   * A3コンボモデルを取得します。
   * @return A3コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA3Model(){
    if(unitPriceServiceA3Model==null){
      unitPriceServiceA3Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA3Model();
    }
    return unitPriceServiceA3Model;
  }

  /**
   * A4コンボを取得します。
   * @return A4コンボ
   */
  public ACComboBox getUnitPriceServiceA4(){
    if(unitPriceServiceA4==null){

      unitPriceServiceA4 = new ACComboBox();

      getUnitPriceServiceA4Container().setText("A4:訪問型(定額)");

      unitPriceServiceA4.setBindPath("50411");

      unitPriceServiceA4.setEditable(false);

      unitPriceServiceA4.setModelBindPath("50411");

      unitPriceServiceA4.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA4.setBlankable(true);

      unitPriceServiceA4.setModel(getUnitPriceServiceA4Model());

      addUnitPriceServiceA4();
    }
    return unitPriceServiceA4;

  }

  /**
   * A4コンボコンテナを取得します。
   * @return A4コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceA4Container(){
    if(unitPriceServiceA4Container==null){
      unitPriceServiceA4Container = new ACLabelContainer();
      unitPriceServiceA4Container.setFollowChildEnabled(true);
      unitPriceServiceA4Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA4Container.add(getUnitPriceServiceA4(), null);
    }
    return unitPriceServiceA4Container;
  }

  /**
   * A4コンボモデルを取得します。
   * @return A4コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA4Model(){
    if(unitPriceServiceA4Model==null){
      unitPriceServiceA4Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA4Model();
    }
    return unitPriceServiceA4Model;
  }

  /**
   * A9コンボを取得します。
   * @return A9コンボ
   */
  public ACComboBox getUnitPriceServiceA9(){
    if(unitPriceServiceA9==null){

      unitPriceServiceA9 = new ACComboBox();

      getUnitPriceServiceA9Container().setText("A9:生活配食(定率)");

      unitPriceServiceA9.setBindPath("50911");

      unitPriceServiceA9.setEditable(false);

      unitPriceServiceA9.setModelBindPath("50911");

      unitPriceServiceA9.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA9.setBlankable(true);

      unitPriceServiceA9.setModel(getUnitPriceServiceA9Model());

      addUnitPriceServiceA9();
    }
    return unitPriceServiceA9;

  }

  /**
   * A9コンボコンテナを取得します。
   * @return A9コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceA9Container(){
    if(unitPriceServiceA9Container==null){
      unitPriceServiceA9Container = new ACLabelContainer();
      unitPriceServiceA9Container.setFollowChildEnabled(true);
      unitPriceServiceA9Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA9Container.add(getUnitPriceServiceA9(), null);
    }
    return unitPriceServiceA9Container;
  }

  /**
   * A9コンボモデルを取得します。
   * @return A9コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA9Model(){
    if(unitPriceServiceA9Model==null){
      unitPriceServiceA9Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA9Model();
    }
    return unitPriceServiceA9Model;
  }

  /**
   * ABコンボを取得します。
   * @return ABコンボ
   */
  public ACComboBox getUnitPriceServiceAB(){
    if(unitPriceServiceAB==null){

      unitPriceServiceAB = new ACComboBox();

      getUnitPriceServiceABContainer().setText("AB:生活見守(定率)");

      unitPriceServiceAB.setBindPath("51111");

      unitPriceServiceAB.setEditable(false);

      unitPriceServiceAB.setModelBindPath("51111");

      unitPriceServiceAB.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAB.setBlankable(true);

      unitPriceServiceAB.setModel(getUnitPriceServiceABModel());

      addUnitPriceServiceAB();
    }
    return unitPriceServiceAB;

  }

  /**
   * ABコンボコンテナを取得します。
   * @return ABコンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceABContainer(){
    if(unitPriceServiceABContainer==null){
      unitPriceServiceABContainer = new ACLabelContainer();
      unitPriceServiceABContainer.setFollowChildEnabled(true);
      unitPriceServiceABContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceABContainer.add(getUnitPriceServiceAB(), null);
    }
    return unitPriceServiceABContainer;
  }

  /**
   * ABコンボモデルを取得します。
   * @return ABコンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceABModel(){
    if(unitPriceServiceABModel==null){
      unitPriceServiceABModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceABModel();
    }
    return unitPriceServiceABModel;
  }

  /**
   * ADコンボを取得します。
   * @return ADコンボ
   */
  public ACComboBox getUnitPriceServiceAD(){
    if(unitPriceServiceAD==null){

      unitPriceServiceAD = new ACComboBox();

      getUnitPriceServiceADContainer().setText("AD:生活他(定率)");

      unitPriceServiceAD.setBindPath("51311");

      unitPriceServiceAD.setEditable(false);

      unitPriceServiceAD.setModelBindPath("51311");

      unitPriceServiceAD.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAD.setBlankable(true);

      unitPriceServiceAD.setModel(getUnitPriceServiceADModel());

      addUnitPriceServiceAD();
    }
    return unitPriceServiceAD;

  }

  /**
   * ADコンボコンテナを取得します。
   * @return ADコンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceADContainer(){
    if(unitPriceServiceADContainer==null){
      unitPriceServiceADContainer = new ACLabelContainer();
      unitPriceServiceADContainer.setFollowChildEnabled(true);
      unitPriceServiceADContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceADContainer.add(getUnitPriceServiceAD(), null);
    }
    return unitPriceServiceADContainer;
  }

  /**
   * ADコンボモデルを取得します。
   * @return ADコンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceADModel(){
    if(unitPriceServiceADModel==null){
      unitPriceServiceADModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceADModel();
    }
    return unitPriceServiceADModel;
  }

  /**
   * 単位数単価パネル２を取得します。
   * @return 単位数単価パネル２
   */
  public ACPanel getUnitPriceServicePanel2(){
    if(unitPriceServicePanel2==null){

      unitPriceServicePanel2 = new ACPanel();

      addUnitPriceServicePanel2();
    }
    return unitPriceServicePanel2;

  }

  /**
   * A6コンボを取得します。
   * @return A6コンボ
   */
  public ACComboBox getUnitPriceServiceA6(){
    if(unitPriceServiceA6==null){

      unitPriceServiceA6 = new ACComboBox();

      getUnitPriceServiceA6Container().setText("A6:通所型(独自)");

      unitPriceServiceA6.setBindPath("50611");

      unitPriceServiceA6.setEditable(false);

      unitPriceServiceA6.setModelBindPath("50611");

      unitPriceServiceA6.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA6.setBlankable(true);

      unitPriceServiceA6.setModel(getUnitPriceServiceA6Model());

      addUnitPriceServiceA6();
    }
    return unitPriceServiceA6;

  }

  /**
   * A6コンボコンテナを取得します。
   * @return A6コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceA6Container(){
    if(unitPriceServiceA6Container==null){
      unitPriceServiceA6Container = new ACLabelContainer();
      unitPriceServiceA6Container.setFollowChildEnabled(true);
      unitPriceServiceA6Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA6Container.add(getUnitPriceServiceA6(), null);
    }
    return unitPriceServiceA6Container;
  }

  /**
   * A6コンボモデルを取得します。
   * @return A6コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA6Model(){
    if(unitPriceServiceA6Model==null){
      unitPriceServiceA6Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA6Model();
    }
    return unitPriceServiceA6Model;
  }

  /**
   * A7コンボを取得します。
   * @return A7コンボ
   */
  public ACComboBox getUnitPriceServiceA7(){
    if(unitPriceServiceA7==null){

      unitPriceServiceA7 = new ACComboBox();

      getUnitPriceServiceA7Container().setText("A7:通所型(定率)");

      unitPriceServiceA7.setBindPath("50711");

      unitPriceServiceA7.setEditable(false);

      unitPriceServiceA7.setModelBindPath("50711");

      unitPriceServiceA7.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA7.setBlankable(true);

      unitPriceServiceA7.setModel(getUnitPriceServiceA7Model());

      addUnitPriceServiceA7();
    }
    return unitPriceServiceA7;

  }

  /**
   * A7コンボコンテナを取得します。
   * @return A7コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceA7Container(){
    if(unitPriceServiceA7Container==null){
      unitPriceServiceA7Container = new ACLabelContainer();
      unitPriceServiceA7Container.setFollowChildEnabled(true);
      unitPriceServiceA7Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA7Container.add(getUnitPriceServiceA7(), null);
    }
    return unitPriceServiceA7Container;
  }

  /**
   * A7コンボモデルを取得します。
   * @return A7コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA7Model(){
    if(unitPriceServiceA7Model==null){
      unitPriceServiceA7Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA7Model();
    }
    return unitPriceServiceA7Model;
  }

  /**
   * A8コンボを取得します。
   * @return A8コンボ
   */
  public ACComboBox getUnitPriceServiceA8(){
    if(unitPriceServiceA8==null){

      unitPriceServiceA8 = new ACComboBox();

      getUnitPriceServiceA8Container().setText("A8:通所型(定額)");

      unitPriceServiceA8.setBindPath("50811");

      unitPriceServiceA8.setEditable(false);

      unitPriceServiceA8.setModelBindPath("50811");

      unitPriceServiceA8.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA8.setBlankable(true);

      unitPriceServiceA8.setModel(getUnitPriceServiceA8Model());

      addUnitPriceServiceA8();
    }
    return unitPriceServiceA8;

  }

  /**
   * A8コンボコンテナを取得します。
   * @return A8コンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceA8Container(){
    if(unitPriceServiceA8Container==null){
      unitPriceServiceA8Container = new ACLabelContainer();
      unitPriceServiceA8Container.setFollowChildEnabled(true);
      unitPriceServiceA8Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA8Container.add(getUnitPriceServiceA8(), null);
    }
    return unitPriceServiceA8Container;
  }

  /**
   * A8コンボモデルを取得します。
   * @return A8コンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA8Model(){
    if(unitPriceServiceA8Model==null){
      unitPriceServiceA8Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA8Model();
    }
    return unitPriceServiceA8Model;
  }

  /**
   * AAコンボを取得します。
   * @return AAコンボ
   */
  public ACComboBox getUnitPriceServiceAA(){
    if(unitPriceServiceAA==null){

      unitPriceServiceAA = new ACComboBox();

      getUnitPriceServiceAAContainer().setText("AA:生活配食(定額)");

      unitPriceServiceAA.setBindPath("51011");

      unitPriceServiceAA.setEditable(false);

      unitPriceServiceAA.setModelBindPath("51011");

      unitPriceServiceAA.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAA.setBlankable(true);

      unitPriceServiceAA.setModel(getUnitPriceServiceAAModel());

      addUnitPriceServiceAA();
    }
    return unitPriceServiceAA;

  }

  /**
   * AAコンボコンテナを取得します。
   * @return AAコンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceAAContainer(){
    if(unitPriceServiceAAContainer==null){
      unitPriceServiceAAContainer = new ACLabelContainer();
      unitPriceServiceAAContainer.setFollowChildEnabled(true);
      unitPriceServiceAAContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceAAContainer.add(getUnitPriceServiceAA(), null);
    }
    return unitPriceServiceAAContainer;
  }

  /**
   * AAコンボモデルを取得します。
   * @return AAコンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceAAModel(){
    if(unitPriceServiceAAModel==null){
      unitPriceServiceAAModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceAAModel();
    }
    return unitPriceServiceAAModel;
  }

  /**
   * ACコンボを取得します。
   * @return ACコンボ
   */
  public ACComboBox getUnitPriceServiceAC(){
    if(unitPriceServiceAC==null){

      unitPriceServiceAC = new ACComboBox();

      getUnitPriceServiceACContainer().setText("AC:生活見守(定額)");

      unitPriceServiceAC.setBindPath("51211");

      unitPriceServiceAC.setEditable(false);

      unitPriceServiceAC.setModelBindPath("51211");

      unitPriceServiceAC.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAC.setBlankable(true);

      unitPriceServiceAC.setModel(getUnitPriceServiceACModel());

      addUnitPriceServiceAC();
    }
    return unitPriceServiceAC;

  }

  /**
   * ACコンボコンテナを取得します。
   * @return ACコンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceACContainer(){
    if(unitPriceServiceACContainer==null){
      unitPriceServiceACContainer = new ACLabelContainer();
      unitPriceServiceACContainer.setFollowChildEnabled(true);
      unitPriceServiceACContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceACContainer.add(getUnitPriceServiceAC(), null);
    }
    return unitPriceServiceACContainer;
  }

  /**
   * ACコンボモデルを取得します。
   * @return ACコンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceACModel(){
    if(unitPriceServiceACModel==null){
      unitPriceServiceACModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceACModel();
    }
    return unitPriceServiceACModel;
  }

  /**
   * AEコンボを取得します。
   * @return AEコンボ
   */
  public ACComboBox getUnitPriceServiceAE(){
    if(unitPriceServiceAE==null){

      unitPriceServiceAE = new ACComboBox();

      getUnitPriceServiceAEContainer().setText("AE:生活他(定額)");

      unitPriceServiceAE.setBindPath("51411");

      unitPriceServiceAE.setEditable(false);

      unitPriceServiceAE.setModelBindPath("51411");

      unitPriceServiceAE.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAE.setBlankable(true);

      unitPriceServiceAE.setModel(getUnitPriceServiceAEModel());

      addUnitPriceServiceAE();
    }
    return unitPriceServiceAE;

  }

  /**
   * AEコンボコンテナを取得します。
   * @return AEコンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceAEContainer(){
    if(unitPriceServiceAEContainer==null){
      unitPriceServiceAEContainer = new ACLabelContainer();
      unitPriceServiceAEContainer.setFollowChildEnabled(true);
      unitPriceServiceAEContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceAEContainer.add(getUnitPriceServiceAE(), null);
    }
    return unitPriceServiceAEContainer;
  }

  /**
   * AEコンボモデルを取得します。
   * @return AEコンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceAEModel(){
    if(unitPriceServiceAEModel==null){
      unitPriceServiceAEModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceAEModel();
    }
    return unitPriceServiceAEModel;
  }

  /**
   * 単位数単価パネル３を取得します。
   * @return 単位数単価パネル３
   */
  public ACPanel getUnitPriceServicePanel3(){
    if(unitPriceServicePanel3==null){

      unitPriceServicePanel3 = new ACPanel();

      addUnitPriceServicePanel3();
    }
    return unitPriceServicePanel3;

  }

  /**
   * AFコンボを取得します。
   * @return AFコンボ
   */
  public ACComboBox getUnitPriceServiceAF(){
    if(unitPriceServiceAF==null){

      unitPriceServiceAF = new ACComboBox();

      getUnitPriceServiceAFContainer().setText("AF:予防ケアマネ");

      unitPriceServiceAF.setBindPath("51511");

      unitPriceServiceAF.setEditable(false);

      unitPriceServiceAF.setModelBindPath("51511");

      unitPriceServiceAF.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAF.setBlankable(true);

      unitPriceServiceAF.setModel(getUnitPriceServiceAFModel());

      addUnitPriceServiceAF();
    }
    return unitPriceServiceAF;

  }

  /**
   * AFコンボコンテナを取得します。
   * @return AFコンボコンテナ
   */
  protected ACLabelContainer getUnitPriceServiceAFContainer(){
    if(unitPriceServiceAFContainer==null){
      unitPriceServiceAFContainer = new ACLabelContainer();
      unitPriceServiceAFContainer.setFollowChildEnabled(true);
      unitPriceServiceAFContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceAFContainer.add(getUnitPriceServiceAF(), null);
    }
    return unitPriceServiceAFContainer;
  }

  /**
   * AFコンボモデルを取得します。
   * @return AFコンボモデル
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceAFModel(){
    if(unitPriceServiceAFModel==null){
      unitPriceServiceAFModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceAFModel();
    }
    return unitPriceServiceAFModel;
  }

  /**
   * 有効期間コンテナを取得します。
   * @return 有効期間コンテナ
   */
  public ACLabelContainer getUnitPriceValidPeriodContena(){
    if(unitPriceValidPeriodContena==null){

      unitPriceValidPeriodContena = new ACLabelContainer();

      unitPriceValidPeriodContena.setText("有効期間");

      unitPriceValidPeriodContena.setFollowChildEnabled(true);

      addUnitPriceValidPeriodContena();
    }
    return unitPriceValidPeriodContena;

  }

  /**
   * 有効期間テキスト(開始)を取得します。
   * @return 有効期間テキスト(開始)
   */
  public QkanDateTextField getUnitPriceValidStart(){
    if(unitPriceValidStart==null){

      unitPriceValidStart = new QkanDateTextField();

      unitPriceValidStart.setBindPath("UNIT_PRICE_VALID_START");

      addUnitPriceValidStart();
    }
    return unitPriceValidStart;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getUnitPriceValidLabel(){
    if(unitPriceValidLabel==null){

      unitPriceValidLabel = new ACLabel();

      unitPriceValidLabel.setText("から");

      addUnitPriceValidLabel();
    }
    return unitPriceValidLabel;

  }

  /**
   * 有効期間テキスト(終了)を取得します。
   * @return 有効期間テキスト(終了)
   */
  public QkanDateTextField getUnitPriceValidEnd(){
    if(unitPriceValidEnd==null){

      unitPriceValidEnd = new QkanDateTextField();

      unitPriceValidEnd.setBindPath("UNIT_PRICE_VALID_END");

      addUnitPriceValidEnd();
    }
    return unitPriceValidEnd;

  }

  /**
   * 有効期間領域右を取得します。
   * @return 有効期間領域右
   */
  public ACPanel getUnitPriceButtonPanel(){
    if(unitPriceButtonPanel==null){

      unitPriceButtonPanel = new ACPanel();

      unitPriceButtonPanel.setFollowChildEnabled(true);

      addUnitPriceButtonPanel();
    }
    return unitPriceButtonPanel;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getUnitPriceButtons(){
    if(unitPriceButtons==null){

      unitPriceButtons = new ACPanel();

      unitPriceButtons.setFollowChildEnabled(true);

      addUnitPriceButtons();
    }
    return unitPriceButtons;

  }

  /**
   * 規定を取得します。
   * @return 規定
   */
  public ACButton getUnitPriceRegularButton(){
    if(unitPriceRegularButton==null){

      unitPriceRegularButton = new ACButton();

      unitPriceRegularButton.setText("規定");

      unitPriceRegularButton.setToolTipText("厚生労働省規定の総合事業単位数単価を設定します。");

      unitPriceRegularButton.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addUnitPriceRegularButton();
    }
    return unitPriceRegularButton;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getUnitPriceInsertButton(){
    if(unitPriceInsertButton==null){

      unitPriceInsertButton = new ACButton();

      unitPriceInsertButton.setText("追加");

      unitPriceInsertButton.setToolTipText("保険者の総合事業単位数単価情報を追加します。");

      unitPriceInsertButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addUnitPriceInsertButton();
    }
    return unitPriceInsertButton;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getUnitPriceEditButton(){
    if(unitPriceEditButton==null){

      unitPriceEditButton = new ACButton();

      unitPriceEditButton.setText("書替");

      unitPriceEditButton.setToolTipText("選択中の総合事業単位数単価情報を編集します。");

      unitPriceEditButton.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addUnitPriceEditButton();
    }
    return unitPriceEditButton;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getUnitPriceDeleteButton(){
    if(unitPriceDeleteButton==null){

      unitPriceDeleteButton = new ACButton();

      unitPriceDeleteButton.setText("削除");

      unitPriceDeleteButton.setToolTipText("選択中の総合事業単位数単価情報を削除します。");

      unitPriceDeleteButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addUnitPriceDeleteButton();
    }
    return unitPriceDeleteButton;

  }

  /**
   * 総合事業単位数単価情報パネルを取得します。
   * @return 総合事業単位数単価情報パネル
   */
  public ACPanel getUnitPriceInfo(){
    if(unitPriceInfo==null){

      unitPriceInfo = new ACPanel();

      addUnitPriceInfo();
    }
    return unitPriceInfo;

  }

  /**
   * 総合事業単位数単価情報テーブルを取得します。
   * @return 総合事業単位数単価情報テーブル
   */
  public ACTable getUnitPriceTable(){
    if(unitPriceTable==null){

      unitPriceTable = new ACTable();

      unitPriceTable.setColumnModel(getUnitPriceTableColumnModel());

      addUnitPriceTable();
    }
    return unitPriceTable;

  }

  /**
   * 総合事業単位数単価情報テーブルカラムモデルを取得します。
   * @return 総合事業単位数単価情報テーブルカラムモデル
   */
  protected VRTableColumnModel getUnitPriceTableColumnModel(){
    if(unitPriceTableColumnModel==null){
      unitPriceTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addUnitPriceTableColumnModel();
    }
    return unitPriceTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getUnitPriceTableColum1(){
    if(unitPriceTableColum1==null){

      unitPriceTableColum1 = new ACTableColumn();

      unitPriceTableColum1.setHeaderValue("No.");

      unitPriceTableColum1.setColumns(3);

      unitPriceTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      unitPriceTableColum1.setSortable(false);

      addUnitPriceTableColum1();
    }
    return unitPriceTableColum1;

  }

  /**
   * 総合事業単位数単価情報有効期間(開始)を取得します。
   * @return 総合事業単位数単価情報有効期間(開始)
   */
  public ACTableColumn getUnitPriceTableColum2(){
    if(unitPriceTableColum2==null){

      unitPriceTableColum2 = new ACTableColumn(0);

      unitPriceTableColum2.setHeaderValue("有効期間(開始)");

      unitPriceTableColum2.setColumns(12);

      unitPriceTableColum2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addUnitPriceTableColum2();
    }
    return unitPriceTableColum2;

  }

  /**
   * 総合事業単位数単価情報有効期間(終了)を取得します。
   * @return 総合事業単位数単価情報有効期間(終了)
   */
  public ACTableColumn getUnitPriceTableColum3(){
    if(unitPriceTableColum3==null){

      unitPriceTableColum3 = new ACTableColumn(1);

      unitPriceTableColum3.setHeaderValue("有効期間(終了)");

      unitPriceTableColum3.setColumns(12);

      unitPriceTableColum3.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addUnitPriceTableColum3();
    }
    return unitPriceTableColum3;

  }

  /**
   * 地域区分を取得します。
   * @return 地域区分
   */
  public ACTableColumn getUnitPriceTableColum4(){
    if(unitPriceTableColum4==null){

      unitPriceTableColum4 = new ACTableColumn(2);

      unitPriceTableColum4.setHeaderValue("地域区分");

      unitPriceTableColum4.setColumns(12);

      addUnitPriceTableColum4();
    }
    return unitPriceTableColum4;

  }

  /**
   * Tab「総合事業 限度額」を取得します。
   * @return Tab「総合事業 限度額」
   */
  public ACPanel getTabInsurerLimitRate(){
    if(tabInsurerLimitRate==null){

      tabInsurerLimitRate = new ACPanel();

      addTabInsurerLimitRate();
    }
    return tabInsurerLimitRate;

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

      insurerLimitRateInfos.setText("総合事業限度額情報");

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
   * 事業対象者テキストを取得します。
   * @return 事業対象者テキスト
   */
  public ACTextField getJigyoTaishosha(){
    if(jigyoTaishosha==null){

      jigyoTaishosha = new ACTextField();

      getJigyoTaishoshaContainer().setText("事業対象者");

      jigyoTaishosha.setBindPath("6");

      jigyoTaishosha.setColumns(4);

      jigyoTaishosha.setCharType(VRCharType.ONLY_DIGIT);

      jigyoTaishosha.setHorizontalAlignment(SwingConstants.RIGHT);

      jigyoTaishosha.setIMEMode(InputSubset.LATIN);

      jigyoTaishosha.setMaxLength(5);

      addJigyoTaishosha();
    }
    return jigyoTaishosha;

  }

  /**
   * 事業対象者テキストコンテナを取得します。
   * @return 事業対象者テキストコンテナ
   */
  protected ACLabelContainer getJigyoTaishoshaContainer(){
    if(jigyoTaishoshaContainer==null){
      jigyoTaishoshaContainer = new ACLabelContainer();
      jigyoTaishoshaContainer.setFollowChildEnabled(true);
      jigyoTaishoshaContainer.setVAlignment(VRLayout.CENTER);
      jigyoTaishoshaContainer.add(getJigyoTaishosha(), null);
    }
    return jigyoTaishoshaContainer;
  }

  /**
   * 事業対象者(要支援１超)テキストを取得します。
   * @return 事業対象者(要支援１超)テキスト
   */
  public ACTextField getJigyoTaishoshaOver(){
    if(jigyoTaishoshaOver==null){

      jigyoTaishoshaOver = new ACTextField();

      getJigyoTaishoshaOverContainer().setText("事業対象者(要支援１超)");

      jigyoTaishoshaOver.setBindPath("61");

      jigyoTaishoshaOver.setColumns(4);

      jigyoTaishoshaOver.setCharType(VRCharType.ONLY_DIGIT);

      jigyoTaishoshaOver.setHorizontalAlignment(SwingConstants.RIGHT);

      jigyoTaishoshaOver.setIMEMode(InputSubset.LATIN);

      jigyoTaishoshaOver.setMaxLength(5);

      addJigyoTaishoshaOver();
    }
    return jigyoTaishoshaOver;

  }

  /**
   * 事業対象者(要支援１超)テキストコンテナを取得します。
   * @return 事業対象者(要支援１超)テキストコンテナ
   */
  protected ACLabelContainer getJigyoTaishoshaOverContainer(){
    if(jigyoTaishoshaOverContainer==null){
      jigyoTaishoshaOverContainer = new ACLabelContainer();
      jigyoTaishoshaOverContainer.setFollowChildEnabled(true);
      jigyoTaishoshaOverContainer.setVAlignment(VRLayout.CENTER);
      jigyoTaishoshaOverContainer.add(getJigyoTaishoshaOver(), null);
    }
    return jigyoTaishoshaOverContainer;
  }

  /**
   * 事業対象者コメント・ラベルを取得します。
   * @return 事業対象者コメント・ラベル
   */
  public ACLabel getJigyoTaishoshaOverComment(){
    if(jigyoTaishoshaOverComment==null){

      jigyoTaishoshaOverComment = new ACLabel();

      jigyoTaishoshaOverComment.setText("市町村にて事業対象者が要支援１の額を超えてサービスを利用" + ACConstants.LINE_SEPARATOR + "する場合の限度額が定められている場合は設定してください。");

      addJigyoTaishoshaOverComment();
    }
    return jigyoTaishoshaOverComment;

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
   * 有効期間テキスト(開始)を取得します。
   * @return 有効期間テキスト(開始)
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
   * 有効期間テキスト(終了)を取得します。
   * @return 有効期間テキスト(終了)
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

      insurerLimitRateDeleteButton.setToolTipText("選択中の支給限度額情報を削除します。");

      insurerLimitRateDeleteButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addInsurerLimitRateDeleteButton();
    }
    return insurerLimitRateDeleteButton;

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
   * 保険者情報有効期間(開始)を取得します。
   * @return 保険者情報有効期間(開始)
   */
  public ACTableColumn getInsurerLimitRateTableColum8(){
    if(insurerLimitRateTableColum8==null){

      insurerLimitRateTableColum8 = new ACTableColumn(0);

      insurerLimitRateTableColum8.setHeaderValue("有効期間(開始)");

      insurerLimitRateTableColum8.setColumns(12);

      insurerLimitRateTableColum8.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addInsurerLimitRateTableColum8();
    }
    return insurerLimitRateTableColum8;

  }

  /**
   * 保険者情報有効期間(終了)を取得します。
   * @return 保険者情報有効期間(終了)
   */
  public ACTableColumn getInsurerLimitRateTableColum9(){
    if(insurerLimitRateTableColum9==null){

      insurerLimitRateTableColum9 = new ACTableColumn(1);

      insurerLimitRateTableColum9.setHeaderValue("有効期間(終了)");

      insurerLimitRateTableColum9.setColumns(12);

      insurerLimitRateTableColum9.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addInsurerLimitRateTableColum9();
    }
    return insurerLimitRateTableColum9;

  }

  /**
   * 事業対象者を取得します。
   * @return 事業対象者
   */
  public ACTableColumn getInsurerLimitRateTableColum12(){
    if(insurerLimitRateTableColum12==null){

      insurerLimitRateTableColum12 = new ACTableColumn(2);

      insurerLimitRateTableColum12.setHeaderValue("事業対象者");

      insurerLimitRateTableColum12.setColumns(7);

      addInsurerLimitRateTableColum12();
    }
    return insurerLimitRateTableColum12;

  }

  /**
   * 事業対象者(要支援１超)を取得します。
   * @return 事業対象者(要支援１超)
   */
  public ACTableColumn getInsurerLimitRateTableColum13(){
    if(insurerLimitRateTableColum13==null){

      insurerLimitRateTableColum13 = new ACTableColumn(3);

      insurerLimitRateTableColum13.setHeaderValue("事業対象者(要支援１超)");

      insurerLimitRateTableColum13.setColumns(12);

      addInsurerLimitRateTableColum13();
    }
    return insurerLimitRateTableColum13;

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

    contents.add(getTabs(), VRLayout.CLIENT);

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

    insurerInfos.add(getInsurerType(), VRLayout.FLOW_INSETLINE);

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
   * Tabに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("総合事業 単位数単価", getTabInsurerUnitPrice());

    tabs.addTab("総合事業 限度額", getTabInsurerLimitRate());

  }

  /**
   * Tab「総合事業 単位数単価」に内部項目を追加します。
   */
  protected void addTabInsurerUnitPrice(){

    tabInsurerUnitPrice.add(getInsurerUnitPricePanel(), VRLayout.CLIENT);

  }

  /**
   * パネルに内部項目を追加します。
   */
  protected void addInsurerUnitPricePanel(){

    insurerUnitPricePanel.add(getInsurerUnitPriceInfos(), VRLayout.CLIENT);

  }

  /**
   * 総合事業単位数単価情報領域に内部項目を追加します。
   */
  protected void addInsurerUnitPriceInfos(){

    insurerUnitPriceInfos.add(getUnitPriceSetInfos(), VRLayout.NORTH);

    insurerUnitPriceInfos.add(getUnitPriceInfo(), VRLayout.CLIENT);

  }

  /**
   * 単位数単価設定領域に内部項目を追加します。
   */
  protected void addUnitPriceSetInfos(){

    unitPriceSetInfos.add(getUnitPriceSetPanel(), VRLayout.NORTH);

    unitPriceSetInfos.add(getUnitPriceButtonPanel(), VRLayout.NORTH);

  }

  /**
   * 単位数単価入力領域に内部項目を追加します。
   */
  protected void addUnitPriceSetPanel(){

    unitPriceSetPanel.add(getUnitPriceTypeContainer(), VRLayout.FLOW_RETURN);

    unitPriceSetPanel.add(getUnitPriceServicePanel1(), VRLayout.FLOW);

    unitPriceSetPanel.add(getUnitPriceServicePanel2(), VRLayout.FLOW);

    unitPriceSetPanel.add(getUnitPriceServicePanel3(), VRLayout.FLOW_RETURN);

    unitPriceSetPanel.add(getUnitPriceValidPeriodContena(), VRLayout.FLOW_RETURN);

  }

  /**
   * 地域区分コンボに内部項目を追加します。
   */
  protected void addUnitPriceType(){

  }

  /**
   * 地域区分コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceTypeModel(){

  }

  /**
   * 単位数単価パネル１に内部項目を追加します。
   */
  protected void addUnitPriceServicePanel1(){

    unitPriceServicePanel1.add(getUnitPriceServiceA2Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceA3Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceA4Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceA9Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceABContainer(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceADContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * A2コンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceA2(){

  }

  /**
   * A2コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceA2Model(){

  }

  /**
   * A3コンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceA3(){

  }

  /**
   * A3コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceA3Model(){

  }

  /**
   * A4コンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceA4(){

  }

  /**
   * A4コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceA4Model(){

  }

  /**
   * A9コンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceA9(){

  }

  /**
   * A9コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceA9Model(){

  }

  /**
   * ABコンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceAB(){

  }

  /**
   * ABコンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceABModel(){

  }

  /**
   * ADコンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceAD(){

  }

  /**
   * ADコンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceADModel(){

  }

  /**
   * 単位数単価パネル２に内部項目を追加します。
   */
  protected void addUnitPriceServicePanel2(){

    unitPriceServicePanel2.add(getUnitPriceServiceA6Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceA7Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceA8Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceAAContainer(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceACContainer(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceAEContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * A6コンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceA6(){

  }

  /**
   * A6コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceA6Model(){

  }

  /**
   * A7コンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceA7(){

  }

  /**
   * A7コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceA7Model(){

  }

  /**
   * A8コンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceA8(){

  }

  /**
   * A8コンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceA8Model(){

  }

  /**
   * AAコンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceAA(){

  }

  /**
   * AAコンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceAAModel(){

  }

  /**
   * ACコンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceAC(){

  }

  /**
   * ACコンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceACModel(){

  }

  /**
   * AEコンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceAE(){

  }

  /**
   * AEコンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceAEModel(){

  }

  /**
   * 単位数単価パネル３に内部項目を追加します。
   */
  protected void addUnitPriceServicePanel3(){

    unitPriceServicePanel3.add(getUnitPriceServiceAFContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * AFコンボに内部項目を追加します。
   */
  protected void addUnitPriceServiceAF(){

  }

  /**
   * AFコンボモデルに内部項目を追加します。
   */
  protected void addUnitPriceServiceAFModel(){

  }

  /**
   * 有効期間コンテナに内部項目を追加します。
   */
  protected void addUnitPriceValidPeriodContena(){

    unitPriceValidPeriodContena.add(getUnitPriceValidStart(), VRLayout.FLOW);

    unitPriceValidPeriodContena.add(getUnitPriceValidLabel(), VRLayout.FLOW);

    unitPriceValidPeriodContena.add(getUnitPriceValidEnd(), VRLayout.FLOW);

  }

  /**
   * 有効期間テキスト(開始)に内部項目を追加します。
   */
  protected void addUnitPriceValidStart(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addUnitPriceValidLabel(){

  }

  /**
   * 有効期間テキスト(終了)に内部項目を追加します。
   */
  protected void addUnitPriceValidEnd(){

  }

  /**
   * 有効期間領域右に内部項目を追加します。
   */
  protected void addUnitPriceButtonPanel(){

    unitPriceButtonPanel.add(getUnitPriceButtons(), VRLayout.WEST);

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addUnitPriceButtons(){

    unitPriceButtons.add(getUnitPriceRegularButton(), VRLayout.WEST);

    unitPriceButtons.add(getUnitPriceInsertButton(), VRLayout.WEST);

    unitPriceButtons.add(getUnitPriceEditButton(), VRLayout.WEST);

    unitPriceButtons.add(getUnitPriceDeleteButton(), VRLayout.WEST);

  }

  /**
   * 規定に内部項目を追加します。
   */
  protected void addUnitPriceRegularButton(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addUnitPriceInsertButton(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addUnitPriceEditButton(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addUnitPriceDeleteButton(){

  }

  /**
   * 総合事業単位数単価情報パネルに内部項目を追加します。
   */
  protected void addUnitPriceInfo(){

    unitPriceInfo.add(getUnitPriceTable(), VRLayout.CLIENT);

  }

  /**
   * 総合事業単位数単価情報テーブルに内部項目を追加します。
   */
  protected void addUnitPriceTable(){

  }

  /**
   * 総合事業単位数単価情報テーブルカラムモデルに内部項目を追加します。
   */
  protected void addUnitPriceTableColumnModel(){

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum1());

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum2());

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum3());

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum4());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addUnitPriceTableColum1(){

  }

  /**
   * 総合事業単位数単価情報有効期間(開始)に内部項目を追加します。
   */
  protected void addUnitPriceTableColum2(){

  }

  /**
   * 総合事業単位数単価情報有効期間(終了)に内部項目を追加します。
   */
  protected void addUnitPriceTableColum3(){

  }

  /**
   * 地域区分に内部項目を追加します。
   */
  protected void addUnitPriceTableColum4(){

  }

  /**
   * Tab「総合事業 限度額」に内部項目を追加します。
   */
  protected void addTabInsurerLimitRate(){

    tabInsurerLimitRate.add(getInsurerLimitPanel(), VRLayout.CLIENT);

    tabInsurerLimitRate.add(getInsurerLimitRateInfos(), VRLayout.CLIENT);

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

    insurerLimitRateInfo.add(getValidPeriodPanel(), VRLayout.NORTH);

    insurerLimitRateInfo.add(getInsurerLimitRatePanel(), VRLayout.CLIENT);

  }

  /**
   * 有効期間領域に内部項目を追加します。
   */
  protected void addValidPeriodPanel(){

    validPeriodPanel.add(getValidPeriodLeft(), VRLayout.NORTH);

    validPeriodPanel.add(getValidPeriodRight(), VRLayout.NORTH);

  }

  /**
   * 有効期間領域左に内部項目を追加します。
   */
  protected void addValidPeriodLeft(){

    validPeriodLeft.add(getJigyoTaishoshaContainer(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getJigyoTaishoshaOverContainer(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getJigyoTaishoshaOverComment(), VRLayout.FLOW_INSETLINE_RETURN);

    validPeriodLeft.add(getYosien1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosien2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosienContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    validPeriodLeft.add(getYokaigo1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo3Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo4Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo5Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getValidPeriodCpntena(), VRLayout.FLOW_RETURN);

  }

  /**
   * 事業対象者テキストに内部項目を追加します。
   */
  protected void addJigyoTaishosha(){

  }

  /**
   * 事業対象者(要支援１超)テキストに内部項目を追加します。
   */
  protected void addJigyoTaishoshaOver(){

  }

  /**
   * 事業対象者コメント・ラベルに内部項目を追加します。
   */
  protected void addJigyoTaishoshaOverComment(){

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
   * 有効期間コンテナに内部項目を追加します。
   */
  protected void addValidPeriodCpntena(){

    validPeriodCpntena.add(getValidPeriodStart(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodLabel(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodEnd(), VRLayout.FLOW);

  }

  /**
   * 有効期間テキスト(開始)に内部項目を追加します。
   */
  protected void addValidPeriodStart(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addValidPeriodLabel(){

  }

  /**
   * 有効期間テキスト(終了)に内部項目を追加します。
   */
  protected void addValidPeriodEnd(){

  }

  /**
   * 有効期間領域右に内部項目を追加します。
   */
  protected void addValidPeriodRight(){

    validPeriodRight.add(getInsurerLimitRateButtons(), VRLayout.WEST);

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addInsurerLimitRateButtons(){

    insurerLimitRateButtons.add(getInsurerLimitRateRegularButton(), VRLayout.WEST);

    insurerLimitRateButtons.add(getInsurerLimitRateInsertButton(), VRLayout.WEST);

    insurerLimitRateButtons.add(getInsurerLimitRateEditButton(), VRLayout.WEST);

    insurerLimitRateButtons.add(getInsurerLimitRateDeleteButton(), VRLayout.WEST);

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

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum8());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum9());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum12());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum13());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum1(){

  }

  /**
   * 保険者情報有効期間(開始)に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum8(){

  }

  /**
   * 保険者情報有効期間(終了)に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum9(){

  }

  /**
   * 事業対象者に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum12(){

  }

  /**
   * 事業対象者(要支援１超)に内部項目を追加します。
   */
  protected void addInsurerLimitRateTableColum13(){

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
