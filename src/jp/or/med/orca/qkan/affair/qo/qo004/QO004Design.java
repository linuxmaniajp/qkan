
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
 * 開発者: 日高　しのぶ
 * 作成日: 2015/01/30  日本コンピューター株式会社 日高　しのぶ 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 事業者登録 (QO004)
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
 * 事業者登録画面項目デザイン(QO004) 
 */
public class QO004Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton newData;

  private ACAffairButton clear;

  private ACPanel providerContents;

  private ACPanel providerMainContents;

  private VRLayout providerMainContentsLayout;

  private ACTextField providerId;

  private ACLabelContainer providerIdContainer;

  private ACTextField providerName;

  private ACLabelContainer providerNameContainer;

  private ACLabelContainer providerPostnoContena;

  private ACTextField providerPostnoOn;

  private ACLabel providerPostnoHyphen;

  private ACTextField providerPostnoUnder;

  private ACTextField providerAddress;

  private ACLabelContainer providerAddressContainer;

  private ACLabelContainer providerTelContena;

  private ACTextField providerTelOn;

  private ACLabel providerTelHyphen1;

  private ACTextField providerTelInside;

  private ACLabel providerTelHyphen2;

  private ACTextField providerTelUnder;

  private ACLabelContainer providerFaxContena;

  private ACTextField providerFaxOn;

  private ACLabel providerFaxHyphen1;

  private ACTextField providerFaxInside;

  private ACLabel providerFaxHyphen2;

  private ACTextField providerFaxUnder;

  private ACTextField providerEstablishName;

  private ACLabelContainer providerEstablishNameContainer;

  private ACValueArrayRadioButtonGroup providerMainContentDivision;

  private ACLabelContainer providerMainContentDivisionContainer;

  private ACListModelAdapter providerMainContentDivisionModel;

  private ACRadioButtonItem providerMainContentDivisionMine;

  private ACRadioButtonItem providerMainContentDivisionOther;

  private ACValueArrayRadioButtonGroup providerMainContentBusiness;

  private ACLabelContainer providerMainContentBusinessContainer;

  private ACListModelAdapter providerMainContentBusinessModel;

  private ACRadioButtonItem providerMainContentBusinessSpecification;

  private ACRadioButtonItem providerMainContentBusinessStandard;

  private ACRadioButtonItem providerMainContentBusinessRegion;

  private ACIntegerCheckBox medical;

  private ACComboBox providerType;

  private ACLabelContainer providerTypeContainer;

  private ACComboBoxModelAdapter providerTypeModel;

  private ACValueArrayRadioButtonGroup providerMainContentRegion;

  private ACLabelContainer providerMainContentRegionContainer;

  private ACListModelAdapter providerMainContentRegionModel;

  private ACRadioButtonItem providerMainContentRegionLank1;

  private ACRadioButtonItem providerMainContentRegionLank2;

  private ACRadioButtonItem providerMainContentRegionLank3;

  private ACRadioButtonItem providerMainContentRegionLank4;

  private ACRadioButtonItem providerMainContentRegionLank5;

  private ACRadioButtonItem providerMainContentRegionLank6;

  private ACRadioButtonItem providerMainContentRegionLank7;

  private ACRadioButtonItem providerMainContentRegionLank8;

  private ACIntegerCheckBox lankSpecialArea;

  private ACPanel providerSubContents;

  private ACPanel providerDetailContents;

  private ACPanel providerDetailServiceKinds;

  private ACGroupBox serviceKindOffer;

  private ACPanel serviceKindTablePanel;

  private ACTable serviceKindTable;

  private VRTableColumnModel serviceKindTableColumnModel;

  private ACTableColumn serviceKindTableColum1;

  private ACTableColumn serviceKindTableColum2;

  private ACPanel buttonsPanel;

  private ACIntegerCheckBox offerCheck;

  private ACButton reflection;

  private ACPanel claimInfos;

  private ACTextField bankName;

  private ACLabelContainer bankNameContainer;

  private ACTextField bankBranchName;

  private ACLabelContainer bankBranchNameContainer;

  private ACTextField accountNumber;

  private ACLabelContainer accountNumberContainer;

  private ACValueArrayRadioButtonGroup accountTypeRadio;

  private ACLabelContainer accountTypeRadioContainer;

  private ACListModelAdapter accountTypeRadioModel;

  private ACRadioButtonItem accountTypeRadioItem1;

  private ACRadioButtonItem accountTypeRadioItem2;

  private ACTextField accountHolder;

  private ACLabelContainer accountHolderContainer;

  private ACPanel providerMainContentChargesPanel;

  private ACGroupBox providerStaffGroup;

  private ACPanel providerStaffTablePanel;

  private ACTable providerStaffTable;

  private VRTableColumnModel providerStaffTableColumnModel;

  private ACTableColumn providerStaffTableColumn1;

  private ACTableColumn providerStaffTableColumn2;

  private ACTableColumn providerStaffTableColumn3;

  private ACPanel providerStaffInputPanel;

  private ACTextField providerStaffCareManagerNo;

  private ACLabelContainer providerStaffCareManagerNoContainer;

  private ACLabelContainer providerStaffNameContainer;

  private ACBackLabelContainer providerStaffFamilyNameContainer;

  private ACTextField providerStaffFamilyName;

  private ACBackLabelContainer providerStaffFirstNameContainer;

  private ACTextField providerStaffFirstName;

  private ACPanel providerStaffTableControlPanel;

  private ACButton providerStaffInsert;

  private ACButton providerStaffFind;

  private ACButton providerStaffDelete;

  private ACPanel providerDetailServiceDetails;

  private ACGroupBox explanationTitleGroup;

  private ACLabel explanationTitleLabel;

  private ACLabel explanationContentLabel1;

  private ACLabel explanationContentLabe2;

  private ACLabel explanationContentLabe3;

  private ACLabel explanationContentLabel4;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("事業所登録");

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

      newData.setToolTipText("事業所を新規に作成します。");

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

      clear.setToolTipText("事業所の情報をクリアします。");

      clear.setMnemonic('C');

      clear.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClear();
    }
    return clear;

  }

  /**
   * 事業所情報領域を取得します。
   * @return 事業所情報領域
   */
  public ACPanel getProviderContents(){
    if(providerContents==null){

      providerContents = new ACPanel();

      addProviderContents();
    }
    return providerContents;

  }

  /**
   * 事業所メイン情報領域を取得します。
   * @return 事業所メイン情報領域
   */
  public ACPanel getProviderMainContents(){
    if(providerMainContents==null){

      providerMainContents = new ACPanel();

      providerMainContents.setLayout(getProviderMainContentsLayout());

      providerMainContents.setAutoWrap(false);

      addProviderMainContents();
    }
    return providerMainContents;

  }

  /**
   * 事業所メイン情報領域レイアウトを取得します。
   * @return 事業所メイン情報領域レイアウト
   */
  public VRLayout getProviderMainContentsLayout(){
    if(providerMainContentsLayout==null){

      providerMainContentsLayout = new VRLayout();

      providerMainContentsLayout.setHgrid(200);

      addProviderMainContentsLayout();
    }
    return providerMainContentsLayout;

  }

  /**
   * 事業所番号を取得します。
   * @return 事業所番号
   */
  public ACTextField getProviderId(){
    if(providerId==null){

      providerId = new ACTextField();

      getProviderIdContainer().setText("事業所番号");

      providerId.setBindPath("PROVIDER_ID");

      providerId.setColumns(8);

      providerId.setCharType(VRCharType.ONLY_ALNUM);

      providerId.setHorizontalAlignment(SwingConstants.LEFT);

      providerId.setIMEMode(InputSubset.LATIN);

      providerId.setMaxLength(10);

      /** @TODO 2014年度改正　英数字化 */

      addProviderId();
    }
    return providerId;

  }

  /**
   * 事業所番号コンテナを取得します。
   * @return 事業所番号コンテナ
   */
  protected ACLabelContainer getProviderIdContainer(){
    if(providerIdContainer==null){
      providerIdContainer = new ACLabelContainer();
      providerIdContainer.setFollowChildEnabled(true);
      providerIdContainer.setVAlignment(VRLayout.CENTER);
      providerIdContainer.add(getProviderId(), null);
    }
    return providerIdContainer;
  }

  /**
   * 事業所名称を取得します。
   * @return 事業所名称
   */
  public ACTextField getProviderName(){
    if(providerName==null){

      providerName = new ACTextField();

      getProviderNameContainer().setText("事業所名称");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setColumns(64);

      providerName.setHorizontalAlignment(SwingConstants.LEFT);

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(64);

      addProviderName();
    }
    return providerName;

  }

  /**
   * 事業所名称コンテナを取得します。
   * @return 事業所名称コンテナ
   */
  protected ACLabelContainer getProviderNameContainer(){
    if(providerNameContainer==null){
      providerNameContainer = new ACLabelContainer();
      providerNameContainer.setFollowChildEnabled(true);
      providerNameContainer.setVAlignment(VRLayout.CENTER);
      providerNameContainer.add(getProviderName(), null);
    }
    return providerNameContainer;
  }

  /**
   * 郵便番号コンテナを取得します。
   * @return 郵便番号コンテナ
   */
  public ACLabelContainer getProviderPostnoContena(){
    if(providerPostnoContena==null){

      providerPostnoContena = new ACLabelContainer();

      providerPostnoContena.setText("郵便番号");

      addProviderPostnoContena();
    }
    return providerPostnoContena;

  }

  /**
   * 郵便番号（上を取得します。
   * @return 郵便番号（上
   */
  public ACTextField getProviderPostnoOn(){
    if(providerPostnoOn==null){

      providerPostnoOn = new ACTextField();

      providerPostnoOn.setBindPath("PROVIDER_ZIP_FIRST");

      providerPostnoOn.setColumns(3);

      providerPostnoOn.setCharType(VRCharType.ONLY_DIGIT);

      providerPostnoOn.setHorizontalAlignment(SwingConstants.LEFT);

      providerPostnoOn.setIMEMode(InputSubset.LATIN);

      providerPostnoOn.setMaxLength(3);

      addProviderPostnoOn();
    }
    return providerPostnoOn;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getProviderPostnoHyphen(){
    if(providerPostnoHyphen==null){

      providerPostnoHyphen = new ACLabel();

      providerPostnoHyphen.setText("-");

      addProviderPostnoHyphen();
    }
    return providerPostnoHyphen;

  }

  /**
   * 郵便番号（下を取得します。
   * @return 郵便番号（下
   */
  public ACTextField getProviderPostnoUnder(){
    if(providerPostnoUnder==null){

      providerPostnoUnder = new ACTextField();

      providerPostnoUnder.setBindPath("PROVIDER_ZIP_SECOND");

      providerPostnoUnder.setColumns(4);

      providerPostnoUnder.setCharType(VRCharType.ONLY_DIGIT);

      providerPostnoUnder.setHorizontalAlignment(SwingConstants.LEFT);

      providerPostnoUnder.setIMEMode(InputSubset.LATIN);

      providerPostnoUnder.setMaxLength(4);

      addProviderPostnoUnder();
    }
    return providerPostnoUnder;

  }

  /**
   * 所在地を取得します。
   * @return 所在地
   */
  public ACTextField getProviderAddress(){
    if(providerAddress==null){

      providerAddress = new ACTextField();

      getProviderAddressContainer().setText("所在地");

      providerAddress.setBindPath("PROVIDER_ADDRESS");

      providerAddress.setColumns(70);

      providerAddress.setHorizontalAlignment(SwingConstants.LEFT);

      providerAddress.setIMEMode(InputSubset.KANJI);

      providerAddress.setMaxLength(70);

      addProviderAddress();
    }
    return providerAddress;

  }

  /**
   * 所在地コンテナを取得します。
   * @return 所在地コンテナ
   */
  protected ACLabelContainer getProviderAddressContainer(){
    if(providerAddressContainer==null){
      providerAddressContainer = new ACLabelContainer();
      providerAddressContainer.setFollowChildEnabled(true);
      providerAddressContainer.setVAlignment(VRLayout.CENTER);
      providerAddressContainer.add(getProviderAddress(), null);
    }
    return providerAddressContainer;
  }

  /**
   * 電話番号コンテナを取得します。
   * @return 電話番号コンテナ
   */
  public ACLabelContainer getProviderTelContena(){
    if(providerTelContena==null){

      providerTelContena = new ACLabelContainer();

      providerTelContena.setText("電話番号");

      addProviderTelContena();
    }
    return providerTelContena;

  }

  /**
   * 電話番号（上を取得します。
   * @return 電話番号（上
   */
  public ACTextField getProviderTelOn(){
    if(providerTelOn==null){

      providerTelOn = new ACTextField();

      providerTelOn.setBindPath("PROVIDER_TEL_FIRST");

      providerTelOn.setColumns(5);

      providerTelOn.setCharType(VRCharType.ONLY_DIGIT);

      providerTelOn.setHorizontalAlignment(SwingConstants.LEFT);

      providerTelOn.setIMEMode(InputSubset.LATIN);

      providerTelOn.setMaxLength(5);

      addProviderTelOn();
    }
    return providerTelOn;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getProviderTelHyphen1(){
    if(providerTelHyphen1==null){

      providerTelHyphen1 = new ACLabel();

      providerTelHyphen1.setText("-");

      addProviderTelHyphen1();
    }
    return providerTelHyphen1;

  }

  /**
   * 電話番号（中を取得します。
   * @return 電話番号（中
   */
  public ACTextField getProviderTelInside(){
    if(providerTelInside==null){

      providerTelInside = new ACTextField();

      providerTelInside.setBindPath("PROVIDER_TEL_SECOND");

      providerTelInside.setColumns(4);

      providerTelInside.setCharType(VRCharType.ONLY_DIGIT);

      providerTelInside.setHorizontalAlignment(SwingConstants.LEFT);

      providerTelInside.setIMEMode(InputSubset.LATIN);

      providerTelInside.setMaxLength(4);

      addProviderTelInside();
    }
    return providerTelInside;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getProviderTelHyphen2(){
    if(providerTelHyphen2==null){

      providerTelHyphen2 = new ACLabel();

      providerTelHyphen2.setText("-");

      addProviderTelHyphen2();
    }
    return providerTelHyphen2;

  }

  /**
   * 電話番号（下を取得します。
   * @return 電話番号（下
   */
  public ACTextField getProviderTelUnder(){
    if(providerTelUnder==null){

      providerTelUnder = new ACTextField();

      providerTelUnder.setBindPath("PROVIDER_TEL_THIRD");

      providerTelUnder.setColumns(4);

      providerTelUnder.setCharType(VRCharType.ONLY_DIGIT);

      providerTelUnder.setHorizontalAlignment(SwingConstants.LEFT);

      providerTelUnder.setIMEMode(InputSubset.LATIN);

      providerTelUnder.setMaxLength(4);

      addProviderTelUnder();
    }
    return providerTelUnder;

  }

  /**
   * FAX番号コンテナを取得します。
   * @return FAX番号コンテナ
   */
  public ACLabelContainer getProviderFaxContena(){
    if(providerFaxContena==null){

      providerFaxContena = new ACLabelContainer();

      providerFaxContena.setText("FAX番号");

      addProviderFaxContena();
    }
    return providerFaxContena;

  }

  /**
   * FAX（上を取得します。
   * @return FAX（上
   */
  public ACTextField getProviderFaxOn(){
    if(providerFaxOn==null){

      providerFaxOn = new ACTextField();

      providerFaxOn.setBindPath("PROVIDER_FAX_FIRST");

      providerFaxOn.setColumns(5);

      providerFaxOn.setCharType(VRCharType.ONLY_DIGIT);

      providerFaxOn.setHorizontalAlignment(SwingConstants.LEFT);

      providerFaxOn.setIMEMode(InputSubset.LATIN);

      providerFaxOn.setMaxLength(5);

      addProviderFaxOn();
    }
    return providerFaxOn;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getProviderFaxHyphen1(){
    if(providerFaxHyphen1==null){

      providerFaxHyphen1 = new ACLabel();

      providerFaxHyphen1.setText("-");

      addProviderFaxHyphen1();
    }
    return providerFaxHyphen1;

  }

  /**
   * FAX（中を取得します。
   * @return FAX（中
   */
  public ACTextField getProviderFaxInside(){
    if(providerFaxInside==null){

      providerFaxInside = new ACTextField();

      providerFaxInside.setBindPath("PROVIDER_FAX_SECOND");

      providerFaxInside.setColumns(4);

      providerFaxInside.setCharType(VRCharType.ONLY_DIGIT);

      providerFaxInside.setHorizontalAlignment(SwingConstants.LEFT);

      providerFaxInside.setIMEMode(InputSubset.LATIN);

      providerFaxInside.setMaxLength(4);

      addProviderFaxInside();
    }
    return providerFaxInside;

  }

  /**
   * ハイフンを取得します。
   * @return ハイフン
   */
  public ACLabel getProviderFaxHyphen2(){
    if(providerFaxHyphen2==null){

      providerFaxHyphen2 = new ACLabel();

      providerFaxHyphen2.setText("-");

      addProviderFaxHyphen2();
    }
    return providerFaxHyphen2;

  }

  /**
   * FAX（下を取得します。
   * @return FAX（下
   */
  public ACTextField getProviderFaxUnder(){
    if(providerFaxUnder==null){

      providerFaxUnder = new ACTextField();

      providerFaxUnder.setBindPath("PROVIDER_FAX_THIRD");

      providerFaxUnder.setColumns(4);

      providerFaxUnder.setCharType(VRCharType.ONLY_DIGIT);

      providerFaxUnder.setHorizontalAlignment(SwingConstants.LEFT);

      providerFaxUnder.setIMEMode(InputSubset.LATIN);

      providerFaxUnder.setMaxLength(4);

      addProviderFaxUnder();
    }
    return providerFaxUnder;

  }

  /**
   * 管理者を取得します。
   * @return 管理者
   */
  public ACTextField getProviderEstablishName(){
    if(providerEstablishName==null){

      providerEstablishName = new ACTextField();

      getProviderEstablishNameContainer().setText("管理者");

      providerEstablishName.setBindPath("PROVIDER_OWNER_NAME");

      providerEstablishName.setColumns(16);

      providerEstablishName.setHorizontalAlignment(SwingConstants.LEFT);

      providerEstablishName.setIMEMode(InputSubset.KANJI);

      providerEstablishName.setMaxLength(16);

      addProviderEstablishName();
    }
    return providerEstablishName;

  }

  /**
   * 管理者コンテナを取得します。
   * @return 管理者コンテナ
   */
  protected ACLabelContainer getProviderEstablishNameContainer(){
    if(providerEstablishNameContainer==null){
      providerEstablishNameContainer = new ACLabelContainer();
      providerEstablishNameContainer.setFollowChildEnabled(true);
      providerEstablishNameContainer.setVAlignment(VRLayout.CENTER);
      providerEstablishNameContainer.add(getProviderEstablishName(), null);
    }
    return providerEstablishNameContainer;
  }

  /**
   * 自事業所区分ラジオグループを取得します。
   * @return 自事業所区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getProviderMainContentDivision(){
    if(providerMainContentDivision==null){

      providerMainContentDivision = new ACValueArrayRadioButtonGroup();

      getProviderMainContentDivisionContainer().setText("自事業所区分");

      providerMainContentDivision.setBindPath("PROVIDER_JIJIGYOUSHO_TYPE");

      providerMainContentDivision.setUseClearButton(false);

      providerMainContentDivision.setModel(getProviderMainContentDivisionModel());

      providerMainContentDivision.setValues(new int[]{1,2});

      addProviderMainContentDivision();
    }
    return providerMainContentDivision;

  }

  /**
   * 自事業所区分ラジオグループコンテナを取得します。
   * @return 自事業所区分ラジオグループコンテナ
   */
  protected ACLabelContainer getProviderMainContentDivisionContainer(){
    if(providerMainContentDivisionContainer==null){
      providerMainContentDivisionContainer = new ACLabelContainer();
      providerMainContentDivisionContainer.setFollowChildEnabled(true);
      providerMainContentDivisionContainer.setVAlignment(VRLayout.CENTER);
      providerMainContentDivisionContainer.add(getProviderMainContentDivision(), null);
    }
    return providerMainContentDivisionContainer;
  }

  /**
   * 自事業所区分ラジオグループモデルを取得します。
   * @return 自事業所区分ラジオグループモデル
   */
  protected ACListModelAdapter getProviderMainContentDivisionModel(){
    if(providerMainContentDivisionModel==null){
      providerMainContentDivisionModel = new ACListModelAdapter();
      addProviderMainContentDivisionModel();
    }
    return providerMainContentDivisionModel;
  }

  /**
   * 自事業所を取得します。
   * @return 自事業所
   */
  public ACRadioButtonItem getProviderMainContentDivisionMine(){
    if(providerMainContentDivisionMine==null){

      providerMainContentDivisionMine = new ACRadioButtonItem();

      providerMainContentDivisionMine.setText("自事業所");

      providerMainContentDivisionMine.setGroup(getProviderMainContentDivision());

      addProviderMainContentDivisionMine();
    }
    return providerMainContentDivisionMine;

  }

  /**
   * 他事業所を取得します。
   * @return 他事業所
   */
  public ACRadioButtonItem getProviderMainContentDivisionOther(){
    if(providerMainContentDivisionOther==null){

      providerMainContentDivisionOther = new ACRadioButtonItem();

      providerMainContentDivisionOther.setText("他事業所");

      providerMainContentDivisionOther.setGroup(getProviderMainContentDivision());

      addProviderMainContentDivisionOther();
    }
    return providerMainContentDivisionOther;

  }

  /**
   * 事業区分ラジオグループを取得します。
   * @return 事業区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getProviderMainContentBusiness(){
    if(providerMainContentBusiness==null){

      providerMainContentBusiness = new ACValueArrayRadioButtonGroup();

      getProviderMainContentBusinessContainer().setText("事業所区分");

      providerMainContentBusiness.setBindPath("PROVIDER_JIGYOU_TYPE");

      providerMainContentBusiness.setUseClearButton(false);

      providerMainContentBusiness.setModel(getProviderMainContentBusinessModel());

      providerMainContentBusiness.setValues(new int[]{1,2,5});

      addProviderMainContentBusiness();
    }
    return providerMainContentBusiness;

  }

  /**
   * 事業区分ラジオグループコンテナを取得します。
   * @return 事業区分ラジオグループコンテナ
   */
  protected ACLabelContainer getProviderMainContentBusinessContainer(){
    if(providerMainContentBusinessContainer==null){
      providerMainContentBusinessContainer = new ACLabelContainer();
      providerMainContentBusinessContainer.setFollowChildEnabled(true);
      providerMainContentBusinessContainer.setVAlignment(VRLayout.CENTER);
      providerMainContentBusinessContainer.add(getProviderMainContentBusiness(), null);
    }
    return providerMainContentBusinessContainer;
  }

  /**
   * 事業区分ラジオグループモデルを取得します。
   * @return 事業区分ラジオグループモデル
   */
  protected ACListModelAdapter getProviderMainContentBusinessModel(){
    if(providerMainContentBusinessModel==null){
      providerMainContentBusinessModel = new ACListModelAdapter();
      addProviderMainContentBusinessModel();
    }
    return providerMainContentBusinessModel;
  }

  /**
   * 指定を取得します。
   * @return 指定
   */
  public ACRadioButtonItem getProviderMainContentBusinessSpecification(){
    if(providerMainContentBusinessSpecification==null){

      providerMainContentBusinessSpecification = new ACRadioButtonItem();

      providerMainContentBusinessSpecification.setText("指定");

      providerMainContentBusinessSpecification.setGroup(getProviderMainContentBusiness());

      addProviderMainContentBusinessSpecification();
    }
    return providerMainContentBusinessSpecification;

  }

  /**
   * 基準該当を取得します。
   * @return 基準該当
   */
  public ACRadioButtonItem getProviderMainContentBusinessStandard(){
    if(providerMainContentBusinessStandard==null){

      providerMainContentBusinessStandard = new ACRadioButtonItem();

      providerMainContentBusinessStandard.setText("基準該当");

      providerMainContentBusinessStandard.setGroup(getProviderMainContentBusiness());

      addProviderMainContentBusinessStandard();
    }
    return providerMainContentBusinessStandard;

  }

  /**
   * 地域密着を取得します。
   * @return 地域密着
   */
  public ACRadioButtonItem getProviderMainContentBusinessRegion(){
    if(providerMainContentBusinessRegion==null){

      providerMainContentBusinessRegion = new ACRadioButtonItem();

      providerMainContentBusinessRegion.setText("地域密着");

      providerMainContentBusinessRegion.setGroup(getProviderMainContentBusiness());

      addProviderMainContentBusinessRegion();
    }
    return providerMainContentBusinessRegion;

  }

  /**
   * 医療機関を取得します。
   * @return 医療機関
   */
  public ACIntegerCheckBox getMedical(){
    if(medical==null){

      medical = new ACIntegerCheckBox();

      medical.setText("医療機関");

      medical.setBindPath("MEDICAL_FLAG");

      medical.setVisible(false);

      addMedical();
    }
    return medical;

  }

  /**
   * 事業所種別を取得します。
   * @return 事業所種別
   */
  public ACComboBox getProviderType(){
    if(providerType==null){

      providerType = new ACComboBox();

      getProviderTypeContainer().setText("事業所種別");

      providerType.setBindPath("PROVIDER_TYPE");

      providerType.setEditable(false);

      providerType.setModelBindPath("PROVIDER_TYPE");

      providerType.setRenderBindPath("CONTENT");

      providerType.setBlankable(true);

      providerType.setModel(getProviderTypeModel());

      addProviderType();
    }
    return providerType;

  }

  /**
   * 事業所種別コンテナを取得します。
   * @return 事業所種別コンテナ
   */
  protected ACLabelContainer getProviderTypeContainer(){
    if(providerTypeContainer==null){
      providerTypeContainer = new ACLabelContainer();
      providerTypeContainer.setFollowChildEnabled(true);
      providerTypeContainer.setVAlignment(VRLayout.CENTER);
      providerTypeContainer.add(getProviderType(), null);
    }
    return providerTypeContainer;
  }

  /**
   * 事業所種別モデルを取得します。
   * @return 事業所種別モデル
   */
  protected ACComboBoxModelAdapter getProviderTypeModel(){
    if(providerTypeModel==null){
      providerTypeModel = new ACComboBoxModelAdapter();
      addProviderTypeModel();
    }
    return providerTypeModel;
  }

  /**
   * 地域区分ラジオグループを取得します。
   * @return 地域区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getProviderMainContentRegion(){
    if(providerMainContentRegion==null){

      providerMainContentRegion = new ACValueArrayRadioButtonGroup();

      getProviderMainContentRegionContainer().setText("地域区分");

      providerMainContentRegion.setBindPath("PROVIDER_AREA_TYPE");

      providerMainContentRegion.setUseClearButton(false);

      providerMainContentRegion.setModel(getProviderMainContentRegionModel());

      providerMainContentRegion.setValues(new int[]{1,6,7,2,3,4,9,5});

      addProviderMainContentRegion();
    }
    return providerMainContentRegion;

  }

  /**
   * 地域区分ラジオグループコンテナを取得します。
   * @return 地域区分ラジオグループコンテナ
   */
  protected ACLabelContainer getProviderMainContentRegionContainer(){
    if(providerMainContentRegionContainer==null){
      providerMainContentRegionContainer = new ACLabelContainer();
      providerMainContentRegionContainer.setFollowChildEnabled(true);
      providerMainContentRegionContainer.setVAlignment(VRLayout.CENTER);
      providerMainContentRegionContainer.add(getProviderMainContentRegion(), null);
    }
    return providerMainContentRegionContainer;
  }

  /**
   * 地域区分ラジオグループモデルを取得します。
   * @return 地域区分ラジオグループモデル
   */
  protected ACListModelAdapter getProviderMainContentRegionModel(){
    if(providerMainContentRegionModel==null){
      providerMainContentRegionModel = new ACListModelAdapter();
      addProviderMainContentRegionModel();
    }
    return providerMainContentRegionModel;
  }

  /**
   * １級地を取得します。
   * @return １級地
   */
  public ACRadioButtonItem getProviderMainContentRegionLank1(){
    if(providerMainContentRegionLank1==null){

      providerMainContentRegionLank1 = new ACRadioButtonItem();

      providerMainContentRegionLank1.setText("1級地");

      providerMainContentRegionLank1.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank1.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank1();
    }
    return providerMainContentRegionLank1;

  }

  /**
   * ２級地を取得します。
   * @return ２級地
   */
  public ACRadioButtonItem getProviderMainContentRegionLank2(){
    if(providerMainContentRegionLank2==null){

      providerMainContentRegionLank2 = new ACRadioButtonItem();

      providerMainContentRegionLank2.setText("2級地");

      providerMainContentRegionLank2.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank2.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank2();
    }
    return providerMainContentRegionLank2;

  }

  /**
   * ３級地を取得します。
   * @return ３級地
   */
  public ACRadioButtonItem getProviderMainContentRegionLank3(){
    if(providerMainContentRegionLank3==null){

      providerMainContentRegionLank3 = new ACRadioButtonItem();

      providerMainContentRegionLank3.setText("3級地");

      providerMainContentRegionLank3.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank3.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank3();
    }
    return providerMainContentRegionLank3;

  }

  /**
   * ４級地を取得します。
   * @return ４級地
   */
  public ACRadioButtonItem getProviderMainContentRegionLank4(){
    if(providerMainContentRegionLank4==null){

      providerMainContentRegionLank4 = new ACRadioButtonItem();

      providerMainContentRegionLank4.setText("4級地");

      providerMainContentRegionLank4.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank4.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank4();
    }
    return providerMainContentRegionLank4;

  }

  /**
   * ５級地を取得します。
   * @return ５級地
   */
  public ACRadioButtonItem getProviderMainContentRegionLank5(){
    if(providerMainContentRegionLank5==null){

      providerMainContentRegionLank5 = new ACRadioButtonItem();

      providerMainContentRegionLank5.setText("5級地");

      providerMainContentRegionLank5.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank5.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank5();
    }
    return providerMainContentRegionLank5;

  }

  /**
   * ６級地を取得します。
   * @return ６級地
   */
  public ACRadioButtonItem getProviderMainContentRegionLank6(){
    if(providerMainContentRegionLank6==null){

      providerMainContentRegionLank6 = new ACRadioButtonItem();

      providerMainContentRegionLank6.setText("6級地");

      providerMainContentRegionLank6.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank6.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank6();
    }
    return providerMainContentRegionLank6;

  }

  /**
   * ７級地を取得します。
   * @return ７級地
   */
  public ACRadioButtonItem getProviderMainContentRegionLank7(){
    if(providerMainContentRegionLank7==null){

      providerMainContentRegionLank7 = new ACRadioButtonItem();

      providerMainContentRegionLank7.setText("7級地");

      providerMainContentRegionLank7.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank7.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank7();
    }
    return providerMainContentRegionLank7;

  }

  /**
   * その他を取得します。
   * @return その他
   */
  public ACRadioButtonItem getProviderMainContentRegionLank8(){
    if(providerMainContentRegionLank8==null){

      providerMainContentRegionLank8 = new ACRadioButtonItem();

      providerMainContentRegionLank8.setText("その他");

      providerMainContentRegionLank8.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank8.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank8();
    }
    return providerMainContentRegionLank8;

  }

  /**
   * 特別地域を取得します。
   * @return 特別地域
   */
  public ACIntegerCheckBox getLankSpecialArea(){
    if(lankSpecialArea==null){

      lankSpecialArea = new ACIntegerCheckBox();

      lankSpecialArea.setText("特別地域");

      lankSpecialArea.setBindPath("SPECIAL_AREA_FLAG");

      lankSpecialArea.setSelectValue(2);

      lankSpecialArea.setUnSelectValue(1);

      addLankSpecialArea();
    }
    return lankSpecialArea;

  }

  /**
   * 事業所サブ情報領域を取得します。
   * @return 事業所サブ情報領域
   */
  public ACPanel getProviderSubContents(){
    if(providerSubContents==null){

      providerSubContents = new ACPanel();

      addProviderSubContents();
    }
    return providerSubContents;

  }

  /**
   * 事業所詳細情報領域を取得します。
   * @return 事業所詳細情報領域
   */
  public ACPanel getProviderDetailContents(){
    if(providerDetailContents==null){

      providerDetailContents = new ACPanel();

      addProviderDetailContents();
    }
    return providerDetailContents;

  }

  /**
   * 事業所詳細情報サービスリスト領域を取得します。
   * @return 事業所詳細情報サービスリスト領域
   */
  public ACPanel getProviderDetailServiceKinds(){
    if(providerDetailServiceKinds==null){

      providerDetailServiceKinds = new ACPanel();

      addProviderDetailServiceKinds();
    }
    return providerDetailServiceKinds;

  }

  /**
   * 提供サービスを取得します。
   * @return 提供サービス
   */
  public ACGroupBox getServiceKindOffer(){
    if(serviceKindOffer==null){

      serviceKindOffer = new ACGroupBox();

      serviceKindOffer.setText("提供サービス");

      serviceKindOffer.setHgap(0);

      serviceKindOffer.setLabelMargin(0);

      addServiceKindOffer();
    }
    return serviceKindOffer;

  }

  /**
   * 提供サービステーブル領域を取得します。
   * @return 提供サービステーブル領域
   */
  public ACPanel getServiceKindTablePanel(){
    if(serviceKindTablePanel==null){

      serviceKindTablePanel = new ACPanel();

      serviceKindTablePanel.setHgap(2);

      serviceKindTablePanel.setLabelMargin(0);

      addServiceKindTablePanel();
    }
    return serviceKindTablePanel;

  }

  /**
   * 提供サービステーブルを取得します。
   * @return 提供サービステーブル
   */
  public ACTable getServiceKindTable(){
    if(serviceKindTable==null){

      serviceKindTable = new ACTable();

      serviceKindTable.setColumnModel(getServiceKindTableColumnModel());

      serviceKindTable.setPreferredSize(new Dimension(340,140));

      addServiceKindTable();
    }
    return serviceKindTable;

  }

  /**
   * 提供サービステーブルカラムモデルを取得します。
   * @return 提供サービステーブルカラムモデル
   */
  protected VRTableColumnModel getServiceKindTableColumnModel(){
    if(serviceKindTableColumnModel==null){
      serviceKindTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addServiceKindTableColumnModel();
    }
    return serviceKindTableColumnModel;
  }

  /**
   * 提供を取得します。
   * @return 提供
   */
  public ACTableColumn getServiceKindTableColum1(){
    if(serviceKindTableColum1==null){

      serviceKindTableColum1 = new ACTableColumn(0);

      serviceKindTableColum1.setHeaderValue("提供");

      serviceKindTableColum1.setColumns(3);

      serviceKindTableColum1.setHorizontalAlignment(SwingConstants.CENTER);

      serviceKindTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      serviceKindTableColum1.setSortable(false);

      addServiceKindTableColum1();
    }
    return serviceKindTableColum1;

  }

  /**
   * 提供サービスを取得します。
   * @return 提供サービス
   */
  public ACTableColumn getServiceKindTableColum2(){
    if(serviceKindTableColum2==null){

      serviceKindTableColum2 = new ACTableColumn(1);

      serviceKindTableColum2.setHeaderValue("提供サービス");

      serviceKindTableColum2.setSortable(false);

      addServiceKindTableColum2();
    }
    return serviceKindTableColum2;

  }

  /**
   * ボタンパネルを取得します。
   * @return ボタンパネル
   */
  public ACPanel getButtonsPanel(){
    if(buttonsPanel==null){

      buttonsPanel = new ACPanel();

      buttonsPanel.setAutoWrap(false);

      buttonsPanel.setHgap(6);

      buttonsPanel.setLabelMargin(0);

      addButtonsPanel();
    }
    return buttonsPanel;

  }

  /**
   * 提供チェックを取得します。
   * @return 提供チェック
   */
  public ACIntegerCheckBox getOfferCheck(){
    if(offerCheck==null){

      offerCheck = new ACIntegerCheckBox();

      offerCheck.setText("提供する");

      offerCheck.setBindPath("OFFER");

      addOfferCheck();
    }
    return offerCheck;

  }

  /**
   * 反映を取得します。
   * @return 反映
   */
  public ACButton getReflection(){
    if(reflection==null){

      reflection = new ACButton();

      reflection.setText("反映");

      reflection.setToolTipText("現在の提供サービス情報を反映します。");

      reflection.setIconPath(ACConstants.ICON_PATH_LEFT_16);

      addReflection();
    }
    return reflection;

  }

  /**
   * 請求関連情報領域を取得します。
   * @return 請求関連情報領域
   */
  public ACPanel getClaimInfos(){
    if(claimInfos==null){

      claimInfos = new ACPanel();

      addClaimInfos();
    }
    return claimInfos;

  }

  /**
   * 振込先金融機関名を取得します。
   * @return 振込先金融機関名
   */
  public ACTextField getBankName(){
    if(bankName==null){

      bankName = new ACTextField();

      getBankNameContainer().setText("振込先金融機関名");

      bankName.setBindPath("BANK_NAME");

      bankName.setColumns(15);

      bankName.setIMEMode(InputSubset.KANJI);

      bankName.setMaxLength(25);

      addBankName();
    }
    return bankName;

  }

  /**
   * 振込先金融機関名コンテナを取得します。
   * @return 振込先金融機関名コンテナ
   */
  protected ACLabelContainer getBankNameContainer(){
    if(bankNameContainer==null){
      bankNameContainer = new ACLabelContainer();
      bankNameContainer.setFollowChildEnabled(true);
      bankNameContainer.setVAlignment(VRLayout.CENTER);
      bankNameContainer.add(getBankName(), null);
    }
    return bankNameContainer;
  }

  /**
   * 振込先金融機関支店名を取得します。
   * @return 振込先金融機関支店名
   */
  public ACTextField getBankBranchName(){
    if(bankBranchName==null){

      bankBranchName = new ACTextField();

      getBankBranchNameContainer().setText("振込先金融機関支店名");

      bankBranchName.setBindPath("BANK_BRANCH_NAME");

      bankBranchName.setColumns(15);

      bankBranchName.setIMEMode(InputSubset.KANJI);

      bankBranchName.setMaxLength(25);

      addBankBranchName();
    }
    return bankBranchName;

  }

  /**
   * 振込先金融機関支店名コンテナを取得します。
   * @return 振込先金融機関支店名コンテナ
   */
  protected ACLabelContainer getBankBranchNameContainer(){
    if(bankBranchNameContainer==null){
      bankBranchNameContainer = new ACLabelContainer();
      bankBranchNameContainer.setFollowChildEnabled(true);
      bankBranchNameContainer.setVAlignment(VRLayout.CENTER);
      bankBranchNameContainer.add(getBankBranchName(), null);
    }
    return bankBranchNameContainer;
  }

  /**
   * 振込先口座番号を取得します。
   * @return 振込先口座番号
   */
  public ACTextField getAccountNumber(){
    if(accountNumber==null){

      accountNumber = new ACTextField();

      getAccountNumberContainer().setText("振込先口座番号");

      accountNumber.setBindPath("ACCOUNT_NUMBER");

      accountNumber.setColumns(7);

      accountNumber.setCharType(VRCharType.ONLY_ALNUM);

      accountNumber.setIMEMode(InputSubset.LATIN);

      accountNumber.setMaxLength(10);

      addAccountNumber();
    }
    return accountNumber;

  }

  /**
   * 振込先口座番号コンテナを取得します。
   * @return 振込先口座番号コンテナ
   */
  protected ACLabelContainer getAccountNumberContainer(){
    if(accountNumberContainer==null){
      accountNumberContainer = new ACLabelContainer();
      accountNumberContainer.setFollowChildEnabled(true);
      accountNumberContainer.setVAlignment(VRLayout.CENTER);
      accountNumberContainer.add(getAccountNumber(), null);
    }
    return accountNumberContainer;
  }

  /**
   * 振込先口座種類を取得します。
   * @return 振込先口座種類
   */
  public ACValueArrayRadioButtonGroup getAccountTypeRadio(){
    if(accountTypeRadio==null){

      accountTypeRadio = new ACValueArrayRadioButtonGroup();

      getAccountTypeRadioContainer().setText("振込先口座種類");

      accountTypeRadio.setBindPath("ACCOUNT_TYPE");

      accountTypeRadio.setModel(getAccountTypeRadioModel());

      accountTypeRadio.setValues(new int[]{1,2});

      addAccountTypeRadio();
    }
    return accountTypeRadio;

  }

  /**
   * 振込先口座種類コンテナを取得します。
   * @return 振込先口座種類コンテナ
   */
  protected ACLabelContainer getAccountTypeRadioContainer(){
    if(accountTypeRadioContainer==null){
      accountTypeRadioContainer = new ACLabelContainer();
      accountTypeRadioContainer.setFollowChildEnabled(true);
      accountTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      accountTypeRadioContainer.add(getAccountTypeRadio(), null);
    }
    return accountTypeRadioContainer;
  }

  /**
   * 振込先口座種類モデルを取得します。
   * @return 振込先口座種類モデル
   */
  protected ACListModelAdapter getAccountTypeRadioModel(){
    if(accountTypeRadioModel==null){
      accountTypeRadioModel = new ACListModelAdapter();
      addAccountTypeRadioModel();
    }
    return accountTypeRadioModel;
  }

  /**
   * 普通を取得します。
   * @return 普通
   */
  public ACRadioButtonItem getAccountTypeRadioItem1(){
    if(accountTypeRadioItem1==null){

      accountTypeRadioItem1 = new ACRadioButtonItem();

      accountTypeRadioItem1.setText("普通");

      accountTypeRadioItem1.setGroup(getAccountTypeRadio());

      addAccountTypeRadioItem1();
    }
    return accountTypeRadioItem1;

  }

  /**
   * 当座を取得します。
   * @return 当座
   */
  public ACRadioButtonItem getAccountTypeRadioItem2(){
    if(accountTypeRadioItem2==null){

      accountTypeRadioItem2 = new ACRadioButtonItem();

      accountTypeRadioItem2.setText("当座");

      accountTypeRadioItem2.setGroup(getAccountTypeRadio());

      addAccountTypeRadioItem2();
    }
    return accountTypeRadioItem2;

  }

  /**
   * 振込先名義人を取得します。
   * @return 振込先名義人
   */
  public ACTextField getAccountHolder(){
    if(accountHolder==null){

      accountHolder = new ACTextField();

      getAccountHolderContainer().setText("振込先名義人");

      accountHolder.setBindPath("ACCOUNT_HOLDER");

      accountHolder.setColumns(20);

      accountHolder.setIMEMode(InputSubset.KANJI);

      accountHolder.setMaxLength(50);

      addAccountHolder();
    }
    return accountHolder;

  }

  /**
   * 振込先名義人コンテナを取得します。
   * @return 振込先名義人コンテナ
   */
  protected ACLabelContainer getAccountHolderContainer(){
    if(accountHolderContainer==null){
      accountHolderContainer = new ACLabelContainer();
      accountHolderContainer.setFollowChildEnabled(true);
      accountHolderContainer.setVAlignment(VRLayout.CENTER);
      accountHolderContainer.add(getAccountHolder(), null);
    }
    return accountHolderContainer;
  }

  /**
   * 担当者領域を取得します。
   * @return 担当者領域
   */
  public ACPanel getProviderMainContentChargesPanel(){
    if(providerMainContentChargesPanel==null){

      providerMainContentChargesPanel = new ACPanel();

      addProviderMainContentChargesPanel();
    }
    return providerMainContentChargesPanel;

  }

  /**
   * 担当者グループを取得します。
   * @return 担当者グループ
   */
  public ACGroupBox getProviderStaffGroup(){
    if(providerStaffGroup==null){

      providerStaffGroup = new ACGroupBox();

      providerStaffGroup.setText("担当者");

      addProviderStaffGroup();
    }
    return providerStaffGroup;

  }

  /**
   * 担当者テーブル領域を取得します。
   * @return 担当者テーブル領域
   */
  public ACPanel getProviderStaffTablePanel(){
    if(providerStaffTablePanel==null){

      providerStaffTablePanel = new ACPanel();

      addProviderStaffTablePanel();
    }
    return providerStaffTablePanel;

  }

  /**
   * 担当者テーブルを取得します。
   * @return 担当者テーブル
   */
  public ACTable getProviderStaffTable(){
    if(providerStaffTable==null){

      providerStaffTable = new ACTable();

      providerStaffTable.setColumnModel(getProviderStaffTableColumnModel());

      providerStaffTable.setPreferredSize(new Dimension(440,80));

      addProviderStaffTable();
    }
    return providerStaffTable;

  }

  /**
   * 担当者テーブルカラムモデルを取得します。
   * @return 担当者テーブルカラムモデル
   */
  protected VRTableColumnModel getProviderStaffTableColumnModel(){
    if(providerStaffTableColumnModel==null){
      providerStaffTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addProviderStaffTableColumnModel();
    }
    return providerStaffTableColumnModel;
  }

  /**
   * Noを取得します。
   * @return No
   */
  public ACTableColumn getProviderStaffTableColumn1(){
    if(providerStaffTableColumn1==null){

      providerStaffTableColumn1 = new ACTableColumn(0);

      providerStaffTableColumn1.setHeaderValue("No");

      providerStaffTableColumn1.setColumns(3);

      providerStaffTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      providerStaffTableColumn1.setSortable(false);

      providerStaffTableColumn1.setEditorType(ACTableCellViewer.EDITOR_TYPE_SERIAL_NO);

      addProviderStaffTableColumn1();
    }
    return providerStaffTableColumn1;

  }

  /**
   * 支援専門員番号を取得します。
   * @return 支援専門員番号
   */
  public ACTableColumn getProviderStaffTableColumn2(){
    if(providerStaffTableColumn2==null){

      providerStaffTableColumn2 = new ACTableColumn(0);

      providerStaffTableColumn2.setHeaderValue("支援専門員番号");

      providerStaffTableColumn2.setColumns(9);

      providerStaffTableColumn2.setSortable(true);

      addProviderStaffTableColumn2();
    }
    return providerStaffTableColumn2;

  }

  /**
   * 担当者名を取得します。
   * @return 担当者名
   */
  public ACTableColumn getProviderStaffTableColumn3(){
    if(providerStaffTableColumn3==null){

      providerStaffTableColumn3 = new ACTableColumn(1);

      providerStaffTableColumn3.setHeaderValue("担当者名");

      providerStaffTableColumn3.setSortable(true);

      addProviderStaffTableColumn3();
    }
    return providerStaffTableColumn3;

  }

  /**
   * 担当者入力領域を取得します。
   * @return 担当者入力領域
   */
  public ACPanel getProviderStaffInputPanel(){
    if(providerStaffInputPanel==null){

      providerStaffInputPanel = new ACPanel();

      providerStaffInputPanel.setAutoWrap(false);

      providerStaffInputPanel.setHgap(0);

      providerStaffInputPanel.setLabelMargin(0);

      addProviderStaffInputPanel();
    }
    return providerStaffInputPanel;

  }

  /**
   * 支援専門員番号を取得します。
   * @return 支援専門員番号
   */
  public ACTextField getProviderStaffCareManagerNo(){
    if(providerStaffCareManagerNo==null){

      providerStaffCareManagerNo = new ACTextField();

      getProviderStaffCareManagerNoContainer().setText("支援専門員番号");

      providerStaffCareManagerNo.setBindPath("CARE_MANAGER_NO");

      providerStaffCareManagerNo.setColumns(6);

      providerStaffCareManagerNo.setCharType(VRCharType.ONLY_DIGIT);

      providerStaffCareManagerNo.setMaxLength(8);

      addProviderStaffCareManagerNo();
    }
    return providerStaffCareManagerNo;

  }

  /**
   * 支援専門員番号コンテナを取得します。
   * @return 支援専門員番号コンテナ
   */
  protected ACLabelContainer getProviderStaffCareManagerNoContainer(){
    if(providerStaffCareManagerNoContainer==null){
      providerStaffCareManagerNoContainer = new ACLabelContainer();
      providerStaffCareManagerNoContainer.setFollowChildEnabled(true);
      providerStaffCareManagerNoContainer.setVAlignment(VRLayout.CENTER);
      providerStaffCareManagerNoContainer.add(getProviderStaffCareManagerNo(), null);
    }
    return providerStaffCareManagerNoContainer;
  }

  /**
   * 担当者・コンテナを取得します。
   * @return 担当者・コンテナ
   */
  public ACLabelContainer getProviderStaffNameContainer(){
    if(providerStaffNameContainer==null){

      providerStaffNameContainer = new ACLabelContainer();

      providerStaffNameContainer.setText("担当者");

      addProviderStaffNameContainer();
    }
    return providerStaffNameContainer;

  }

  /**
   * 姓・コンテナを取得します。
   * @return 姓・コンテナ
   */
  public ACBackLabelContainer getProviderStaffFamilyNameContainer(){
    if(providerStaffFamilyNameContainer==null){

      providerStaffFamilyNameContainer = new ACBackLabelContainer();

      providerStaffFamilyNameContainer.setText("姓");

      addProviderStaffFamilyNameContainer();
    }
    return providerStaffFamilyNameContainer;

  }

  /**
   * 担当者名（姓）を取得します。
   * @return 担当者名（姓）
   */
  public ACTextField getProviderStaffFamilyName(){
    if(providerStaffFamilyName==null){

      providerStaffFamilyName = new ACTextField();

      providerStaffFamilyName.setBindPath("STAFF_FAMILY_NAME");

      providerStaffFamilyName.setColumns(12);

      providerStaffFamilyName.setIMEMode(InputSubset.KANJI);

      providerStaffFamilyName.setMaxLength(16);

      addProviderStaffFamilyName();
    }
    return providerStaffFamilyName;

  }

  /**
   * 名・コンテナを取得します。
   * @return 名・コンテナ
   */
  public ACBackLabelContainer getProviderStaffFirstNameContainer(){
    if(providerStaffFirstNameContainer==null){

      providerStaffFirstNameContainer = new ACBackLabelContainer();

      providerStaffFirstNameContainer.setText("名");

      addProviderStaffFirstNameContainer();
    }
    return providerStaffFirstNameContainer;

  }

  /**
   * 担当者名（名）を取得します。
   * @return 担当者名（名）
   */
  public ACTextField getProviderStaffFirstName(){
    if(providerStaffFirstName==null){

      providerStaffFirstName = new ACTextField();

      providerStaffFirstName.setBindPath("STAFF_FIRST_NAME");

      providerStaffFirstName.setColumns(12);

      providerStaffFirstName.setIMEMode(InputSubset.KANJI);

      providerStaffFirstName.setMaxLength(16);

      addProviderStaffFirstName();
    }
    return providerStaffFirstName;

  }

  /**
   * 操作領域を取得します。
   * @return 操作領域
   */
  public ACPanel getProviderStaffTableControlPanel(){
    if(providerStaffTableControlPanel==null){

      providerStaffTableControlPanel = new ACPanel();

      addProviderStaffTableControlPanel();
    }
    return providerStaffTableControlPanel;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getProviderStaffInsert(){
    if(providerStaffInsert==null){

      providerStaffInsert = new ACButton();

      providerStaffInsert.setText("追加");

      providerStaffInsert.setToolTipText("担当者を追加します。");

      addProviderStaffInsert();
    }
    return providerStaffInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getProviderStaffFind(){
    if(providerStaffFind==null){

      providerStaffFind = new ACButton();

      providerStaffFind.setText("書替");

      providerStaffFind.setToolTipText("選択中の担当者を編集します。");

      addProviderStaffFind();
    }
    return providerStaffFind;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getProviderStaffDelete(){
    if(providerStaffDelete==null){

      providerStaffDelete = new ACButton();

      providerStaffDelete.setText("削除");

      providerStaffDelete.setToolTipText("選択中の担当者を削除します。");

      addProviderStaffDelete();
    }
    return providerStaffDelete;

  }

  /**
   * サービス種類詳細情報領域を取得します。
   * @return サービス種類詳細情報領域
   */
  public ACPanel getProviderDetailServiceDetails(){
    if(providerDetailServiceDetails==null){

      providerDetailServiceDetails = new ACPanel();

      providerDetailServiceDetails.setFollowChildEnabled(true);

      addProviderDetailServiceDetails();
    }
    return providerDetailServiceDetails;

  }

  /**
   * 説明文グループを取得します。
   * @return 説明文グループ
   */
  public ACGroupBox getExplanationTitleGroup(){
    if(explanationTitleGroup==null){

      explanationTitleGroup = new ACGroupBox();

      addExplanationTitleGroup();
    }
    return explanationTitleGroup;

  }

  /**
   * 説明文ラベル・タイトルを取得します。
   * @return 説明文ラベル・タイトル
   */
  public ACLabel getExplanationTitleLabel(){
    if(explanationTitleLabel==null){

      explanationTitleLabel = new ACLabel();

      explanationTitleLabel.setText("提供サービスの設定方法");

      explanationTitleLabel.setIconPath(ACConstants.ICON_PATH_INFORMATION_48);

      addExplanationTitleLabel();
    }
    return explanationTitleLabel;

  }

  /**
   * 説明文ラベル・内容1を取得します。
   * @return 説明文ラベル・内容1
   */
  public ACLabel getExplanationContentLabel1(){
    if(explanationContentLabel1==null){

      explanationContentLabel1 = new ACLabel();

      explanationContentLabel1.setText("　注意：提供サービスを選択すると、この注意書きは非表示になります。");

      addExplanationContentLabel1();
    }
    return explanationContentLabel1;

  }

  /**
   * 説明文ラベル・内容2を取得します。
   * @return 説明文ラベル・内容2
   */
  public ACLabel getExplanationContentLabe2(){
    if(explanationContentLabe2==null){

      explanationContentLabe2 = new ACLabel();

      explanationContentLabe2.setText("　1．画面左の提供サービス一覧から、提供しているサービスを選択してください。");

      addExplanationContentLabe2();
    }
    return explanationContentLabe2;

  }

  /**
   * 説明文ラベル・内容3を取得します。
   * @return 説明文ラベル・内容3
   */
  public ACLabel getExplanationContentLabe3(){
    if(explanationContentLabe3==null){

      explanationContentLabe3 = new ACLabel();

      explanationContentLabe3.setText("　2．「提供する」にチェックをつけ、各項目を選択してください。");

      addExplanationContentLabe3();
    }
    return explanationContentLabe3;

  }

  /**
   * 説明文ラベル・内容4を取得します。
   * @return 説明文ラベル・内容4
   */
  public ACLabel getExplanationContentLabel4(){
    if(explanationContentLabel4==null){

      explanationContentLabel4 = new ACLabel();

      explanationContentLabel4.setText("　3．最後に「反映」ボタンを押して設定完了となります。");

      addExplanationContentLabel4();
    }
    return explanationContentLabel4;

  }

  /**
   * コンストラクタです。
   */
  public QO004Design() {

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

    this.add(getProviderContents(), VRLayout.CLIENT);

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
   * 事業所情報領域に内部項目を追加します。
   */
  protected void addProviderContents(){

    providerContents.add(getProviderMainContents(), VRLayout.NORTH);

    providerContents.add(getProviderSubContents(), VRLayout.WEST);

    providerContents.add(getProviderDetailServiceDetails(), VRLayout.CLIENT);

  }

  /**
   * 事業所メイン情報領域に内部項目を追加します。
   */
  protected void addProviderMainContents(){

    providerMainContents.add(getProviderIdContainer(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainContents.add(getProviderPostnoContena(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainContents.add(getProviderTelContena(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderFaxContena(), VRLayout.FLOW);

    providerMainContents.add(getProviderEstablishNameContainer(), VRLayout.FLOW_RETURN);

    providerMainContents.add(getProviderMainContentDivisionContainer(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderMainContentBusinessContainer(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getMedical(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainContents.add(getProviderMainContentRegionContainer(), VRLayout.FLOW);

    providerMainContents.add(getLankSpecialArea(), VRLayout.FLOW);

  }

  /**
   * 事業所メイン情報領域レイアウトに内部項目を追加します。
   */
  protected void addProviderMainContentsLayout(){

  }

  /**
   * 事業所番号に内部項目を追加します。
   */
  protected void addProviderId(){

  }

  /**
   * 事業所名称に内部項目を追加します。
   */
  protected void addProviderName(){

  }

  /**
   * 郵便番号コンテナに内部項目を追加します。
   */
  protected void addProviderPostnoContena(){

    providerPostnoContena.add(getProviderPostnoOn(), null);

    providerPostnoContena.add(getProviderPostnoHyphen(), null);

    providerPostnoContena.add(getProviderPostnoUnder(), null);

  }

  /**
   * 郵便番号（上に内部項目を追加します。
   */
  protected void addProviderPostnoOn(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addProviderPostnoHyphen(){

  }

  /**
   * 郵便番号（下に内部項目を追加します。
   */
  protected void addProviderPostnoUnder(){

  }

  /**
   * 所在地に内部項目を追加します。
   */
  protected void addProviderAddress(){

  }

  /**
   * 電話番号コンテナに内部項目を追加します。
   */
  protected void addProviderTelContena(){

    providerTelContena.add(getProviderTelOn(), null);

    providerTelContena.add(getProviderTelHyphen1(), null);

    providerTelContena.add(getProviderTelInside(), null);

    providerTelContena.add(getProviderTelHyphen2(), null);

    providerTelContena.add(getProviderTelUnder(), null);

  }

  /**
   * 電話番号（上に内部項目を追加します。
   */
  protected void addProviderTelOn(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addProviderTelHyphen1(){

  }

  /**
   * 電話番号（中に内部項目を追加します。
   */
  protected void addProviderTelInside(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addProviderTelHyphen2(){

  }

  /**
   * 電話番号（下に内部項目を追加します。
   */
  protected void addProviderTelUnder(){

  }

  /**
   * FAX番号コンテナに内部項目を追加します。
   */
  protected void addProviderFaxContena(){

    providerFaxContena.add(getProviderFaxOn(), null);

    providerFaxContena.add(getProviderFaxHyphen1(), null);

    providerFaxContena.add(getProviderFaxInside(), null);

    providerFaxContena.add(getProviderFaxHyphen2(), null);

    providerFaxContena.add(getProviderFaxUnder(), null);

  }

  /**
   * FAX（上に内部項目を追加します。
   */
  protected void addProviderFaxOn(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addProviderFaxHyphen1(){

  }

  /**
   * FAX（中に内部項目を追加します。
   */
  protected void addProviderFaxInside(){

  }

  /**
   * ハイフンに内部項目を追加します。
   */
  protected void addProviderFaxHyphen2(){

  }

  /**
   * FAX（下に内部項目を追加します。
   */
  protected void addProviderFaxUnder(){

  }

  /**
   * 管理者に内部項目を追加します。
   */
  protected void addProviderEstablishName(){

  }

  /**
   * 自事業所区分ラジオグループに内部項目を追加します。
   */
  protected void addProviderMainContentDivision(){

  }

  /**
   * 自事業所区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addProviderMainContentDivisionModel(){

    getProviderMainContentDivisionMine().setButtonIndex(1);

    getProviderMainContentDivisionModel().add(getProviderMainContentDivisionMine());

    getProviderMainContentDivisionOther().setButtonIndex(2);

    getProviderMainContentDivisionModel().add(getProviderMainContentDivisionOther());

  }

  /**
   * 自事業所に内部項目を追加します。
   */
  protected void addProviderMainContentDivisionMine(){

  }

  /**
   * 他事業所に内部項目を追加します。
   */
  protected void addProviderMainContentDivisionOther(){

  }

  /**
   * 事業区分ラジオグループに内部項目を追加します。
   */
  protected void addProviderMainContentBusiness(){

  }

  /**
   * 事業区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addProviderMainContentBusinessModel(){

    getProviderMainContentBusinessSpecification().setButtonIndex(1);

    getProviderMainContentBusinessModel().add(getProviderMainContentBusinessSpecification());

    getProviderMainContentBusinessStandard().setButtonIndex(2);

    getProviderMainContentBusinessModel().add(getProviderMainContentBusinessStandard());

    getProviderMainContentBusinessRegion().setButtonIndex(5);

    getProviderMainContentBusinessModel().add(getProviderMainContentBusinessRegion());

  }

  /**
   * 指定に内部項目を追加します。
   */
  protected void addProviderMainContentBusinessSpecification(){

  }

  /**
   * 基準該当に内部項目を追加します。
   */
  protected void addProviderMainContentBusinessStandard(){

  }

  /**
   * 地域密着に内部項目を追加します。
   */
  protected void addProviderMainContentBusinessRegion(){

  }

  /**
   * 医療機関に内部項目を追加します。
   */
  protected void addMedical(){

  }

  /**
   * 事業所種別に内部項目を追加します。
   */
  protected void addProviderType(){

  }

  /**
   * 事業所種別モデルに内部項目を追加します。
   */
  protected void addProviderTypeModel(){

  }

  /**
   * 地域区分ラジオグループに内部項目を追加します。
   */
  protected void addProviderMainContentRegion(){

  }

  /**
   * 地域区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addProviderMainContentRegionModel(){

    getProviderMainContentRegionLank1().setButtonIndex(1);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank1());

    getProviderMainContentRegionLank2().setButtonIndex(6);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank2());

    getProviderMainContentRegionLank3().setButtonIndex(7);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank3());

    getProviderMainContentRegionLank4().setButtonIndex(2);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank4());

    getProviderMainContentRegionLank5().setButtonIndex(3);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank5());

    getProviderMainContentRegionLank6().setButtonIndex(4);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank6());

    getProviderMainContentRegionLank7().setButtonIndex(9);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank7());

    getProviderMainContentRegionLank8().setButtonIndex(5);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank8());

  }

  /**
   * １級地に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank1(){

  }

  /**
   * ２級地に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank2(){

  }

  /**
   * ３級地に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank3(){

  }

  /**
   * ４級地に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank4(){

  }

  /**
   * ５級地に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank5(){

  }

  /**
   * ６級地に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank6(){

  }

  /**
   * ７級地に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank7(){

  }

  /**
   * その他に内部項目を追加します。
   */
  protected void addProviderMainContentRegionLank8(){

  }

  /**
   * 特別地域に内部項目を追加します。
   */
  protected void addLankSpecialArea(){

  }

  /**
   * 事業所サブ情報領域に内部項目を追加します。
   */
  protected void addProviderSubContents(){

    providerSubContents.add(getProviderDetailContents(), VRLayout.NORTH);

    providerSubContents.add(getClaimInfos(), VRLayout.NORTH);

    providerSubContents.add(getProviderMainContentChargesPanel(), VRLayout.NORTH);

  }

  /**
   * 事業所詳細情報領域に内部項目を追加します。
   */
  protected void addProviderDetailContents(){

    providerDetailContents.add(getProviderDetailServiceKinds(), VRLayout.CLIENT);

  }

  /**
   * 事業所詳細情報サービスリスト領域に内部項目を追加します。
   */
  protected void addProviderDetailServiceKinds(){

    providerDetailServiceKinds.add(getServiceKindOffer(), VRLayout.NORTH);

  }

  /**
   * 提供サービスに内部項目を追加します。
   */
  protected void addServiceKindOffer(){

    serviceKindOffer.add(getServiceKindTablePanel(), VRLayout.NORTH);

  }

  /**
   * 提供サービステーブル領域に内部項目を追加します。
   */
  protected void addServiceKindTablePanel(){

    serviceKindTablePanel.add(getServiceKindTable(), VRLayout.CLIENT);

    serviceKindTablePanel.add(getButtonsPanel(), VRLayout.EAST);
  }

  /**
   * 提供サービステーブルに内部項目を追加します。
   */
  protected void addServiceKindTable(){

  }

  /**
   * 提供サービステーブルカラムモデルに内部項目を追加します。
   */
  protected void addServiceKindTableColumnModel(){

    getServiceKindTableColumnModel().addColumn(getServiceKindTableColum1());

    getServiceKindTableColumnModel().addColumn(getServiceKindTableColum2());

  }

  /**
   * 提供に内部項目を追加します。
   */
  protected void addServiceKindTableColum1(){

  }

  /**
   * 提供サービスに内部項目を追加します。
   */
  protected void addServiceKindTableColum2(){

  }

  /**
   * ボタンパネルに内部項目を追加します。
   */
  protected void addButtonsPanel(){

    buttonsPanel.add(getOfferCheck(), VRLayout.FLOW_RETURN);

    buttonsPanel.add(getReflection(), VRLayout.FLOW);

  }

  /**
   * 提供チェックに内部項目を追加します。
   */
  protected void addOfferCheck(){

  }

  /**
   * 反映に内部項目を追加します。
   */
  protected void addReflection(){

  }

  /**
   * 請求関連情報領域に内部項目を追加します。
   */
  protected void addClaimInfos(){

    claimInfos.add(getBankNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getBankBranchNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getAccountNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getAccountTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getAccountHolderContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 振込先金融機関名に内部項目を追加します。
   */
  protected void addBankName(){

  }

  /**
   * 振込先金融機関支店名に内部項目を追加します。
   */
  protected void addBankBranchName(){

  }

  /**
   * 振込先口座番号に内部項目を追加します。
   */
  protected void addAccountNumber(){

  }

  /**
   * 振込先口座種類に内部項目を追加します。
   */
  protected void addAccountTypeRadio(){

  }

  /**
   * 振込先口座種類モデルに内部項目を追加します。
   */
  protected void addAccountTypeRadioModel(){

    getAccountTypeRadioItem1().setButtonIndex(1);

    getAccountTypeRadioModel().add(getAccountTypeRadioItem1());

    getAccountTypeRadioItem2().setButtonIndex(2);

    getAccountTypeRadioModel().add(getAccountTypeRadioItem2());

  }

  /**
   * 普通に内部項目を追加します。
   */
  protected void addAccountTypeRadioItem1(){

  }

  /**
   * 当座に内部項目を追加します。
   */
  protected void addAccountTypeRadioItem2(){

  }

  /**
   * 振込先名義人に内部項目を追加します。
   */
  protected void addAccountHolder(){

  }

  /**
   * 担当者領域に内部項目を追加します。
   */
  protected void addProviderMainContentChargesPanel(){

    providerMainContentChargesPanel.add(getProviderStaffGroup(), VRLayout.CLIENT);

  }

  /**
   * 担当者グループに内部項目を追加します。
   */
  protected void addProviderStaffGroup(){

    providerStaffGroup.add(getProviderStaffTablePanel(), VRLayout.NORTH);

    providerStaffGroup.add(getProviderStaffInputPanel(), VRLayout.NORTH);

    providerStaffGroup.add(getProviderStaffTableControlPanel(), VRLayout.SOUTH);
  }

  /**
   * 担当者テーブル領域に内部項目を追加します。
   */
  protected void addProviderStaffTablePanel(){

    providerStaffTablePanel.add(getProviderStaffTable(), VRLayout.CLIENT);

  }

  /**
   * 担当者テーブルに内部項目を追加します。
   */
  protected void addProviderStaffTable(){

  }

  /**
   * 担当者テーブルカラムモデルに内部項目を追加します。
   */
  protected void addProviderStaffTableColumnModel(){

    getProviderStaffTableColumnModel().addColumn(getProviderStaffTableColumn1());

    getProviderStaffTableColumnModel().addColumn(getProviderStaffTableColumn2());

    getProviderStaffTableColumnModel().addColumn(getProviderStaffTableColumn3());

  }

  /**
   * Noに内部項目を追加します。
   */
  protected void addProviderStaffTableColumn1(){

  }

  /**
   * 支援専門員番号に内部項目を追加します。
   */
  protected void addProviderStaffTableColumn2(){

  }

  /**
   * 担当者名に内部項目を追加します。
   */
  protected void addProviderStaffTableColumn3(){

  }

  /**
   * 担当者入力領域に内部項目を追加します。
   */
  protected void addProviderStaffInputPanel(){

    providerStaffInputPanel.add(getProviderStaffCareManagerNoContainer(), VRLayout.FLOW_RETURN);

    providerStaffInputPanel.add(getProviderStaffNameContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * 支援専門員番号に内部項目を追加します。
   */
  protected void addProviderStaffCareManagerNo(){

  }

  /**
   * 担当者・コンテナに内部項目を追加します。
   */
  protected void addProviderStaffNameContainer(){

    providerStaffNameContainer.add(getProviderStaffFamilyNameContainer(), VRLayout.FLOW);

    providerStaffNameContainer.add(getProviderStaffFirstNameContainer(), VRLayout.FLOW);

  }

  /**
   * 姓・コンテナに内部項目を追加します。
   */
  protected void addProviderStaffFamilyNameContainer(){

    providerStaffFamilyNameContainer.add(getProviderStaffFamilyName(), VRLayout.FLOW);

  }

  /**
   * 担当者名（姓）に内部項目を追加します。
   */
  protected void addProviderStaffFamilyName(){

  }

  /**
   * 名・コンテナに内部項目を追加します。
   */
  protected void addProviderStaffFirstNameContainer(){

    providerStaffFirstNameContainer.add(getProviderStaffFirstName(), VRLayout.FLOW);

  }

  /**
   * 担当者名（名）に内部項目を追加します。
   */
  protected void addProviderStaffFirstName(){

  }

  /**
   * 操作領域に内部項目を追加します。
   */
  protected void addProviderStaffTableControlPanel(){

    providerStaffTableControlPanel.add(getProviderStaffDelete(), VRLayout.EAST);
    providerStaffTableControlPanel.add(getProviderStaffFind(), VRLayout.EAST);
    providerStaffTableControlPanel.add(getProviderStaffInsert(), VRLayout.EAST);
  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addProviderStaffInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addProviderStaffFind(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addProviderStaffDelete(){

  }

  /**
   * サービス種類詳細情報領域に内部項目を追加します。
   */
  protected void addProviderDetailServiceDetails(){

    providerDetailServiceDetails.add(getExplanationTitleGroup(), VRLayout.CLIENT);

  }

  /**
   * 説明文グループに内部項目を追加します。
   */
  protected void addExplanationTitleGroup(){

    explanationTitleGroup.add(getExplanationTitleLabel(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabel1(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabe2(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabe3(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabel4(), VRLayout.NORTH);

  }

  /**
   * 説明文ラベル・タイトルに内部項目を追加します。
   */
  protected void addExplanationTitleLabel(){

  }

  /**
   * 説明文ラベル・内容1に内部項目を追加します。
   */
  protected void addExplanationContentLabel1(){

  }

  /**
   * 説明文ラベル・内容2に内部項目を追加します。
   */
  protected void addExplanationContentLabe2(){

  }

  /**
   * 説明文ラベル・内容3に内部項目を追加します。
   */
  protected void addExplanationContentLabe3(){

  }

  /**
   * 説明文ラベル・内容4に内部項目を追加します。
   */
  protected void addExplanationContentLabel4(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004Design getThis() {
    return this;
  }
}
