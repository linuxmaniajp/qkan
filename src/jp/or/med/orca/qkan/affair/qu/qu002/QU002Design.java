
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
 * 開発者: 樋口雅彦
 * 作成日: 2011/12/19  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者登録/修正 (U)
 * プロセス 利用者登録 (002)
 * プログラム 利用者登録 (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACKanaSendTextField;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * 利用者登録画面項目デザイン(QU002) 
 */
@SuppressWarnings("serial")
public class QU002Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton clearInsertMode;

  private ACAffairButton clearUpdateMode;

  private ACPanel contents;

  private VRLayout contentsLayout;

  private ACPanel basicInfoAndInfoButtons;

  private ACGroupBox basicInfoAndInfoButtonFlame;

  private VRLayout basicInfoAndInfoButtonLayout;

  private ACPanel basicInfoAndInfoButton;

  private VRLayout basicInfoLayout;

  private ACTextField basicInfoPatientCd;

  private ACLabelContainer basicInfoPatientCdContainer;

  private ACClearableRadioButtonGroup basicInfoSexs;

  private ACLabelContainer basicInfoSexsContainer;

  private ACListModelAdapter basicInfoSexsModel;

  private ACRadioButtonItem basicInfoMan;

  private ACRadioButtonItem basicInfoWoman;

  private ACIntegerCheckBox basicInfoCheck;

  private ACLabelContainer basicInfoNameContena;

  private ACBackLabelContainer basicInfoFamilyNameContena;

  private ACKanaSendTextField basicInfoName1;

  private ACBackLabelContainer basicInfoFirstNameContena;

  private ACKanaSendTextField basicInfoName2;

  private ACLabelContainer basicInfoBirthContena;

  private QkanDateTextField basicInfoBirth;

  private ACLabel basicInfoAgeLabel1;

  private ACTextField basicInfoAge;

  private ACLabel basicInfoAgeLabel2;

  private ACLabelContainer basicInfoFuriganaContena;

  private ACBackLabelContainer basicInfoFamilyFuriganaContena;

  private ACTextField basicInfoFurigana1;

  private ACBackLabelContainer basicInfoFirstFuriganaContena;

  private ACTextField basicInfoFurigana2;

  private ACLabelContainer basicInfoTelContena;

  private ACTextField basicInfoTel2;

  private ACLabel basicInfoTel3;

  private ACTextField basicInfoTel4;

  private ACLabel basicInfoTel5;

  private ACTextField basicInfoTel6;

  private ACLabelContainer basicInfoZips;

  private ACTextField basicInfoZip1;

  private ACLabel basicInfoZip2;

  private ACTextField basicInfoZip3;

  private ACTextField basicInfoAddress;

  private ACLabelContainer basicInfoAddressContainer;

  private ACPanel infoButtons;

  private ACButton toKohiInfoButton;

  private JTabbedPane tabs;

  private ACPanel kaigoInfoAndIdouInfos;

  private ACGroupBox kaigoInfos;

  private VRLayout kaigoInfoLayout;

  private ACPanel kaigoInfoRyo;

  private ACPanel kaigoInfo;

  private VRLayout kaigoInfoLayout2;

  private ACTextField kaigoInfoInsurerId;

  private ACLabelContainer kaigoInfoInsurerIdContainer;

  private ACComboBox kaigoInfoInsurerName;

  private ACLabelContainer kaigoInfoInsurerNameContainer;

  private ACComboBoxModelAdapter kaigoInfoInsurerNameModel;

  private ACTextField yokaigodoNow;

  private ACLabelContainer yokaigodoNowContainer;

  private ACTextField kaigoInfoInsuredId;

  private ACLabelContainer kaigoInfoInsuredIdContainer;

  private ACLabelContainer kaigoInfoBenefitContainer;

  private ACTextField kaigoInfoBenefit;

  private ACLabel kaigoInfoBenefitPercent;

  private ACLabelContainer kaigoInfoKyotakuServiceContena;

  private VRLayout kaigoInfoKyotakuServiceContenaLayout;

  private ACClearableRadioButtonGroup kaigoInfoKyotakuServiceRadio;

  private ACListModelAdapter kaigoInfoKyotakuServiceRadioModel;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem1;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem2;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem3;

  private ACComboBox kaigoInfoKyotakuServicePlanCombo;

  private ACComboBoxModelAdapter kaigoInfoKyotakuServicePlanComboModel;

  private QkanDateTextField kaigoInfoReportDate;

  private ACLabelContainer kaigoInfoReportDateContainer;

  private ACLabelContainer kaigoInfoRequestDivisionContena;

  private ACClearableRadioButtonGroup kaigoInfoRequestDivisionRadio;

  private ACListModelAdapter kaigoInfoRequestDivisionRadioModel;

  private ACRadioButtonItem kaigoInfoRequestDivisionRadioItem1;

  private ACRadioButtonItem kaigoInfoRequestDivisionRadioItem2;

  private ACRadioButtonItem kaigoInfoRequestDivisionRadioItem3;

  private ACIntegerCheckBox kaigoInfoRequests;

  private ACComboBox kaigoInfoYokaigoInfo;

  private ACLabelContainer kaigoInfoYokaigoInfoContainer;

  private ACComboBoxModelAdapter kaigoInfoYokaigoInfoModel;

  private ACLabelContainer kaigoInfoValidLimits;

  private QkanDateTextField kaigoInfoValidLimit1;

  private ACLabel kaigoInfoValidLimit2;

  private QkanDateTextField kaigoInfoValidLimit3;

  private QkanDateTextField kaigoInfoRequestDate;

  private ACLabelContainer kaigoInfoRequestDateContainer;

  private QkanDateTextField kaigoInfoAuthorizeDate;

  private ACLabelContainer kaigoInfoAuthorizeDateContainer;

  private ACGroupBox kaigoInfoProvideLimitGroup;

  private ACLabelContainer kaigoInfoProvideLimitContena;

  private ACTextField kaigoInfoProvideLimit;

  private ACLabel kaigoInfoProvideLimitLabel;

  private ACLabelContainer kaigoInfoExternalUseLimitContena;

  private ACTextField kaigoInfoExternalUseLimit;

  private ACLabel kaigoInfoExternalUseLimitLabel;

  private ACGroupBox kaigoInfoInterruptionGroup;

  private QkanDateTextField kaigoInfoInterruptionDate;

  private ACLabelContainer kaigoInfoInterruptionDateContainer;

  private ACClearableRadioButtonGroup kaigoInfoInterruptionReasonRadio;

  private ACLabelContainer kaigoInfoInterruptionReasonRadioContainer;

  private ACListModelAdapter kaigoInfoInterruptionReasonRadioModel;

  private ACRadioButtonItem kaigoInfoInterruptionReasonRadioItem1;

  private ACRadioButtonItem kaigoInfoInterruptionReasonRadioItem2;

  private ACRadioButtonItem kaigoInfoInterruptionReasonRadioItem3;

  private ACLabel kaigoInfoExplanationLabel1;

  private ACPanel kaigoInfoButtons;

  private ACButton kaigoInfoButtonClear;

  private ACButton kaigoInfoButtonInsert;

  private ACButton kaigoInfoButtonEdit;

  private ACButton kaigoInfoDelete;

  private ACTable kaigoInfoTable;

  private VRTableColumnModel kaigoInfoTableColumnModel;

  private ACTableColumn kaigoInfoTableColumn0;

  private ACTableColumn kaigoInfoTableColumn1;

  private ACTableColumn kaigoInfoTableColumn2;

  private ACTableColumn kaigoInfoTableColumn3;

  private ACTableColumn kaigoInfoTableColumn4;

  private ACTableColumn kaigoInfoTableColumn5;

  private ACTableColumn kaigoInfoTableColumn6;

  private ACTableColumn kaigoInfoTableColumn7;

  private ACTableColumn kaigoInfoTableColumn8;

  private ACTableColumn kaigoInfoTableColumn9;

  private ACPanel idouInfoAndInstitutionInfoPanel;

  private ACGroupBox idouInfoAndInstitutionInfos;

  private VRLayout idouInfoAndInstitutionInfoLayout;

  private ACPanel idouInfoUp;

  private ACPanel idouInfo;

  private VRLayout idouInfoLayout2;

  private ACComboBox idouInfoServise;

  private ACLabelContainer idouInfoServiseContainer;

  private ACComboBoxModelAdapter idouInfoServiseModel;

  private ACComboBox idouInfoChangeContent;

  private ACLabelContainer idouInfoChangeContentContainer;

  private ACComboBoxModelAdapter idouInfoChangeContentModel;

  private QkanDateTextField idouInfoDate;

  private ACLabelContainer idouInfoDateContainer;

  private ACTimeTextField idouInfoTime;

  private ACLabelContainer idouInfoTimeContainer;

  private ACComboBox idouInfoReason;

  private ACLabelContainer idouInfoReasonContainer;

  private ACComboBoxModelAdapter idouInfoReasonModel;

  private ACTextField idouInfoReasonMemo;

  private ACLabelContainer idouInfoReasonMemoContainer;

  private ACPanel idouInfoButtons;

  private ACButton idouInfoButtonClear;

  private ACButton idouInfoButtonInsert;

  private ACButton idouInfoButtonEdit;

  private ACButton idouInfoButtonDelete;

  private ACTable idouInfoTable;

  private VRTableColumnModel idouInfoTableColumnModel;

  private ACTableColumn idouInfoTableColumn0;

  private ACTableColumn idouInfoTableColumn1;

  private ACTableColumn idouInfoTableColumn2;

  private ACTableColumn idouInfoTableColumn3;

  private ACTableColumn idouInfoTableColumn4;

  private ACTableColumn idouInfoTableColumn5;

  private ACGroupBox institutionInfos;

  private VRLayout institutionInfoLayout;

  private ACLabel institutionInfoBearMoneyInfos;

  private ACLabel institutionInfoSpace1;

  private ACIntegerCheckBox institutionInfoTokuteiNyusho;

  private ACLabel institutionInfoSpace2;

  private ACLabelContainer institutionInfoDinnerBearLimitMoneyContena;

  private ACTextField institutionInfoDinnerBearLimitMoneyText;

  private ACLabel institutionInfoDinnerBearLimitMoneyLabel;

  private ACLabelContainer institutionInfoUnitRoomLimitMoneyContena;

  private ACTextField institutionInfoUnitRoomLimitMoneyText;

  private ACLabel institutionInfoUnitRoomLimitMoneyLabel;

  private ACLabelContainer institutionInfoUnitSemiRoomLimitMoneyContena;

  private ACTextField institutionInfoUnitSemiRoomLimitMoneyText;

  private ACLabel institutionInfoUnitSemiRoomLimitMoneyLabel;

  private ACLabelContainer institutionInfoNormalRoomLimitMoneyContena;

  private ACTextField institutionInfoNormalRoomLimitMoneyText;

  private ACLabel institutionInfoNormalRoomLimitMoneyLabel;

  private ACLabelContainer institutionInfoNormalRoomLimitMoneyContena2;

  private ACTextField institutionInfoNormalRoomLimitMoneyText2;

  private ACLabel institutionInfoNormalRoomLimitMoneyLabel2;

  private ACLabelContainer institutionInfoTasyoRoomLimitMoneyContena;

  private ACTextField institutionInfoTasyoRoomLimitMoneyText;

  private ACLabel institutionInfoTasyoRoomLimitMoneyLabel;

  private ACLabel institutionInfoCareOldPersonLabel;

  private ACLabel institutionInfoSpace3;

  private ACIntegerCheckBox institutionInfoOldStep;

  private ACLabel institutionInfoCareOldPersonInsuranceLabel;

  private ACLabel institutionInfoSpace4;

  private ACTextField institutionInfoMainDisease;

  private ACLabelContainer institutionInfoMainDiseaseContainer;

  private ACLabel institutionInfoSpace5;

  private ACGroupBox institutionInfoExplanationGroup;

  private ACLabel institutionInfoExplanationLabel1;

  private ACLabel institutionInfoExplanationLabel2;

  private ACLabel institutionInfoExplanationLabel3;

  //getter

  /**
   * (業務ボタンバー)を取得します。
   * @return (業務ボタンバー)
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("利用者情報登録");

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
   * クリアを取得します。
   * @return クリア
   */
  public ACAffairButton getClearInsertMode(){
    if(clearInsertMode==null){

      clearInsertMode = new ACAffairButton();

      clearInsertMode.setText("クリア(C)");

      clearInsertMode.setToolTipText("利用者情報をクリアします。");

      clearInsertMode.setMnemonic('C');

      clearInsertMode.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClearInsertMode();
    }
    return clearInsertMode;

  }

  /**
   * 新規を取得します。
   * @return 新規
   */
  public ACAffairButton getClearUpdateMode(){
    if(clearUpdateMode==null){

      clearUpdateMode = new ACAffairButton();

      clearUpdateMode.setText("新規(N)");

      clearUpdateMode.setToolTipText("利用者情報の新規登録を行います。");

      clearUpdateMode.setMnemonic('N');

      clearUpdateMode.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addClearUpdateMode();
    }
    return clearUpdateMode;

  }

  /**
   * (クライアント領域)を取得します。
   * @return (クライアント領域)
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setLayout(getContentsLayout());

      addContents();
    }
    return contents;

  }

  /**
   * (クライアント領域・レイアウト)を取得します。
   * @return (クライアント領域・レイアウト)
   */
  public VRLayout getContentsLayout(){
    if(contentsLayout==null){

      contentsLayout = new VRLayout();

      contentsLayout.setAutoWrap(false);

      addContentsLayout();
    }
    return contentsLayout;

  }

  /**
   * (基本情報・ボタン領域)を取得します。
   * @return (基本情報・ボタン領域)
   */
  public ACPanel getBasicInfoAndInfoButtons(){
    if(basicInfoAndInfoButtons==null){

      basicInfoAndInfoButtons = new ACPanel();

      addBasicInfoAndInfoButtons();
    }
    return basicInfoAndInfoButtons;

  }

  /**
   * (基本情報・ボタン領域・グループ)を取得します。
   * @return (基本情報・ボタン領域・グループ)
   */
  public ACGroupBox getBasicInfoAndInfoButtonFlame(){
    if(basicInfoAndInfoButtonFlame==null){

      basicInfoAndInfoButtonFlame = new ACGroupBox();

      basicInfoAndInfoButtonFlame.setText("基本情報");

      basicInfoAndInfoButtonFlame.setLayout(getBasicInfoAndInfoButtonLayout());

      addBasicInfoAndInfoButtonFlame();
    }
    return basicInfoAndInfoButtonFlame;

  }

  /**
   * (基本情報・ボタンレイアウト)を取得します。
   * @return (基本情報・ボタンレイアウト)
   */
  public VRLayout getBasicInfoAndInfoButtonLayout(){
    if(basicInfoAndInfoButtonLayout==null){

      basicInfoAndInfoButtonLayout = new VRLayout();

      basicInfoAndInfoButtonLayout.setAutoWrap(false);

      addBasicInfoAndInfoButtonLayout();
    }
    return basicInfoAndInfoButtonLayout;

  }

  /**
   * (基本情報領域)を取得します。
   * @return (基本情報領域)
   */
  public ACPanel getBasicInfoAndInfoButton(){
    if(basicInfoAndInfoButton==null){

      basicInfoAndInfoButton = new ACPanel();

      basicInfoAndInfoButton.setLayout(getBasicInfoLayout());

      basicInfoAndInfoButton.setAutoWrap(false);

      addBasicInfoAndInfoButton();
    }
    return basicInfoAndInfoButton;

  }

  /**
   * (基本情報領域・レイアウト)を取得します。
   * @return (基本情報領域・レイアウト)
   */
  public VRLayout getBasicInfoLayout(){
    if(basicInfoLayout==null){

      basicInfoLayout = new VRLayout();

      basicInfoLayout.setAutoWrap(false);

      basicInfoLayout.setHgap(0);

      basicInfoLayout.setLabelMargin(0);

      addBasicInfoLayout();
    }
    return basicInfoLayout;

  }

  /**
   * 利用者Cdを取得します。
   * @return 利用者Cd
   */
  public ACTextField getBasicInfoPatientCd(){
    if(basicInfoPatientCd==null){

      basicInfoPatientCd = new ACTextField();

      getBasicInfoPatientCdContainer().setText("利用者コード");

      basicInfoPatientCd.setBindPath("PATIENT_CODE");

      basicInfoPatientCd.setColumns(15);

      basicInfoPatientCd.setCharType(VRCharType.ONLY_HALF_CHAR);

      basicInfoPatientCd.setMaxLength(16);

      addBasicInfoPatientCd();
    }
    return basicInfoPatientCd;

  }

  /**
   * 利用者Cdコンテナを取得します。
   * @return 利用者Cdコンテナ
   */
  protected ACLabelContainer getBasicInfoPatientCdContainer(){
    if(basicInfoPatientCdContainer==null){
      basicInfoPatientCdContainer = new ACLabelContainer();
      basicInfoPatientCdContainer.setFollowChildEnabled(true);
      basicInfoPatientCdContainer.setVAlignment(VRLayout.CENTER);
      basicInfoPatientCdContainer.add(getBasicInfoPatientCd(), null);
    }
    return basicInfoPatientCdContainer;
  }

  /**
   * 性別を取得します。
   * @return 性別
   */
  public ACClearableRadioButtonGroup getBasicInfoSexs(){
    if(basicInfoSexs==null){

      basicInfoSexs = new ACClearableRadioButtonGroup();

      getBasicInfoSexsContainer().setText("性別");

      basicInfoSexs.setBindPath("PATIENT_SEX");

      basicInfoSexs.setUseClearButton(false);

      basicInfoSexs.setModel(getBasicInfoSexsModel());

      addBasicInfoSexs();
    }
    return basicInfoSexs;

  }

  /**
   * 性別コンテナを取得します。
   * @return 性別コンテナ
   */
  protected ACLabelContainer getBasicInfoSexsContainer(){
    if(basicInfoSexsContainer==null){
      basicInfoSexsContainer = new ACLabelContainer();
      basicInfoSexsContainer.setFollowChildEnabled(true);
      basicInfoSexsContainer.setVAlignment(VRLayout.CENTER);
      basicInfoSexsContainer.add(getBasicInfoSexs(), null);
    }
    return basicInfoSexsContainer;
  }

  /**
   * 性別モデルを取得します。
   * @return 性別モデル
   */
  protected ACListModelAdapter getBasicInfoSexsModel(){
    if(basicInfoSexsModel==null){
      basicInfoSexsModel = new ACListModelAdapter();
      addBasicInfoSexsModel();
    }
    return basicInfoSexsModel;
  }

  /**
   * 男を取得します。
   * @return 男
   */
  public ACRadioButtonItem getBasicInfoMan(){
    if(basicInfoMan==null){

      basicInfoMan = new ACRadioButtonItem();

      basicInfoMan.setText("男");

      basicInfoMan.setGroup(getBasicInfoSexs());

      basicInfoMan.setConstraints(VRLayout.FLOW);

      addBasicInfoMan();
    }
    return basicInfoMan;

  }

  /**
   * 女を取得します。
   * @return 女
   */
  public ACRadioButtonItem getBasicInfoWoman(){
    if(basicInfoWoman==null){

      basicInfoWoman = new ACRadioButtonItem();

      basicInfoWoman.setText("女");

      basicInfoWoman.setGroup(getBasicInfoSexs());

      basicInfoWoman.setConstraints(VRLayout.FLOW);

      addBasicInfoWoman();
    }
    return basicInfoWoman;

  }

  /**
   * 一覧に表示・チェックを取得します。
   * @return 一覧に表示・チェック
   */
  public ACIntegerCheckBox getBasicInfoCheck(){
    if(basicInfoCheck==null){

      basicInfoCheck = new ACIntegerCheckBox();

      basicInfoCheck.setText("一覧に表示する");

      basicInfoCheck.setBindPath("SHOW_FLAG");

      addBasicInfoCheck();
    }
    return basicInfoCheck;

  }

  /**
   * (氏名・コンテナ)を取得します。
   * @return (氏名・コンテナ)
   */
  public ACLabelContainer getBasicInfoNameContena(){
    if(basicInfoNameContena==null){

      basicInfoNameContena = new ACLabelContainer();

      basicInfoNameContena.setText("氏名");

      addBasicInfoNameContena();
    }
    return basicInfoNameContena;

  }

  /**
   * (氏名1・背面コンテナ)を取得します。
   * @return (氏名1・背面コンテナ)
   */
  public ACBackLabelContainer getBasicInfoFamilyNameContena(){
    if(basicInfoFamilyNameContena==null){

      basicInfoFamilyNameContena = new ACBackLabelContainer();

      basicInfoFamilyNameContena.setText("姓");

      addBasicInfoFamilyNameContena();
    }
    return basicInfoFamilyNameContena;

  }

  /**
   * 氏名1を取得します。
   * @return 氏名1
   */
  public ACKanaSendTextField getBasicInfoName1(){
    if(basicInfoName1==null){

      basicInfoName1 = new ACKanaSendTextField();

      basicInfoName1.setBindPath("PATIENT_FAMILY_NAME");

      basicInfoName1.setColumns(16);

      basicInfoName1.setIMEMode(InputSubset.KANJI);

      basicInfoName1.setMaxLength(16);

      basicInfoName1.setKanaField(getBasicInfoFurigana1());

      addBasicInfoName1();
    }
    return basicInfoName1;

  }

  /**
   * (氏名2・背面コンテナ)を取得します。
   * @return (氏名2・背面コンテナ)
   */
  public ACBackLabelContainer getBasicInfoFirstNameContena(){
    if(basicInfoFirstNameContena==null){

      basicInfoFirstNameContena = new ACBackLabelContainer();

      basicInfoFirstNameContena.setText("名");

      addBasicInfoFirstNameContena();
    }
    return basicInfoFirstNameContena;

  }

  /**
   * 氏名2を取得します。
   * @return 氏名2
   */
  public ACKanaSendTextField getBasicInfoName2(){
    if(basicInfoName2==null){

      basicInfoName2 = new ACKanaSendTextField();

      basicInfoName2.setBindPath("PATIENT_FIRST_NAME");

      basicInfoName2.setColumns(16);

      basicInfoName2.setIMEMode(InputSubset.KANJI);

      basicInfoName2.setMaxLength(16);

      basicInfoName2.setKanaField(getBasicInfoFurigana2());

      addBasicInfoName2();
    }
    return basicInfoName2;

  }

  /**
   * (生年月日・コンテナ)を取得します。
   * @return (生年月日・コンテナ)
   */
  public ACLabelContainer getBasicInfoBirthContena(){
    if(basicInfoBirthContena==null){

      basicInfoBirthContena = new ACLabelContainer();

      basicInfoBirthContena.setText("生年月日");

      addBasicInfoBirthContena();
    }
    return basicInfoBirthContena;

  }

  /**
   * 生年月日を取得します。
   * @return 生年月日
   */
  public QkanDateTextField getBasicInfoBirth(){
    if(basicInfoBirth==null){

      basicInfoBirth = new QkanDateTextField();

      basicInfoBirth.setBindPath("PATIENT_BIRTHDAY");

      addBasicInfoBirth();
    }
    return basicInfoBirth;

  }

  /**
   * 年齢ラベルを取得します。
   * @return 年齢ラベル
   */
  public ACLabel getBasicInfoAgeLabel1(){
    if(basicInfoAgeLabel1==null){

      basicInfoAgeLabel1 = new ACLabel();

      basicInfoAgeLabel1.setText("　年齢");

      addBasicInfoAgeLabel1();
    }
    return basicInfoAgeLabel1;

  }

  /**
   * 年齢を取得します。
   * @return 年齢
   */
  public ACTextField getBasicInfoAge(){
    if(basicInfoAge==null){

      basicInfoAge = new ACTextField();

      basicInfoAge.setBindPath("PATIENT_BIRTHDAY");

      basicInfoAge.setEditable(false);

      basicInfoAge.setColumns(3);

      basicInfoAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      basicInfoAge.setHorizontalAlignment(SwingConstants.RIGHT);

      addBasicInfoAge();
    }
    return basicInfoAge;

  }

  /**
   * 歳ラベルを取得します。
   * @return 歳ラベル
   */
  public ACLabel getBasicInfoAgeLabel2(){
    if(basicInfoAgeLabel2==null){

      basicInfoAgeLabel2 = new ACLabel();

      basicInfoAgeLabel2.setText(" 歳");

      addBasicInfoAgeLabel2();
    }
    return basicInfoAgeLabel2;

  }

  /**
   * (フリガナ・コンテナ)を取得します。
   * @return (フリガナ・コンテナ)
   */
  public ACLabelContainer getBasicInfoFuriganaContena(){
    if(basicInfoFuriganaContena==null){

      basicInfoFuriganaContena = new ACLabelContainer();

      basicInfoFuriganaContena.setText("ふりがな");

      addBasicInfoFuriganaContena();
    }
    return basicInfoFuriganaContena;

  }

  /**
   * (フリガナ1・背面コンテナ)を取得します。
   * @return (フリガナ1・背面コンテナ)
   */
  public ACBackLabelContainer getBasicInfoFamilyFuriganaContena(){
    if(basicInfoFamilyFuriganaContena==null){

      basicInfoFamilyFuriganaContena = new ACBackLabelContainer();

      basicInfoFamilyFuriganaContena.setText("姓");

      addBasicInfoFamilyFuriganaContena();
    }
    return basicInfoFamilyFuriganaContena;

  }

  /**
   * フリガナ1を取得します。
   * @return フリガナ1
   */
  public ACTextField getBasicInfoFurigana1(){
    if(basicInfoFurigana1==null){

      basicInfoFurigana1 = new ACTextField();

      basicInfoFurigana1.setBindPath("PATIENT_FAMILY_KANA");

      basicInfoFurigana1.setColumns(16);

      basicInfoFurigana1.setIMEMode(InputSubset.KANJI);

      basicInfoFurigana1.setMaxLength(16);

      addBasicInfoFurigana1();
    }
    return basicInfoFurigana1;

  }

  /**
   * (フリガナ2・背面コンテナ)を取得します。
   * @return (フリガナ2・背面コンテナ)
   */
  public ACBackLabelContainer getBasicInfoFirstFuriganaContena(){
    if(basicInfoFirstFuriganaContena==null){

      basicInfoFirstFuriganaContena = new ACBackLabelContainer();

      basicInfoFirstFuriganaContena.setText("名");

      addBasicInfoFirstFuriganaContena();
    }
    return basicInfoFirstFuriganaContena;

  }

  /**
   * フリガナ2を取得します。
   * @return フリガナ2
   */
  public ACTextField getBasicInfoFurigana2(){
    if(basicInfoFurigana2==null){

      basicInfoFurigana2 = new ACTextField();

      basicInfoFurigana2.setBindPath("PATIENT_FIRST_KANA");

      basicInfoFurigana2.setColumns(16);

      basicInfoFurigana2.setIMEMode(InputSubset.KANJI);

      basicInfoFurigana2.setMaxLength(16);

      addBasicInfoFurigana2();
    }
    return basicInfoFurigana2;

  }

  /**
   * (電話番号・コンテナ)を取得します。
   * @return (電話番号・コンテナ)
   */
  public ACLabelContainer getBasicInfoTelContena(){
    if(basicInfoTelContena==null){

      basicInfoTelContena = new ACLabelContainer();

      basicInfoTelContena.setText("電話番号");

      addBasicInfoTelContena();
    }
    return basicInfoTelContena;

  }

  /**
   * 電話番号・テキスト1を取得します。
   * @return 電話番号・テキスト1
   */
  public ACTextField getBasicInfoTel2(){
    if(basicInfoTel2==null){

      basicInfoTel2 = new ACTextField();

      basicInfoTel2.setBindPath("PATIENT_TEL_FIRST");

      basicInfoTel2.setColumns(4);

      basicInfoTel2.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoTel2.setIMEMode(InputSubset.LATIN);

      basicInfoTel2.setMaxLength(6);

      addBasicInfoTel2();
    }
    return basicInfoTel2;

  }

  /**
   * 電話番号・ラベル1を取得します。
   * @return 電話番号・ラベル1
   */
  public ACLabel getBasicInfoTel3(){
    if(basicInfoTel3==null){

      basicInfoTel3 = new ACLabel();

      basicInfoTel3.setText("-");

      addBasicInfoTel3();
    }
    return basicInfoTel3;

  }

  /**
   * 電話番号・テキスト2を取得します。
   * @return 電話番号・テキスト2
   */
  public ACTextField getBasicInfoTel4(){
    if(basicInfoTel4==null){

      basicInfoTel4 = new ACTextField();

      basicInfoTel4.setBindPath("PATIENT_TEL_SECOND");

      basicInfoTel4.setColumns(4);

      basicInfoTel4.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoTel4.setIMEMode(InputSubset.LATIN);

      basicInfoTel4.setMaxLength(4);

      addBasicInfoTel4();
    }
    return basicInfoTel4;

  }

  /**
   * 電話番号・ラベル2を取得します。
   * @return 電話番号・ラベル2
   */
  public ACLabel getBasicInfoTel5(){
    if(basicInfoTel5==null){

      basicInfoTel5 = new ACLabel();

      basicInfoTel5.setText("-");

      addBasicInfoTel5();
    }
    return basicInfoTel5;

  }

  /**
   * 電話番号・テキスト3を取得します。
   * @return 電話番号・テキスト3
   */
  public ACTextField getBasicInfoTel6(){
    if(basicInfoTel6==null){

      basicInfoTel6 = new ACTextField();

      basicInfoTel6.setBindPath("PATIENT_TEL_THIRD");

      basicInfoTel6.setColumns(4);

      basicInfoTel6.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoTel6.setIMEMode(InputSubset.LATIN);

      basicInfoTel6.setMaxLength(4);

      addBasicInfoTel6();
    }
    return basicInfoTel6;

  }

  /**
   * (郵便番号・コンテナ)を取得します。
   * @return (郵便番号・コンテナ)
   */
  public ACLabelContainer getBasicInfoZips(){
    if(basicInfoZips==null){

      basicInfoZips = new ACLabelContainer();

      basicInfoZips.setText("郵便番号");

      addBasicInfoZips();
    }
    return basicInfoZips;

  }

  /**
   * 郵便番号テキスト1を取得します。
   * @return 郵便番号テキスト1
   */
  public ACTextField getBasicInfoZip1(){
    if(basicInfoZip1==null){

      basicInfoZip1 = new ACTextField();

      basicInfoZip1.setBindPath("PATIENT_ZIP_FIRST");

      basicInfoZip1.setColumns(4);

      basicInfoZip1.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoZip1.setIMEMode(InputSubset.LATIN);

      basicInfoZip1.setMaxLength(3);

      addBasicInfoZip1();
    }
    return basicInfoZip1;

  }

  /**
   * 郵便番号・ラベル1を取得します。
   * @return 郵便番号・ラベル1
   */
  public ACLabel getBasicInfoZip2(){
    if(basicInfoZip2==null){

      basicInfoZip2 = new ACLabel();

      basicInfoZip2.setText("-");

      addBasicInfoZip2();
    }
    return basicInfoZip2;

  }

  /**
   * 郵便番号テキスト2を取得します。
   * @return 郵便番号テキスト2
   */
  public ACTextField getBasicInfoZip3(){
    if(basicInfoZip3==null){

      basicInfoZip3 = new ACTextField();

      basicInfoZip3.setBindPath("PATIENT_ZIP_SECOND");

      basicInfoZip3.setColumns(4);

      basicInfoZip3.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoZip3.setIMEMode(InputSubset.LATIN);

      basicInfoZip3.setMaxLength(4);

      addBasicInfoZip3();
    }
    return basicInfoZip3;

  }

  /**
   * 住所を取得します。
   * @return 住所
   */
  public ACTextField getBasicInfoAddress(){
    if(basicInfoAddress==null){

      basicInfoAddress = new ACTextField();

      getBasicInfoAddressContainer().setText("住所");

      basicInfoAddress.setBindPath("PATIENT_ADDRESS");

      basicInfoAddress.setColumns(64);

      basicInfoAddress.setIMEMode(InputSubset.KANJI);

      basicInfoAddress.setMaxLength(64);

      addBasicInfoAddress();
    }
    return basicInfoAddress;

  }

  /**
   * 住所コンテナを取得します。
   * @return 住所コンテナ
   */
  protected ACLabelContainer getBasicInfoAddressContainer(){
    if(basicInfoAddressContainer==null){
      basicInfoAddressContainer = new ACLabelContainer();
      basicInfoAddressContainer.setFollowChildEnabled(true);
      basicInfoAddressContainer.setVAlignment(VRLayout.CENTER);
      basicInfoAddressContainer.add(getBasicInfoAddress(), null);
    }
    return basicInfoAddressContainer;
  }

  /**
   * (ボタン領域)を取得します。
   * @return (ボタン領域)
   */
  public ACPanel getInfoButtons(){
    if(infoButtons==null){

      infoButtons = new ACPanel();

      addInfoButtons();
    }
    return infoButtons;

  }

  /**
   * 公費・社福軽減情報を取得します。
   * @return 公費・社福軽減情報
   */
  public ACButton getToKohiInfoButton(){
    if(toKohiInfoButton==null){

      toKohiInfoButton = new ACButton();

      toKohiInfoButton.setText("公費・社福軽減情報");

      toKohiInfoButton.setToolTipText("公費・社福軽減情報画面に遷移します。");

      addToKohiInfoButton();
    }
    return toKohiInfoButton;

  }

  /**
   * (タブ)を取得します。
   * @return (タブ)
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * (介護保険情報・異動情報領域)を取得します。
   * @return (介護保険情報・異動情報領域)
   */
  public ACPanel getKaigoInfoAndIdouInfos(){
    if(kaigoInfoAndIdouInfos==null){

      kaigoInfoAndIdouInfos = new ACPanel();

      addKaigoInfoAndIdouInfos();
    }
    return kaigoInfoAndIdouInfos;

  }

  /**
   * (介護保険情報領域)を取得します。
   * @return (介護保険情報領域)
   */
  public ACGroupBox getKaigoInfos(){
    if(kaigoInfos==null){

      kaigoInfos = new ACGroupBox();

      kaigoInfos.setText("介護保険情報");

      kaigoInfos.setLayout(getKaigoInfoLayout());

      addKaigoInfos();
    }
    return kaigoInfos;

  }

  /**
   * (介護保険情報領域・レイアウト)を取得します。
   * @return (介護保険情報領域・レイアウト)
   */
  public VRLayout getKaigoInfoLayout(){
    if(kaigoInfoLayout==null){

      kaigoInfoLayout = new VRLayout();

      kaigoInfoLayout.setAutoWrap(false);

      kaigoInfoLayout.setHgap(0);

      kaigoInfoLayout.setLabelMargin(0);

      addKaigoInfoLayout();
    }
    return kaigoInfoLayout;

  }

  /**
   * (介護保険領域)を取得します。
   * @return (介護保険領域)
   */
  public ACPanel getKaigoInfoRyo(){
    if(kaigoInfoRyo==null){

      kaigoInfoRyo = new ACPanel();

      addKaigoInfoRyo();
    }
    return kaigoInfoRyo;

  }

  /**
   * (介護保険領域)を取得します。
   * @return (介護保険領域)
   */
  public ACPanel getKaigoInfo(){
    if(kaigoInfo==null){

      kaigoInfo = new ACPanel();

      kaigoInfo.setLayout(getKaigoInfoLayout2());

      addKaigoInfo();
    }
    return kaigoInfo;

  }

  /**
   * (介護保険領域・レイアウト)を取得します。
   * @return (介護保険領域・レイアウト)
   */
  public VRLayout getKaigoInfoLayout2(){
    if(kaigoInfoLayout2==null){

      kaigoInfoLayout2 = new VRLayout();

      kaigoInfoLayout2.setAutoWrap(false);

      kaigoInfoLayout2.setHgap(2);

      kaigoInfoLayout2.setHgrid(150);

      addKaigoInfoLayout2();
    }
    return kaigoInfoLayout2;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getKaigoInfoInsurerId(){
    if(kaigoInfoInsurerId==null){

      kaigoInfoInsurerId = new ACTextField();

      getKaigoInfoInsurerIdContainer().setText("保険者番号");

      kaigoInfoInsurerId.setBindPath("INSURER_ID");

      kaigoInfoInsurerId.setColumns(9);

      kaigoInfoInsurerId.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoInsurerId.setIMEMode(InputSubset.LATIN);

      kaigoInfoInsurerId.setMaxLength(6);

      addKaigoInfoInsurerId();
    }
    return kaigoInfoInsurerId;

  }

  /**
   * 保険者番号コンテナを取得します。
   * @return 保険者番号コンテナ
   */
  protected ACLabelContainer getKaigoInfoInsurerIdContainer(){
    if(kaigoInfoInsurerIdContainer==null){
      kaigoInfoInsurerIdContainer = new ACLabelContainer();
      kaigoInfoInsurerIdContainer.setFollowChildEnabled(true);
      kaigoInfoInsurerIdContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInsurerIdContainer.add(getKaigoInfoInsurerId(), null);
    }
    return kaigoInfoInsurerIdContainer;
  }

  /**
   * 保険者名を取得します。
   * @return 保険者名
   */
  public ACComboBox getKaigoInfoInsurerName(){
    if(kaigoInfoInsurerName==null){

      kaigoInfoInsurerName = new ACComboBox();

      getKaigoInfoInsurerNameContainer().setText("保険者名");

      kaigoInfoInsurerName.setBindPath("INSURER_ID");

      kaigoInfoInsurerName.setEditable(false);

      kaigoInfoInsurerName.setColumns(10);

      kaigoInfoInsurerName.setModelBindPath("INSURER");

      kaigoInfoInsurerName.setRenderBindPath("INSURER_NAME");

      kaigoInfoInsurerName.setMaxColumns(18);

      kaigoInfoInsurerName.setModel(getKaigoInfoInsurerNameModel());

      addKaigoInfoInsurerName();
    }
    return kaigoInfoInsurerName;

  }

  /**
   * 保険者名コンテナを取得します。
   * @return 保険者名コンテナ
   */
  protected ACLabelContainer getKaigoInfoInsurerNameContainer(){
    if(kaigoInfoInsurerNameContainer==null){
      kaigoInfoInsurerNameContainer = new ACLabelContainer();
      kaigoInfoInsurerNameContainer.setFollowChildEnabled(true);
      kaigoInfoInsurerNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInsurerNameContainer.add(getKaigoInfoInsurerName(), null);
    }
    return kaigoInfoInsurerNameContainer;
  }

  /**
   * 保険者名モデルを取得します。
   * @return 保険者名モデル
   */
  protected ACComboBoxModelAdapter getKaigoInfoInsurerNameModel(){
    if(kaigoInfoInsurerNameModel==null){
      kaigoInfoInsurerNameModel = new ACComboBoxModelAdapter();
      addKaigoInfoInsurerNameModel();
    }
    return kaigoInfoInsurerNameModel;
  }

  /**
   * 現在の要介護度を取得します。
   * @return 現在の要介護度
   */
  public ACTextField getYokaigodoNow(){
    if(yokaigodoNow==null){

      yokaigodoNow = new ACTextField();

      getYokaigodoNowContainer().setText("現在の要介護度");

      yokaigodoNow.setEditable(false);

      yokaigodoNow.setColumns(7);

      yokaigodoNow.setHorizontalAlignment(SwingConstants.CENTER);

      yokaigodoNow.setForeground(Color.BLUE);

      addYokaigodoNow();
    }
    return yokaigodoNow;

  }

  /**
   * 現在の要介護度コンテナを取得します。
   * @return 現在の要介護度コンテナ
   */
  protected ACLabelContainer getYokaigodoNowContainer(){
    if(yokaigodoNowContainer==null){
      yokaigodoNowContainer = new ACLabelContainer();
      yokaigodoNowContainer.setFollowChildEnabled(true);
      yokaigodoNowContainer.setVAlignment(VRLayout.CENTER);
      yokaigodoNowContainer.add(getYokaigodoNow(), null);
    }
    return yokaigodoNowContainer;
  }

  /**
   * 被保険者番号を取得します。
   * @return 被保険者番号
   */
  public ACTextField getKaigoInfoInsuredId(){
    if(kaigoInfoInsuredId==null){

      kaigoInfoInsuredId = new ACTextField();

      getKaigoInfoInsuredIdContainer().setText("被保険者番号");

      kaigoInfoInsuredId.setBindPath("INSURED_ID");

      kaigoInfoInsuredId.setColumns(9);

      kaigoInfoInsuredId.setCharType(VRCharType.ONLY_ALNUM);

      kaigoInfoInsuredId.setMaxLength(10);

      addKaigoInfoInsuredId();
    }
    return kaigoInfoInsuredId;

  }

  /**
   * 被保険者番号コンテナを取得します。
   * @return 被保険者番号コンテナ
   */
  protected ACLabelContainer getKaigoInfoInsuredIdContainer(){
    if(kaigoInfoInsuredIdContainer==null){
      kaigoInfoInsuredIdContainer = new ACLabelContainer();
      kaigoInfoInsuredIdContainer.setFollowChildEnabled(true);
      kaigoInfoInsuredIdContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInsuredIdContainer.add(getKaigoInfoInsuredId(), null);
    }
    return kaigoInfoInsuredIdContainer;
  }

  /**
   * (給付率領域・コンテナ)を取得します。
   * @return (給付率領域・コンテナ)
   */
  public ACLabelContainer getKaigoInfoBenefitContainer(){
    if(kaigoInfoBenefitContainer==null){

      kaigoInfoBenefitContainer = new ACLabelContainer();

      kaigoInfoBenefitContainer.setText("給付率");

      addKaigoInfoBenefitContainer();
    }
    return kaigoInfoBenefitContainer;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTextField getKaigoInfoBenefit(){
    if(kaigoInfoBenefit==null){

      kaigoInfoBenefit = new ACTextField();

      kaigoInfoBenefit.setBindPath("INSURE_RATE");

      kaigoInfoBenefit.setColumns(3);

      kaigoInfoBenefit.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoBenefit.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoBenefit.setMaxLength(3);

      addKaigoInfoBenefit();
    }
    return kaigoInfoBenefit;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getKaigoInfoBenefitPercent(){
    if(kaigoInfoBenefitPercent==null){

      kaigoInfoBenefitPercent = new ACLabel();

      kaigoInfoBenefitPercent.setText(" ％");

      addKaigoInfoBenefitPercent();
    }
    return kaigoInfoBenefitPercent;

  }

  /**
   * (居宅サービス計画作成者・コンテナ)を取得します。
   * @return (居宅サービス計画作成者・コンテナ)
   */
  public ACLabelContainer getKaigoInfoKyotakuServiceContena(){
    if(kaigoInfoKyotakuServiceContena==null){

      kaigoInfoKyotakuServiceContena = new ACLabelContainer();

      kaigoInfoKyotakuServiceContena.setText("居宅サービス計画作成者");

      kaigoInfoKyotakuServiceContena.setLayout(getKaigoInfoKyotakuServiceContenaLayout());

      addKaigoInfoKyotakuServiceContena();
    }
    return kaigoInfoKyotakuServiceContena;

  }

  /**
   * (居宅サービス計画作成者・コンテナ・レイアウト)を取得します。
   * @return (居宅サービス計画作成者・コンテナ・レイアウト)
   */
  public VRLayout getKaigoInfoKyotakuServiceContenaLayout(){
    if(kaigoInfoKyotakuServiceContenaLayout==null){

      kaigoInfoKyotakuServiceContenaLayout = new VRLayout();

      kaigoInfoKyotakuServiceContenaLayout.setAutoWrap(true);

      addKaigoInfoKyotakuServiceContenaLayout();
    }
    return kaigoInfoKyotakuServiceContenaLayout;

  }

  /**
   * 居宅サービス・ラジオグループを取得します。
   * @return 居宅サービス・ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoInfoKyotakuServiceRadio(){
    if(kaigoInfoKyotakuServiceRadio==null){

      kaigoInfoKyotakuServiceRadio = new ACClearableRadioButtonGroup();

      kaigoInfoKyotakuServiceRadio.setBindPath("PLANNER");

      kaigoInfoKyotakuServiceRadio.setUseClearButton(true);

      kaigoInfoKyotakuServiceRadio.setModel(getKaigoInfoKyotakuServiceRadioModel());

      addKaigoInfoKyotakuServiceRadio();
    }
    return kaigoInfoKyotakuServiceRadio;

  }

  /**
   * 居宅サービス・ラジオグループモデルを取得します。
   * @return 居宅サービス・ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoInfoKyotakuServiceRadioModel(){
    if(kaigoInfoKyotakuServiceRadioModel==null){
      kaigoInfoKyotakuServiceRadioModel = new ACListModelAdapter();
      addKaigoInfoKyotakuServiceRadioModel();
    }
    return kaigoInfoKyotakuServiceRadioModel;
  }

  /**
   * 居宅介護支援事業所を取得します。
   * @return 居宅介護支援事業所
   */
  public ACRadioButtonItem getKaigoInfoKyotakuServiceRadioItem1(){
    if(kaigoInfoKyotakuServiceRadioItem1==null){

      kaigoInfoKyotakuServiceRadioItem1 = new ACRadioButtonItem();

      kaigoInfoKyotakuServiceRadioItem1.setText("居宅介護支援事業所");

      kaigoInfoKyotakuServiceRadioItem1.setGroup(getKaigoInfoKyotakuServiceRadio());

      kaigoInfoKyotakuServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoInfoKyotakuServiceRadioItem1();
    }
    return kaigoInfoKyotakuServiceRadioItem1;

  }

  /**
   * 被保険者を取得します。
   * @return 被保険者
   */
  public ACRadioButtonItem getKaigoInfoKyotakuServiceRadioItem2(){
    if(kaigoInfoKyotakuServiceRadioItem2==null){

      kaigoInfoKyotakuServiceRadioItem2 = new ACRadioButtonItem();

      kaigoInfoKyotakuServiceRadioItem2.setText("被保険者");

      kaigoInfoKyotakuServiceRadioItem2.setGroup(getKaigoInfoKyotakuServiceRadio());

      kaigoInfoKyotakuServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoInfoKyotakuServiceRadioItem2();
    }
    return kaigoInfoKyotakuServiceRadioItem2;

  }

  /**
   * 介護予防支援事業所を取得します。
   * @return 介護予防支援事業所
   */
  public ACRadioButtonItem getKaigoInfoKyotakuServiceRadioItem3(){
    if(kaigoInfoKyotakuServiceRadioItem3==null){

      kaigoInfoKyotakuServiceRadioItem3 = new ACRadioButtonItem();

      kaigoInfoKyotakuServiceRadioItem3.setText("介護予防支援事業所");

      kaigoInfoKyotakuServiceRadioItem3.setGroup(getKaigoInfoKyotakuServiceRadio());

      kaigoInfoKyotakuServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoInfoKyotakuServiceRadioItem3();
    }
    return kaigoInfoKyotakuServiceRadioItem3;

  }

  /**
   * 居宅サービス計画作成者・コンボを取得します。
   * @return 居宅サービス計画作成者・コンボ
   */
  public ACComboBox getKaigoInfoKyotakuServicePlanCombo(){
    if(kaigoInfoKyotakuServicePlanCombo==null){

      kaigoInfoKyotakuServicePlanCombo = new ACComboBox();

      kaigoInfoKyotakuServicePlanCombo.setBindPath("PROVIDER_ID");

      kaigoInfoKyotakuServicePlanCombo.setEditable(false);

      kaigoInfoKyotakuServicePlanCombo.setColumns(18);

      kaigoInfoKyotakuServicePlanCombo.setModelBindPath("PROVIDER");

      kaigoInfoKyotakuServicePlanCombo.setRenderBindPath("PROVIDER_NAME");

      kaigoInfoKyotakuServicePlanCombo.setMaxColumns(64);

      kaigoInfoKyotakuServicePlanCombo.setModel(getKaigoInfoKyotakuServicePlanComboModel());

      addKaigoInfoKyotakuServicePlanCombo();
    }
    return kaigoInfoKyotakuServicePlanCombo;

  }

  /**
   * 居宅サービス計画作成者・コンボモデルを取得します。
   * @return 居宅サービス計画作成者・コンボモデル
   */
  protected ACComboBoxModelAdapter getKaigoInfoKyotakuServicePlanComboModel(){
    if(kaigoInfoKyotakuServicePlanComboModel==null){
      kaigoInfoKyotakuServicePlanComboModel = new ACComboBoxModelAdapter();
      addKaigoInfoKyotakuServicePlanComboModel();
    }
    return kaigoInfoKyotakuServicePlanComboModel;
  }

  /**
   * 居宅サービス計画作成依頼届出日を取得します。
   * @return 居宅サービス計画作成依頼届出日
   */
  public QkanDateTextField getKaigoInfoReportDate(){
    if(kaigoInfoReportDate==null){

      kaigoInfoReportDate = new QkanDateTextField();

      getKaigoInfoReportDateContainer().setText("作成依頼届出日");

      kaigoInfoReportDate.setBindPath("REPORTED_DATE");

      addKaigoInfoReportDate();
    }
    return kaigoInfoReportDate;

  }

  /**
   * 居宅サービス計画作成依頼届出日コンテナを取得します。
   * @return 居宅サービス計画作成依頼届出日コンテナ
   */
  protected ACLabelContainer getKaigoInfoReportDateContainer(){
    if(kaigoInfoReportDateContainer==null){
      kaigoInfoReportDateContainer = new ACLabelContainer();
      kaigoInfoReportDateContainer.setFollowChildEnabled(true);
      kaigoInfoReportDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoReportDateContainer.add(getKaigoInfoReportDate(), null);
    }
    return kaigoInfoReportDateContainer;
  }

  /**
   * (申請区分・コンテナ)を取得します。
   * @return (申請区分・コンテナ)
   */
  public ACLabelContainer getKaigoInfoRequestDivisionContena(){
    if(kaigoInfoRequestDivisionContena==null){

      kaigoInfoRequestDivisionContena = new ACLabelContainer();

      kaigoInfoRequestDivisionContena.setText("申請区分");

      addKaigoInfoRequestDivisionContena();
    }
    return kaigoInfoRequestDivisionContena;

  }

  /**
   * 申請区分・ラジオグループを取得します。
   * @return 申請区分・ラジオグループ
   */
  public ACClearableRadioButtonGroup getKaigoInfoRequestDivisionRadio(){
    if(kaigoInfoRequestDivisionRadio==null){

      kaigoInfoRequestDivisionRadio = new ACClearableRadioButtonGroup();

      kaigoInfoRequestDivisionRadio.setBindPath("SHUBETSU_CODE");

      kaigoInfoRequestDivisionRadio.setUseClearButton(false);

      kaigoInfoRequestDivisionRadio.setModel(getKaigoInfoRequestDivisionRadioModel());

      addKaigoInfoRequestDivisionRadio();
    }
    return kaigoInfoRequestDivisionRadio;

  }

  /**
   * 申請区分・ラジオグループモデルを取得します。
   * @return 申請区分・ラジオグループモデル
   */
  protected ACListModelAdapter getKaigoInfoRequestDivisionRadioModel(){
    if(kaigoInfoRequestDivisionRadioModel==null){
      kaigoInfoRequestDivisionRadioModel = new ACListModelAdapter();
      addKaigoInfoRequestDivisionRadioModel();
    }
    return kaigoInfoRequestDivisionRadioModel;
  }

  /**
   * 期間終了後新規を取得します。
   * @return 期間終了後新規
   */
  public ACRadioButtonItem getKaigoInfoRequestDivisionRadioItem1(){
    if(kaigoInfoRequestDivisionRadioItem1==null){

      kaigoInfoRequestDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoInfoRequestDivisionRadioItem1.setText("新規・期間終了後新規");

      kaigoInfoRequestDivisionRadioItem1.setGroup(getKaigoInfoRequestDivisionRadio());

      kaigoInfoRequestDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoInfoRequestDivisionRadioItem1();
    }
    return kaigoInfoRequestDivisionRadioItem1;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACRadioButtonItem getKaigoInfoRequestDivisionRadioItem2(){
    if(kaigoInfoRequestDivisionRadioItem2==null){

      kaigoInfoRequestDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoInfoRequestDivisionRadioItem2.setText("更新");

      kaigoInfoRequestDivisionRadioItem2.setGroup(getKaigoInfoRequestDivisionRadio());

      kaigoInfoRequestDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoInfoRequestDivisionRadioItem2();
    }
    return kaigoInfoRequestDivisionRadioItem2;

  }

  /**
   * 変更を取得します。
   * @return 変更
   */
  public ACRadioButtonItem getKaigoInfoRequestDivisionRadioItem3(){
    if(kaigoInfoRequestDivisionRadioItem3==null){

      kaigoInfoRequestDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoInfoRequestDivisionRadioItem3.setText("変更");

      kaigoInfoRequestDivisionRadioItem3.setGroup(getKaigoInfoRequestDivisionRadio());

      kaigoInfoRequestDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoInfoRequestDivisionRadioItem3();
    }
    return kaigoInfoRequestDivisionRadioItem3;

  }

  /**
   * 申請中を取得します。
   * @return 申請中
   */
  public ACIntegerCheckBox getKaigoInfoRequests(){
    if(kaigoInfoRequests==null){

      kaigoInfoRequests = new ACIntegerCheckBox();

      kaigoInfoRequests.setText("申請中");

      kaigoInfoRequests.setBindPath("CHANGE_CODE");

      addKaigoInfoRequests();
    }
    return kaigoInfoRequests;

  }

  /**
   * 要介護情報を取得します。
   * @return 要介護情報
   */
  public ACComboBox getKaigoInfoYokaigoInfo(){
    if(kaigoInfoYokaigoInfo==null){

      kaigoInfoYokaigoInfo = new ACComboBox();

      getKaigoInfoYokaigoInfoContainer().setText("要介護度");

      kaigoInfoYokaigoInfo.setBindPath("JOTAI_CODE");

      kaigoInfoYokaigoInfo.setEditable(false);

      kaigoInfoYokaigoInfo.setColumns(6);

      kaigoInfoYokaigoInfo.setModelBindPath("JOTAI_CODE");

      kaigoInfoYokaigoInfo.setRenderBindPath("CONTENT");

      kaigoInfoYokaigoInfo.setModel(getKaigoInfoYokaigoInfoModel());

      addKaigoInfoYokaigoInfo();
    }
    return kaigoInfoYokaigoInfo;

  }

  /**
   * 要介護情報コンテナを取得します。
   * @return 要介護情報コンテナ
   */
  protected ACLabelContainer getKaigoInfoYokaigoInfoContainer(){
    if(kaigoInfoYokaigoInfoContainer==null){
      kaigoInfoYokaigoInfoContainer = new ACLabelContainer();
      kaigoInfoYokaigoInfoContainer.setFollowChildEnabled(true);
      kaigoInfoYokaigoInfoContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoYokaigoInfoContainer.add(getKaigoInfoYokaigoInfo(), null);
    }
    return kaigoInfoYokaigoInfoContainer;
  }

  /**
   * 要介護情報モデルを取得します。
   * @return 要介護情報モデル
   */
  protected ACComboBoxModelAdapter getKaigoInfoYokaigoInfoModel(){
    if(kaigoInfoYokaigoInfoModel==null){
      kaigoInfoYokaigoInfoModel = new ACComboBoxModelAdapter();
      addKaigoInfoYokaigoInfoModel();
    }
    return kaigoInfoYokaigoInfoModel;
  }

  /**
   * (有効期間・コンテナ)を取得します。
   * @return (有効期間・コンテナ)
   */
  public ACLabelContainer getKaigoInfoValidLimits(){
    if(kaigoInfoValidLimits==null){

      kaigoInfoValidLimits = new ACLabelContainer();

      kaigoInfoValidLimits.setText("有効期間");

      addKaigoInfoValidLimits();
    }
    return kaigoInfoValidLimits;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getKaigoInfoValidLimit1(){
    if(kaigoInfoValidLimit1==null){

      kaigoInfoValidLimit1 = new QkanDateTextField();

      kaigoInfoValidLimit1.setBindPath("INSURE_VALID_START");

      addKaigoInfoValidLimit1();
    }
    return kaigoInfoValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getKaigoInfoValidLimit2(){
    if(kaigoInfoValidLimit2==null){

      kaigoInfoValidLimit2 = new ACLabel();

      kaigoInfoValidLimit2.setText(" から ");

      addKaigoInfoValidLimit2();
    }
    return kaigoInfoValidLimit2;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getKaigoInfoValidLimit3(){
    if(kaigoInfoValidLimit3==null){

      kaigoInfoValidLimit3 = new QkanDateTextField();

      kaigoInfoValidLimit3.setBindPath("INSURE_VALID_END");

      addKaigoInfoValidLimit3();
    }
    return kaigoInfoValidLimit3;

  }

  /**
   * 申請日を取得します。
   * @return 申請日
   */
  public QkanDateTextField getKaigoInfoRequestDate(){
    if(kaigoInfoRequestDate==null){

      kaigoInfoRequestDate = new QkanDateTextField();

      getKaigoInfoRequestDateContainer().setText("申請日");

      kaigoInfoRequestDate.setBindPath("SHINSEI_DATE");

      addKaigoInfoRequestDate();
    }
    return kaigoInfoRequestDate;

  }

  /**
   * 申請日コンテナを取得します。
   * @return 申請日コンテナ
   */
  protected ACLabelContainer getKaigoInfoRequestDateContainer(){
    if(kaigoInfoRequestDateContainer==null){
      kaigoInfoRequestDateContainer = new ACLabelContainer();
      kaigoInfoRequestDateContainer.setFollowChildEnabled(true);
      kaigoInfoRequestDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoRequestDateContainer.add(getKaigoInfoRequestDate(), null);
    }
    return kaigoInfoRequestDateContainer;
  }

  /**
   * 認定日を取得します。
   * @return 認定日
   */
  public QkanDateTextField getKaigoInfoAuthorizeDate(){
    if(kaigoInfoAuthorizeDate==null){

      kaigoInfoAuthorizeDate = new QkanDateTextField();

      getKaigoInfoAuthorizeDateContainer().setText("認定日");

      kaigoInfoAuthorizeDate.setBindPath("NINTEI_DATE");

      addKaigoInfoAuthorizeDate();
    }
    return kaigoInfoAuthorizeDate;

  }

  /**
   * 認定日コンテナを取得します。
   * @return 認定日コンテナ
   */
  protected ACLabelContainer getKaigoInfoAuthorizeDateContainer(){
    if(kaigoInfoAuthorizeDateContainer==null){
      kaigoInfoAuthorizeDateContainer = new ACLabelContainer();
      kaigoInfoAuthorizeDateContainer.setFollowChildEnabled(true);
      kaigoInfoAuthorizeDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoAuthorizeDateContainer.add(getKaigoInfoAuthorizeDate(), null);
    }
    return kaigoInfoAuthorizeDateContainer;
  }

  /**
   * (支給限度額グループ)を取得します。
   * @return (支給限度額グループ)
   */
  public ACGroupBox getKaigoInfoProvideLimitGroup(){
    if(kaigoInfoProvideLimitGroup==null){

      kaigoInfoProvideLimitGroup = new ACGroupBox();

      kaigoInfoProvideLimitGroup.setText("支給限度額・外部利用型給付上限単位数");

      kaigoInfoProvideLimitGroup.setHgap(0);

      addKaigoInfoProvideLimitGroup();
    }
    return kaigoInfoProvideLimitGroup;

  }

  /**
   * (支給限度額・コンテナ)を取得します。
   * @return (支給限度額・コンテナ)
   */
  public ACLabelContainer getKaigoInfoProvideLimitContena(){
    if(kaigoInfoProvideLimitContena==null){

      kaigoInfoProvideLimitContena = new ACLabelContainer();

      kaigoInfoProvideLimitContena.setText("支給限度額");

      addKaigoInfoProvideLimitContena();
    }
    return kaigoInfoProvideLimitContena;

  }

  /**
   * 支給限度額を取得します。
   * @return 支給限度額
   */
  public ACTextField getKaigoInfoProvideLimit(){
    if(kaigoInfoProvideLimit==null){

      kaigoInfoProvideLimit = new ACTextField();

      kaigoInfoProvideLimit.setBindPath("LIMIT_RATE");

      kaigoInfoProvideLimit.setEditable(false);

      kaigoInfoProvideLimit.setColumns(5);

      kaigoInfoProvideLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoProvideLimit.setMaxLength(5);

      addKaigoInfoProvideLimit();
    }
    return kaigoInfoProvideLimit;

  }

  /**
   * 単位ラベルを取得します。
   * @return 単位ラベル
   */
  public ACLabel getKaigoInfoProvideLimitLabel(){
    if(kaigoInfoProvideLimitLabel==null){

      kaigoInfoProvideLimitLabel = new ACLabel();

      kaigoInfoProvideLimitLabel.setText(" 単位");

      addKaigoInfoProvideLimitLabel();
    }
    return kaigoInfoProvideLimitLabel;

  }

  /**
   * (外部利用型給付上限単位数・コンテナ)を取得します。
   * @return (外部利用型給付上限単位数・コンテナ)
   */
  public ACLabelContainer getKaigoInfoExternalUseLimitContena(){
    if(kaigoInfoExternalUseLimitContena==null){

      kaigoInfoExternalUseLimitContena = new ACLabelContainer();

      kaigoInfoExternalUseLimitContena.setText("外部利用型給付上限単位数");

      addKaigoInfoExternalUseLimitContena();
    }
    return kaigoInfoExternalUseLimitContena;

  }

  /**
   * 外部利用型給付上限単位数を取得します。
   * @return 外部利用型給付上限単位数
   */
  public ACTextField getKaigoInfoExternalUseLimit(){
    if(kaigoInfoExternalUseLimit==null){

      kaigoInfoExternalUseLimit = new ACTextField();

      kaigoInfoExternalUseLimit.setBindPath("EXTERNAL_USE_LIMIT");

      kaigoInfoExternalUseLimit.setEditable(false);

      kaigoInfoExternalUseLimit.setColumns(5);

      kaigoInfoExternalUseLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoExternalUseLimit.setMaxLength(5);

      addKaigoInfoExternalUseLimit();
    }
    return kaigoInfoExternalUseLimit;

  }

  /**
   * 単位ラベルを取得します。
   * @return 単位ラベル
   */
  public ACLabel getKaigoInfoExternalUseLimitLabel(){
    if(kaigoInfoExternalUseLimitLabel==null){

      kaigoInfoExternalUseLimitLabel = new ACLabel();

      kaigoInfoExternalUseLimitLabel.setText(" 単位");

      addKaigoInfoExternalUseLimitLabel();
    }
    return kaigoInfoExternalUseLimitLabel;

  }

  /**
   * (中断日・中断理由グループ)を取得します。
   * @return (中断日・中断理由グループ)
   */
  public ACGroupBox getKaigoInfoInterruptionGroup(){
    if(kaigoInfoInterruptionGroup==null){

      kaigoInfoInterruptionGroup = new ACGroupBox();

      kaigoInfoInterruptionGroup.setText("中断日・中断理由");

      kaigoInfoInterruptionGroup.setAutoWrap(false);

      kaigoInfoInterruptionGroup.setHgap(0);

      addKaigoInfoInterruptionGroup();
    }
    return kaigoInfoInterruptionGroup;

  }

  /**
   * 中断日を取得します。
   * @return 中断日
   */
  public QkanDateTextField getKaigoInfoInterruptionDate(){
    if(kaigoInfoInterruptionDate==null){

      kaigoInfoInterruptionDate = new QkanDateTextField();

      getKaigoInfoInterruptionDateContainer().setText("中断日");

      kaigoInfoInterruptionDate.setBindPath("STOP_DATE");

      addKaigoInfoInterruptionDate();
    }
    return kaigoInfoInterruptionDate;

  }

  /**
   * 中断日コンテナを取得します。
   * @return 中断日コンテナ
   */
  protected ACLabelContainer getKaigoInfoInterruptionDateContainer(){
    if(kaigoInfoInterruptionDateContainer==null){
      kaigoInfoInterruptionDateContainer = new ACLabelContainer();
      kaigoInfoInterruptionDateContainer.setFollowChildEnabled(true);
      kaigoInfoInterruptionDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInterruptionDateContainer.add(getKaigoInfoInterruptionDate(), null);
    }
    return kaigoInfoInterruptionDateContainer;
  }

  /**
   * 中断理由を取得します。
   * @return 中断理由
   */
  public ACClearableRadioButtonGroup getKaigoInfoInterruptionReasonRadio(){
    if(kaigoInfoInterruptionReasonRadio==null){

      kaigoInfoInterruptionReasonRadio = new ACClearableRadioButtonGroup();

      getKaigoInfoInterruptionReasonRadioContainer().setText("中断理由");

      kaigoInfoInterruptionReasonRadio.setBindPath("STOP_REASON");

      kaigoInfoInterruptionReasonRadio.setUseClearButton(true);

      kaigoInfoInterruptionReasonRadio.setModel(getKaigoInfoInterruptionReasonRadioModel());

      addKaigoInfoInterruptionReasonRadio();
    }
    return kaigoInfoInterruptionReasonRadio;

  }

  /**
   * 中断理由コンテナを取得します。
   * @return 中断理由コンテナ
   */
  protected ACLabelContainer getKaigoInfoInterruptionReasonRadioContainer(){
    if(kaigoInfoInterruptionReasonRadioContainer==null){
      kaigoInfoInterruptionReasonRadioContainer = new ACLabelContainer();
      kaigoInfoInterruptionReasonRadioContainer.setFollowChildEnabled(true);
      kaigoInfoInterruptionReasonRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInterruptionReasonRadioContainer.add(getKaigoInfoInterruptionReasonRadio(), null);
    }
    return kaigoInfoInterruptionReasonRadioContainer;
  }

  /**
   * 中断理由モデルを取得します。
   * @return 中断理由モデル
   */
  protected ACListModelAdapter getKaigoInfoInterruptionReasonRadioModel(){
    if(kaigoInfoInterruptionReasonRadioModel==null){
      kaigoInfoInterruptionReasonRadioModel = new ACListModelAdapter();
      addKaigoInfoInterruptionReasonRadioModel();
    }
    return kaigoInfoInterruptionReasonRadioModel;
  }

  /**
   * 非更新を取得します。
   * @return 非更新
   */
  public ACRadioButtonItem getKaigoInfoInterruptionReasonRadioItem1(){
    if(kaigoInfoInterruptionReasonRadioItem1==null){

      kaigoInfoInterruptionReasonRadioItem1 = new ACRadioButtonItem();

      kaigoInfoInterruptionReasonRadioItem1.setText("非更新");

      kaigoInfoInterruptionReasonRadioItem1.setGroup(getKaigoInfoInterruptionReasonRadio());

      kaigoInfoInterruptionReasonRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoInfoInterruptionReasonRadioItem1();
    }
    return kaigoInfoInterruptionReasonRadioItem1;

  }

  /**
   * 非該当を取得します。
   * @return 非該当
   */
  public ACRadioButtonItem getKaigoInfoInterruptionReasonRadioItem2(){
    if(kaigoInfoInterruptionReasonRadioItem2==null){

      kaigoInfoInterruptionReasonRadioItem2 = new ACRadioButtonItem();

      kaigoInfoInterruptionReasonRadioItem2.setText("非該当");

      kaigoInfoInterruptionReasonRadioItem2.setGroup(getKaigoInfoInterruptionReasonRadio());

      kaigoInfoInterruptionReasonRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoInfoInterruptionReasonRadioItem2();
    }
    return kaigoInfoInterruptionReasonRadioItem2;

  }

  /**
   * 死亡を取得します。
   * @return 死亡
   */
  public ACRadioButtonItem getKaigoInfoInterruptionReasonRadioItem3(){
    if(kaigoInfoInterruptionReasonRadioItem3==null){

      kaigoInfoInterruptionReasonRadioItem3 = new ACRadioButtonItem();

      kaigoInfoInterruptionReasonRadioItem3.setText("死亡");

      kaigoInfoInterruptionReasonRadioItem3.setGroup(getKaigoInfoInterruptionReasonRadio());

      kaigoInfoInterruptionReasonRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoInfoInterruptionReasonRadioItem3();
    }
    return kaigoInfoInterruptionReasonRadioItem3;

  }

  /**
   * 説明文ラベル1を取得します。
   * @return 説明文ラベル1
   */
  public ACLabel getKaigoInfoExplanationLabel1(){
    if(kaigoInfoExplanationLabel1==null){

      kaigoInfoExplanationLabel1 = new ACLabel();

      kaigoInfoExplanationLabel1.setText("既存の認定に中断日・中断理由を設定する場合は、追加ボタンではなく書き換えボタンを押してください。");

      kaigoInfoExplanationLabel1.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addKaigoInfoExplanationLabel1();
    }
    return kaigoInfoExplanationLabel1;

  }

  /**
   * (介護保険情報・ボタン領域)を取得します。
   * @return (介護保険情報・ボタン領域)
   */
  public ACPanel getKaigoInfoButtons(){
    if(kaigoInfoButtons==null){

      kaigoInfoButtons = new ACPanel();

      addKaigoInfoButtons();
    }
    return kaigoInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getKaigoInfoButtonClear(){
    if(kaigoInfoButtonClear==null){

      kaigoInfoButtonClear = new ACButton();

      kaigoInfoButtonClear.setText("クリア");

      kaigoInfoButtonClear.setToolTipText("介護保険情報をクリアします。");

      kaigoInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addKaigoInfoButtonClear();
    }
    return kaigoInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getKaigoInfoButtonInsert(){
    if(kaigoInfoButtonInsert==null){

      kaigoInfoButtonInsert = new ACButton();

      kaigoInfoButtonInsert.setText("追加");

      kaigoInfoButtonInsert.setToolTipText("介護保険情報を追加します。");

      kaigoInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addKaigoInfoButtonInsert();
    }
    return kaigoInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getKaigoInfoButtonEdit(){
    if(kaigoInfoButtonEdit==null){

      kaigoInfoButtonEdit = new ACButton();

      kaigoInfoButtonEdit.setText("書替");

      kaigoInfoButtonEdit.setToolTipText("介護保険情報を書き換えます。");

      kaigoInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addKaigoInfoButtonEdit();
    }
    return kaigoInfoButtonEdit;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getKaigoInfoDelete(){
    if(kaigoInfoDelete==null){

      kaigoInfoDelete = new ACButton();

      kaigoInfoDelete.setText("削除");

      kaigoInfoDelete.setToolTipText("介護保険情報を削除します。");

      kaigoInfoDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addKaigoInfoDelete();
    }
    return kaigoInfoDelete;

  }

  /**
   * (介護情報・テーブル領域)を取得します。
   * @return (介護情報・テーブル領域)
   */
  public ACTable getKaigoInfoTable(){
    if(kaigoInfoTable==null){

      kaigoInfoTable = new ACTable();

      kaigoInfoTable.setColumnModel(getKaigoInfoTableColumnModel());

      addKaigoInfoTable();
    }
    return kaigoInfoTable;

  }

  /**
   * (介護情報・テーブル領域)カラムモデルを取得します。
   * @return (介護情報・テーブル領域)カラムモデル
   */
  protected VRTableColumnModel getKaigoInfoTableColumnModel(){
    if(kaigoInfoTableColumnModel==null){
      kaigoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoTableColumnModel();
    }
    return kaigoInfoTableColumnModel;
  }

  /**
   * Noを取得します。
   * @return No
   */
  public ACTableColumn getKaigoInfoTableColumn0(){
    if(kaigoInfoTableColumn0==null){

      kaigoInfoTableColumn0 = new ACTableColumn(0);

      kaigoInfoTableColumn0.setHeaderValue("No.");

      kaigoInfoTableColumn0.setColumns(3);

      kaigoInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kaigoInfoTableColumn0.setSortable(false);

      addKaigoInfoTableColumn0();
    }
    return kaigoInfoTableColumn0;

  }

  /**
   * 申請日を取得します。
   * @return 申請日
   */
  public ACTableColumn getKaigoInfoTableColumn1(){
    if(kaigoInfoTableColumn1==null){

      kaigoInfoTableColumn1 = new ACTableColumn(0);

      kaigoInfoTableColumn1.setHeaderValue("申請日");

      kaigoInfoTableColumn1.setColumns(10);

      kaigoInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn1();
    }
    return kaigoInfoTableColumn1;

  }

  /**
   * 申請区分を取得します。
   * @return 申請区分
   */
  public ACTableColumn getKaigoInfoTableColumn2(){
    if(kaigoInfoTableColumn2==null){

      kaigoInfoTableColumn2 = new ACTableColumn(1);

      kaigoInfoTableColumn2.setHeaderValue("申請区分");

      kaigoInfoTableColumn2.setColumns(10);

      addKaigoInfoTableColumn2();
    }
    return kaigoInfoTableColumn2;

  }

  /**
   * 要介護情報を取得します。
   * @return 要介護情報
   */
  public ACTableColumn getKaigoInfoTableColumn3(){
    if(kaigoInfoTableColumn3==null){

      kaigoInfoTableColumn3 = new ACTableColumn(2);

      kaigoInfoTableColumn3.setHeaderValue("要介護度");

      kaigoInfoTableColumn3.setColumns(7);

      addKaigoInfoTableColumn3();
    }
    return kaigoInfoTableColumn3;

  }

  /**
   * 有効期間開始日を取得します。
   * @return 有効期間開始日
   */
  public ACTableColumn getKaigoInfoTableColumn4(){
    if(kaigoInfoTableColumn4==null){

      kaigoInfoTableColumn4 = new ACTableColumn(3);

      kaigoInfoTableColumn4.setHeaderValue("有効期間開始日");

      kaigoInfoTableColumn4.setColumns(10);

      kaigoInfoTableColumn4.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn4();
    }
    return kaigoInfoTableColumn4;

  }

  /**
   * 有効期間終了日を取得します。
   * @return 有効期間終了日
   */
  public ACTableColumn getKaigoInfoTableColumn5(){
    if(kaigoInfoTableColumn5==null){

      kaigoInfoTableColumn5 = new ACTableColumn(4);

      kaigoInfoTableColumn5.setHeaderValue("有効期間終了日");

      kaigoInfoTableColumn5.setColumns(10);

      kaigoInfoTableColumn5.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn5();
    }
    return kaigoInfoTableColumn5;

  }

  /**
   * 作成依頼届出日を取得します。
   * @return 作成依頼届出日
   */
  public ACTableColumn getKaigoInfoTableColumn6(){
    if(kaigoInfoTableColumn6==null){

      kaigoInfoTableColumn6 = new ACTableColumn(5);

      kaigoInfoTableColumn6.setHeaderValue("作成依頼届出日");

      kaigoInfoTableColumn6.setColumns(10);

      kaigoInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn6();
    }
    return kaigoInfoTableColumn6;

  }

  /**
   * 中断年月日を取得します。
   * @return 中断年月日
   */
  public ACTableColumn getKaigoInfoTableColumn7(){
    if(kaigoInfoTableColumn7==null){

      kaigoInfoTableColumn7 = new ACTableColumn(6);

      kaigoInfoTableColumn7.setHeaderValue("中断年月日");

      kaigoInfoTableColumn7.setColumns(10);

      kaigoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn7();
    }
    return kaigoInfoTableColumn7;

  }

  /**
   * 中断理由を取得します。
   * @return 中断理由
   */
  public ACTableColumn getKaigoInfoTableColumn8(){
    if(kaigoInfoTableColumn8==null){

      kaigoInfoTableColumn8 = new ACTableColumn(7);

      kaigoInfoTableColumn8.setHeaderValue("中断理由");

      kaigoInfoTableColumn8.setColumns(6);

      addKaigoInfoTableColumn8();
    }
    return kaigoInfoTableColumn8;

  }

  /**
   * 支給限度額を取得します。
   * @return 支給限度額
   */
  public ACTableColumn getKaigoInfoTableColumn9(){
    if(kaigoInfoTableColumn9==null){

      kaigoInfoTableColumn9 = new ACTableColumn(8);

      kaigoInfoTableColumn9.setHeaderValue("支給限度額");

      kaigoInfoTableColumn9.setColumns(7);

      kaigoInfoTableColumn9.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn9();
    }
    return kaigoInfoTableColumn9;

  }

  /**
   * (異動・施設情報・パネル)を取得します。
   * @return (異動・施設情報・パネル)
   */
  public ACPanel getIdouInfoAndInstitutionInfoPanel(){
    if(idouInfoAndInstitutionInfoPanel==null){

      idouInfoAndInstitutionInfoPanel = new ACPanel();

      addIdouInfoAndInstitutionInfoPanel();
    }
    return idouInfoAndInstitutionInfoPanel;

  }

  /**
   * (異動情報領域・グループ)を取得します。
   * @return (異動情報領域・グループ)
   */
  public ACGroupBox getIdouInfoAndInstitutionInfos(){
    if(idouInfoAndInstitutionInfos==null){

      idouInfoAndInstitutionInfos = new ACGroupBox();

      idouInfoAndInstitutionInfos.setText("異動情報");

      idouInfoAndInstitutionInfos.setLayout(getIdouInfoAndInstitutionInfoLayout());

      addIdouInfoAndInstitutionInfos();
    }
    return idouInfoAndInstitutionInfos;

  }

  /**
   * (異動・施設情報領域・レイアウト)を取得します。
   * @return (異動・施設情報領域・レイアウト)
   */
  public VRLayout getIdouInfoAndInstitutionInfoLayout(){
    if(idouInfoAndInstitutionInfoLayout==null){

      idouInfoAndInstitutionInfoLayout = new VRLayout();

      idouInfoAndInstitutionInfoLayout.setAutoWrap(false);

      addIdouInfoAndInstitutionInfoLayout();
    }
    return idouInfoAndInstitutionInfoLayout;

  }

  /**
   * (異動情報領域・上)を取得します。
   * @return (異動情報領域・上)
   */
  public ACPanel getIdouInfoUp(){
    if(idouInfoUp==null){

      idouInfoUp = new ACPanel();

      addIdouInfoUp();
    }
    return idouInfoUp;

  }

  /**
   * (異動情報領域)を取得します。
   * @return (異動情報領域)
   */
  public ACPanel getIdouInfo(){
    if(idouInfo==null){

      idouInfo = new ACPanel();

      idouInfo.setLayout(getIdouInfoLayout2());

      addIdouInfo();
    }
    return idouInfo;

  }

  /**
   * (異動情報領域・レイアウト)を取得します。
   * @return (異動情報領域・レイアウト)
   */
  public VRLayout getIdouInfoLayout2(){
    if(idouInfoLayout2==null){

      idouInfoLayout2 = new VRLayout();

      idouInfoLayout2.setAutoWrap(false);

      addIdouInfoLayout2();
    }
    return idouInfoLayout2;

  }

  /**
   * サービスを取得します。
   * @return サービス
   */
  public ACComboBox getIdouInfoServise(){
    if(idouInfoServise==null){

      idouInfoServise = new ACComboBox();

      getIdouInfoServiseContainer().setText("サービス");

      idouInfoServise.setBindPath("SYSTEM_SERVICE_KIND_DETAIL");

      idouInfoServise.setEditable(false);

      idouInfoServise.setColumns(10);

      idouInfoServise.setModelBindPath("SERVICE");

      idouInfoServise.setRenderBindPath("SERVICE_ABBREVIATION");

      idouInfoServise.setModel(getIdouInfoServiseModel());

      addIdouInfoServise();
    }
    return idouInfoServise;

  }

  /**
   * サービスコンテナを取得します。
   * @return サービスコンテナ
   */
  protected ACLabelContainer getIdouInfoServiseContainer(){
    if(idouInfoServiseContainer==null){
      idouInfoServiseContainer = new ACLabelContainer();
      idouInfoServiseContainer.setFollowChildEnabled(true);
      idouInfoServiseContainer.setVAlignment(VRLayout.CENTER);
      idouInfoServiseContainer.add(getIdouInfoServise(), null);
    }
    return idouInfoServiseContainer;
  }

  /**
   * サービスモデルを取得します。
   * @return サービスモデル
   */
  protected ACComboBoxModelAdapter getIdouInfoServiseModel(){
    if(idouInfoServiseModel==null){
      idouInfoServiseModel = new ACComboBoxModelAdapter();
      addIdouInfoServiseModel();
    }
    return idouInfoServiseModel;
  }

  /**
   * 異動事由を取得します。
   * @return 異動事由
   */
  public ACComboBox getIdouInfoChangeContent(){
    if(idouInfoChangeContent==null){

      idouInfoChangeContent = new ACComboBox();

      getIdouInfoChangeContentContainer().setText("異動事由");

      idouInfoChangeContent.setBindPath("CHANGES_CONTENT");

      idouInfoChangeContent.setEditable(false);

      idouInfoChangeContent.setColumns(5);

      idouInfoChangeContent.setModelBindPath("CHANGES_CONTENT");

      idouInfoChangeContent.setRenderBindPath("CONTENT");

      idouInfoChangeContent.setModel(getIdouInfoChangeContentModel());

      addIdouInfoChangeContent();
    }
    return idouInfoChangeContent;

  }

  /**
   * 異動事由コンテナを取得します。
   * @return 異動事由コンテナ
   */
  protected ACLabelContainer getIdouInfoChangeContentContainer(){
    if(idouInfoChangeContentContainer==null){
      idouInfoChangeContentContainer = new ACLabelContainer();
      idouInfoChangeContentContainer.setFollowChildEnabled(true);
      idouInfoChangeContentContainer.setVAlignment(VRLayout.CENTER);
      idouInfoChangeContentContainer.add(getIdouInfoChangeContent(), null);
    }
    return idouInfoChangeContentContainer;
  }

  /**
   * 異動事由モデルを取得します。
   * @return 異動事由モデル
   */
  protected ACComboBoxModelAdapter getIdouInfoChangeContentModel(){
    if(idouInfoChangeContentModel==null){
      idouInfoChangeContentModel = new ACComboBoxModelAdapter();
      addIdouInfoChangeContentModel();
    }
    return idouInfoChangeContentModel;
  }

  /**
   * 日付を取得します。
   * @return 日付
   */
  public QkanDateTextField getIdouInfoDate(){
    if(idouInfoDate==null){

      idouInfoDate = new QkanDateTextField();

      getIdouInfoDateContainer().setText("日付");

      idouInfoDate.setBindPath("CHANGES_DATE");

      addIdouInfoDate();
    }
    return idouInfoDate;

  }

  /**
   * 日付コンテナを取得します。
   * @return 日付コンテナ
   */
  protected ACLabelContainer getIdouInfoDateContainer(){
    if(idouInfoDateContainer==null){
      idouInfoDateContainer = new ACLabelContainer();
      idouInfoDateContainer.setFollowChildEnabled(true);
      idouInfoDateContainer.setVAlignment(VRLayout.CENTER);
      idouInfoDateContainer.add(getIdouInfoDate(), null);
    }
    return idouInfoDateContainer;
  }

  /**
   * 時間を取得します。
   * @return 時間
   */
  public ACTimeTextField getIdouInfoTime(){
    if(idouInfoTime==null){

      idouInfoTime = new ACTimeTextField();

      getIdouInfoTimeContainer().setText("時間");

      idouInfoTime.setBindPath("CHANGES_TIME");

      addIdouInfoTime();
    }
    return idouInfoTime;

  }

  /**
   * 時間コンテナを取得します。
   * @return 時間コンテナ
   */
  protected ACLabelContainer getIdouInfoTimeContainer(){
    if(idouInfoTimeContainer==null){
      idouInfoTimeContainer = new ACLabelContainer();
      idouInfoTimeContainer.setFollowChildEnabled(true);
      idouInfoTimeContainer.setVAlignment(VRLayout.CENTER);
      idouInfoTimeContainer.add(getIdouInfoTime(), null);
    }
    return idouInfoTimeContainer;
  }

  /**
   * 理由/状況を取得します。
   * @return 理由/状況
   */
  public ACComboBox getIdouInfoReason(){
    if(idouInfoReason==null){

      idouInfoReason = new ACComboBox();

      getIdouInfoReasonContainer().setText("理由/状況");

      idouInfoReason.setBindPath("CHANGES_REASON");

      idouInfoReason.setEditable(false);

      idouInfoReason.setColumns(5);

      idouInfoReason.setModelBindPath("CHANGES_REASON");

      idouInfoReason.setRenderBindPath("CONTENT");

      idouInfoReason.setBlankable(true);

      idouInfoReason.setModel(getIdouInfoReasonModel());

      addIdouInfoReason();
    }
    return idouInfoReason;

  }

  /**
   * 理由/状況コンテナを取得します。
   * @return 理由/状況コンテナ
   */
  protected ACLabelContainer getIdouInfoReasonContainer(){
    if(idouInfoReasonContainer==null){
      idouInfoReasonContainer = new ACLabelContainer();
      idouInfoReasonContainer.setFollowChildEnabled(true);
      idouInfoReasonContainer.setVAlignment(VRLayout.CENTER);
      idouInfoReasonContainer.add(getIdouInfoReason(), null);
    }
    return idouInfoReasonContainer;
  }

  /**
   * 理由/状況モデルを取得します。
   * @return 理由/状況モデル
   */
  protected ACComboBoxModelAdapter getIdouInfoReasonModel(){
    if(idouInfoReasonModel==null){
      idouInfoReasonModel = new ACComboBoxModelAdapter();
      addIdouInfoReasonModel();
    }
    return idouInfoReasonModel;
  }

  /**
   * その他　内容を取得します。
   * @return その他　内容
   */
  public ACTextField getIdouInfoReasonMemo(){
    if(idouInfoReasonMemo==null){

      idouInfoReasonMemo = new ACTextField();

      getIdouInfoReasonMemoContainer().setText("内容");

      idouInfoReasonMemo.setBindPath("REASON_MEMO");

      idouInfoReasonMemo.setColumns(30);

      idouInfoReasonMemo.setIMEMode(InputSubset.KANJI);

      idouInfoReasonMemo.setMaxLength(50);

      addIdouInfoReasonMemo();
    }
    return idouInfoReasonMemo;

  }

  /**
   * その他　内容コンテナを取得します。
   * @return その他　内容コンテナ
   */
  protected ACLabelContainer getIdouInfoReasonMemoContainer(){
    if(idouInfoReasonMemoContainer==null){
      idouInfoReasonMemoContainer = new ACLabelContainer();
      idouInfoReasonMemoContainer.setFollowChildEnabled(true);
      idouInfoReasonMemoContainer.setVAlignment(VRLayout.CENTER);
      idouInfoReasonMemoContainer.add(getIdouInfoReasonMemo(), null);
    }
    return idouInfoReasonMemoContainer;
  }

  /**
   * (異動情報・ボタン領域)を取得します。
   * @return (異動情報・ボタン領域)
   */
  public ACPanel getIdouInfoButtons(){
    if(idouInfoButtons==null){

      idouInfoButtons = new ACPanel();

      addIdouInfoButtons();
    }
    return idouInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getIdouInfoButtonClear(){
    if(idouInfoButtonClear==null){

      idouInfoButtonClear = new ACButton();

      idouInfoButtonClear.setText("クリア");

      idouInfoButtonClear.setToolTipText("異動情報をクリアします。");

      idouInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addIdouInfoButtonClear();
    }
    return idouInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getIdouInfoButtonInsert(){
    if(idouInfoButtonInsert==null){

      idouInfoButtonInsert = new ACButton();

      idouInfoButtonInsert.setText("追加");

      idouInfoButtonInsert.setToolTipText("異動情報を追加します。");

      idouInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addIdouInfoButtonInsert();
    }
    return idouInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getIdouInfoButtonEdit(){
    if(idouInfoButtonEdit==null){

      idouInfoButtonEdit = new ACButton();

      idouInfoButtonEdit.setText("書替");

      idouInfoButtonEdit.setToolTipText("異動情報を編集します。");

      idouInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addIdouInfoButtonEdit();
    }
    return idouInfoButtonEdit;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getIdouInfoButtonDelete(){
    if(idouInfoButtonDelete==null){

      idouInfoButtonDelete = new ACButton();

      idouInfoButtonDelete.setText("削除");

      idouInfoButtonDelete.setToolTipText("異動情報を削除します。");

      idouInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addIdouInfoButtonDelete();
    }
    return idouInfoButtonDelete;

  }

  /**
   * (異動情報・テーブル領域)を取得します。
   * @return (異動情報・テーブル領域)
   */
  public ACTable getIdouInfoTable(){
    if(idouInfoTable==null){

      idouInfoTable = new ACTable();

      idouInfoTable.setColumnModel(getIdouInfoTableColumnModel());

      addIdouInfoTable();
    }
    return idouInfoTable;

  }

  /**
   * (異動情報・テーブル領域)カラムモデルを取得します。
   * @return (異動情報・テーブル領域)カラムモデル
   */
  protected VRTableColumnModel getIdouInfoTableColumnModel(){
    if(idouInfoTableColumnModel==null){
      idouInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addIdouInfoTableColumnModel();
    }
    return idouInfoTableColumnModel;
  }

  /**
   * Noを取得します。
   * @return No
   */
  public ACTableColumn getIdouInfoTableColumn0(){
    if(idouInfoTableColumn0==null){

      idouInfoTableColumn0 = new ACTableColumn(0);

      idouInfoTableColumn0.setHeaderValue("No.");

      idouInfoTableColumn0.setColumns(3);

      idouInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      idouInfoTableColumn0.setSortable(false);

      addIdouInfoTableColumn0();
    }
    return idouInfoTableColumn0;

  }

  /**
   * サービスを取得します。
   * @return サービス
   */
  public ACTableColumn getIdouInfoTableColumn1(){
    if(idouInfoTableColumn1==null){

      idouInfoTableColumn1 = new ACTableColumn(0);

      idouInfoTableColumn1.setHeaderValue("サービス");

      idouInfoTableColumn1.setColumns(20);

      addIdouInfoTableColumn1();
    }
    return idouInfoTableColumn1;

  }

  /**
   * 異動事由を取得します。
   * @return 異動事由
   */
  public ACTableColumn getIdouInfoTableColumn2(){
    if(idouInfoTableColumn2==null){

      idouInfoTableColumn2 = new ACTableColumn(1);

      idouInfoTableColumn2.setHeaderValue("異動事由");

      idouInfoTableColumn2.setColumns(6);

      addIdouInfoTableColumn2();
    }
    return idouInfoTableColumn2;

  }

  /**
   * 日付を取得します。
   * @return 日付
   */
  public ACTableColumn getIdouInfoTableColumn3(){
    if(idouInfoTableColumn3==null){

      idouInfoTableColumn3 = new ACTableColumn(2);

      idouInfoTableColumn3.setHeaderValue("日付");

      idouInfoTableColumn3.setColumns(10);

      idouInfoTableColumn3.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addIdouInfoTableColumn3();
    }
    return idouInfoTableColumn3;

  }

  /**
   * 時間を取得します。
   * @return 時間
   */
  public ACTableColumn getIdouInfoTableColumn4(){
    if(idouInfoTableColumn4==null){

      idouInfoTableColumn4 = new ACTableColumn(3);

      idouInfoTableColumn4.setHeaderValue("時間");

      idouInfoTableColumn4.setColumns(6);

      idouInfoTableColumn4.setFormat(ACConstants.FORMAT_FULL_HOUR_MINUTE);

      addIdouInfoTableColumn4();
    }
    return idouInfoTableColumn4;

  }

  /**
   * 理由/状況を取得します。
   * @return 理由/状況
   */
  public ACTableColumn getIdouInfoTableColumn5(){
    if(idouInfoTableColumn5==null){

      idouInfoTableColumn5 = new ACTableColumn(4);

      idouInfoTableColumn5.setHeaderValue("理由/状況");

      idouInfoTableColumn5.setColumns(4);

      addIdouInfoTableColumn5();
    }
    return idouInfoTableColumn5;

  }

  /**
   * (施設情報・領域・グループ)を取得します。
   * @return (施設情報・領域・グループ)
   */
  public ACGroupBox getInstitutionInfos(){
    if(institutionInfos==null){

      institutionInfos = new ACGroupBox();

      institutionInfos.setText("施設情報");

      institutionInfos.setLayout(getInstitutionInfoLayout());

      addInstitutionInfos();
    }
    return institutionInfos;

  }

  /**
   * (施設情報領域・レイアウト)を取得します。
   * @return (施設情報領域・レイアウト)
   */
  public VRLayout getInstitutionInfoLayout(){
    if(institutionInfoLayout==null){

      institutionInfoLayout = new VRLayout();

      institutionInfoLayout.setAutoWrap(false);

      institutionInfoLayout.setVgap(5);

      institutionInfoLayout.setHgrid(200);

      addInstitutionInfoLayout();
    }
    return institutionInfoLayout;

  }

  /**
   * 利用者負担限度額ラベルを取得します。
   * @return 利用者負担限度額ラベル
   */
  public ACLabel getInstitutionInfoBearMoneyInfos(){
    if(institutionInfoBearMoneyInfos==null){

      institutionInfoBearMoneyInfos = new ACLabel();

      institutionInfoBearMoneyInfos.setText("利用者負担限度額");

      addInstitutionInfoBearMoneyInfos();
    }
    return institutionInfoBearMoneyInfos;

  }

  /**
   * スペース1を取得します。
   * @return スペース1
   */
  public ACLabel getInstitutionInfoSpace1(){
    if(institutionInfoSpace1==null){

      institutionInfoSpace1 = new ACLabel();

      institutionInfoSpace1.setText(" ");

      addInstitutionInfoSpace1();
    }
    return institutionInfoSpace1;

  }

  /**
   * 特定入所者チェックを取得します。
   * @return 特定入所者チェック
   */
  public ACIntegerCheckBox getInstitutionInfoTokuteiNyusho(){
    if(institutionInfoTokuteiNyusho==null){

      institutionInfoTokuteiNyusho = new ACIntegerCheckBox();

      institutionInfoTokuteiNyusho.setText("特定入所者");

      institutionInfoTokuteiNyusho.setBindPath("TOKUTEI_NYUSHO_FLAG");

      institutionInfoTokuteiNyusho.setSelectValue(2);

      institutionInfoTokuteiNyusho.setUnSelectValue(1);

      addInstitutionInfoTokuteiNyusho();
    }
    return institutionInfoTokuteiNyusho;

  }

  /**
   * スペース2を取得します。
   * @return スペース2
   */
  public ACLabel getInstitutionInfoSpace2(){
    if(institutionInfoSpace2==null){

      institutionInfoSpace2 = new ACLabel();

      institutionInfoSpace2.setText("　　　　　　　　　　　");

      addInstitutionInfoSpace2();
    }
    return institutionInfoSpace2;

  }

  /**
   * （食費負担限度額・コンテナ）を取得します。
   * @return （食費負担限度額・コンテナ）
   */
  public ACLabelContainer getInstitutionInfoDinnerBearLimitMoneyContena(){
    if(institutionInfoDinnerBearLimitMoneyContena==null){

      institutionInfoDinnerBearLimitMoneyContena = new ACLabelContainer();

      institutionInfoDinnerBearLimitMoneyContena.setText("食費");

      addInstitutionInfoDinnerBearLimitMoneyContena();
    }
    return institutionInfoDinnerBearLimitMoneyContena;

  }

  /**
   * 食費負担限度額・テキストを取得します。
   * @return 食費負担限度額・テキスト
   */
  public ACTextField getInstitutionInfoDinnerBearLimitMoneyText(){
    if(institutionInfoDinnerBearLimitMoneyText==null){

      institutionInfoDinnerBearLimitMoneyText = new ACTextField();

      institutionInfoDinnerBearLimitMoneyText.setBindPath("LIMIT_SHOKUHI");

      institutionInfoDinnerBearLimitMoneyText.setColumns(4);

      institutionInfoDinnerBearLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoDinnerBearLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoDinnerBearLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoDinnerBearLimitMoneyText.setMaxLength(4);

      addInstitutionInfoDinnerBearLimitMoneyText();
    }
    return institutionInfoDinnerBearLimitMoneyText;

  }

  /**
   * 食費負担限度額・ラベルを取得します。
   * @return 食費負担限度額・ラベル
   */
  public ACLabel getInstitutionInfoDinnerBearLimitMoneyLabel(){
    if(institutionInfoDinnerBearLimitMoneyLabel==null){

      institutionInfoDinnerBearLimitMoneyLabel = new ACLabel();

      institutionInfoDinnerBearLimitMoneyLabel.setText("（円）");

      addInstitutionInfoDinnerBearLimitMoneyLabel();
    }
    return institutionInfoDinnerBearLimitMoneyLabel;

  }

  /**
   * （ユニット型個室負担限度額・コンテナ）を取得します。
   * @return （ユニット型個室負担限度額・コンテナ）
   */
  public ACLabelContainer getInstitutionInfoUnitRoomLimitMoneyContena(){
    if(institutionInfoUnitRoomLimitMoneyContena==null){

      institutionInfoUnitRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoUnitRoomLimitMoneyContena.setText("ユニット型個室");

      addInstitutionInfoUnitRoomLimitMoneyContena();
    }
    return institutionInfoUnitRoomLimitMoneyContena;

  }

  /**
   * ユニット型個室負担限度額・テキストを取得します。
   * @return ユニット型個室負担限度額・テキスト
   */
  public ACTextField getInstitutionInfoUnitRoomLimitMoneyText(){
    if(institutionInfoUnitRoomLimitMoneyText==null){

      institutionInfoUnitRoomLimitMoneyText = new ACTextField();

      institutionInfoUnitRoomLimitMoneyText.setBindPath("LIMIT_UNIT_KOSHITSU");

      institutionInfoUnitRoomLimitMoneyText.setColumns(4);

      institutionInfoUnitRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoUnitRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoUnitRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoUnitRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoUnitRoomLimitMoneyText();
    }
    return institutionInfoUnitRoomLimitMoneyText;

  }

  /**
   * ユニット型個室負担限度額・ラベルを取得します。
   * @return ユニット型個室負担限度額・ラベル
   */
  public ACLabel getInstitutionInfoUnitRoomLimitMoneyLabel(){
    if(institutionInfoUnitRoomLimitMoneyLabel==null){

      institutionInfoUnitRoomLimitMoneyLabel = new ACLabel();

      institutionInfoUnitRoomLimitMoneyLabel.setText("（円）");

      addInstitutionInfoUnitRoomLimitMoneyLabel();
    }
    return institutionInfoUnitRoomLimitMoneyLabel;

  }

  /**
   * （ユニット型準個室負担限度額・コンテナ）を取得します。
   * @return （ユニット型準個室負担限度額・コンテナ）
   */
  public ACLabelContainer getInstitutionInfoUnitSemiRoomLimitMoneyContena(){
    if(institutionInfoUnitSemiRoomLimitMoneyContena==null){

      institutionInfoUnitSemiRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoUnitSemiRoomLimitMoneyContena.setText("ユニット型準個室");

      addInstitutionInfoUnitSemiRoomLimitMoneyContena();
    }
    return institutionInfoUnitSemiRoomLimitMoneyContena;

  }

  /**
   * ユニット型準個室負担限度額・テキストを取得します。
   * @return ユニット型準個室負担限度額・テキスト
   */
  public ACTextField getInstitutionInfoUnitSemiRoomLimitMoneyText(){
    if(institutionInfoUnitSemiRoomLimitMoneyText==null){

      institutionInfoUnitSemiRoomLimitMoneyText = new ACTextField();

      institutionInfoUnitSemiRoomLimitMoneyText.setBindPath("LIMIT_UNIT_JUNKOSHITSU");

      institutionInfoUnitSemiRoomLimitMoneyText.setColumns(4);

      institutionInfoUnitSemiRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoUnitSemiRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoUnitSemiRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoUnitSemiRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoUnitSemiRoomLimitMoneyText();
    }
    return institutionInfoUnitSemiRoomLimitMoneyText;

  }

  /**
   * ユニット型準個室負担限度額・ラベルを取得します。
   * @return ユニット型準個室負担限度額・ラベル
   */
  public ACLabel getInstitutionInfoUnitSemiRoomLimitMoneyLabel(){
    if(institutionInfoUnitSemiRoomLimitMoneyLabel==null){

      institutionInfoUnitSemiRoomLimitMoneyLabel = new ACLabel();

      institutionInfoUnitSemiRoomLimitMoneyLabel.setText("（円）");

      addInstitutionInfoUnitSemiRoomLimitMoneyLabel();
    }
    return institutionInfoUnitSemiRoomLimitMoneyLabel;

  }

  /**
   * （従来型個室（特養等）負担限度額・コンテナ）を取得します。
   * @return （従来型個室（特養等）負担限度額・コンテナ）
   */
  public ACLabelContainer getInstitutionInfoNormalRoomLimitMoneyContena(){
    if(institutionInfoNormalRoomLimitMoneyContena==null){

      institutionInfoNormalRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoNormalRoomLimitMoneyContena.setText("従来型個室(特養等)");

      addInstitutionInfoNormalRoomLimitMoneyContena();
    }
    return institutionInfoNormalRoomLimitMoneyContena;

  }

  /**
   * 従来型個室（特養等）負担限度額・テキストを取得します。
   * @return 従来型個室（特養等）負担限度額・テキスト
   */
  public ACTextField getInstitutionInfoNormalRoomLimitMoneyText(){
    if(institutionInfoNormalRoomLimitMoneyText==null){

      institutionInfoNormalRoomLimitMoneyText = new ACTextField();

      institutionInfoNormalRoomLimitMoneyText.setBindPath("LIMIT_JURAIGATA1");

      institutionInfoNormalRoomLimitMoneyText.setColumns(4);

      institutionInfoNormalRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoNormalRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoNormalRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoNormalRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoNormalRoomLimitMoneyText();
    }
    return institutionInfoNormalRoomLimitMoneyText;

  }

  /**
   * 従来型個室（特養等）負担限度額・ラベルを取得します。
   * @return 従来型個室（特養等）負担限度額・ラベル
   */
  public ACLabel getInstitutionInfoNormalRoomLimitMoneyLabel(){
    if(institutionInfoNormalRoomLimitMoneyLabel==null){

      institutionInfoNormalRoomLimitMoneyLabel = new ACLabel();

      institutionInfoNormalRoomLimitMoneyLabel.setText("（円）");

      addInstitutionInfoNormalRoomLimitMoneyLabel();
    }
    return institutionInfoNormalRoomLimitMoneyLabel;

  }

  /**
   * （従来型個室（老健・療養等）負担限度額・コンテナ）を取得します。
   * @return （従来型個室（老健・療養等）負担限度額・コンテナ）
   */
  public ACLabelContainer getInstitutionInfoNormalRoomLimitMoneyContena2(){
    if(institutionInfoNormalRoomLimitMoneyContena2==null){

      institutionInfoNormalRoomLimitMoneyContena2 = new ACLabelContainer();

      institutionInfoNormalRoomLimitMoneyContena2.setText("従来型個室(老健・療養等)");

      addInstitutionInfoNormalRoomLimitMoneyContena2();
    }
    return institutionInfoNormalRoomLimitMoneyContena2;

  }

  /**
   * 従来型個室（老健・療養等）負担限度額・テキストを取得します。
   * @return 従来型個室（老健・療養等）負担限度額・テキスト
   */
  public ACTextField getInstitutionInfoNormalRoomLimitMoneyText2(){
    if(institutionInfoNormalRoomLimitMoneyText2==null){

      institutionInfoNormalRoomLimitMoneyText2 = new ACTextField();

      institutionInfoNormalRoomLimitMoneyText2.setBindPath("LIMIT_JURAIGATA2");

      institutionInfoNormalRoomLimitMoneyText2.setColumns(4);

      institutionInfoNormalRoomLimitMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoNormalRoomLimitMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoNormalRoomLimitMoneyText2.setIMEMode(InputSubset.LATIN);

      institutionInfoNormalRoomLimitMoneyText2.setMaxLength(4);

      addInstitutionInfoNormalRoomLimitMoneyText2();
    }
    return institutionInfoNormalRoomLimitMoneyText2;

  }

  /**
   * 従来型個室（老健・療養等）負担限度額・ラベルを取得します。
   * @return 従来型個室（老健・療養等）負担限度額・ラベル
   */
  public ACLabel getInstitutionInfoNormalRoomLimitMoneyLabel2(){
    if(institutionInfoNormalRoomLimitMoneyLabel2==null){

      institutionInfoNormalRoomLimitMoneyLabel2 = new ACLabel();

      institutionInfoNormalRoomLimitMoneyLabel2.setText("（円）");

      addInstitutionInfoNormalRoomLimitMoneyLabel2();
    }
    return institutionInfoNormalRoomLimitMoneyLabel2;

  }

  /**
   * （多床室負担限度額・コンテナ）を取得します。
   * @return （多床室負担限度額・コンテナ）
   */
  public ACLabelContainer getInstitutionInfoTasyoRoomLimitMoneyContena(){
    if(institutionInfoTasyoRoomLimitMoneyContena==null){

      institutionInfoTasyoRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoTasyoRoomLimitMoneyContena.setText("多床室");

      addInstitutionInfoTasyoRoomLimitMoneyContena();
    }
    return institutionInfoTasyoRoomLimitMoneyContena;

  }

  /**
   * 多床室負担限度額・テキストを取得します。
   * @return 多床室負担限度額・テキスト
   */
  public ACTextField getInstitutionInfoTasyoRoomLimitMoneyText(){
    if(institutionInfoTasyoRoomLimitMoneyText==null){

      institutionInfoTasyoRoomLimitMoneyText = new ACTextField();

      institutionInfoTasyoRoomLimitMoneyText.setBindPath("LIMIT_TASHOSHITSU");

      institutionInfoTasyoRoomLimitMoneyText.setColumns(4);

      institutionInfoTasyoRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoTasyoRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoTasyoRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoTasyoRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoTasyoRoomLimitMoneyText();
    }
    return institutionInfoTasyoRoomLimitMoneyText;

  }

  /**
   * 多床室負担限度額・ラベルを取得します。
   * @return 多床室負担限度額・ラベル
   */
  public ACLabel getInstitutionInfoTasyoRoomLimitMoneyLabel(){
    if(institutionInfoTasyoRoomLimitMoneyLabel==null){

      institutionInfoTasyoRoomLimitMoneyLabel = new ACLabel();

      institutionInfoTasyoRoomLimitMoneyLabel.setText("（円）");

      addInstitutionInfoTasyoRoomLimitMoneyLabel();
    }
    return institutionInfoTasyoRoomLimitMoneyLabel;

  }

  /**
   * 介護老人福祉施設・ラベルを取得します。
   * @return 介護老人福祉施設・ラベル
   */
  public ACLabel getInstitutionInfoCareOldPersonLabel(){
    if(institutionInfoCareOldPersonLabel==null){

      institutionInfoCareOldPersonLabel = new ACLabel();

      institutionInfoCareOldPersonLabel.setText("介護老人福祉施設");

      addInstitutionInfoCareOldPersonLabel();
    }
    return institutionInfoCareOldPersonLabel;

  }

  /**
   * スペース3を取得します。
   * @return スペース3
   */
  public ACLabel getInstitutionInfoSpace3(){
    if(institutionInfoSpace3==null){

      institutionInfoSpace3 = new ACLabel();

      institutionInfoSpace3.setText(" ");

      addInstitutionInfoSpace3();
    }
    return institutionInfoSpace3;

  }

  /**
   * 旧措置入所者特例を取得します。
   * @return 旧措置入所者特例
   */
  public ACIntegerCheckBox getInstitutionInfoOldStep(){
    if(institutionInfoOldStep==null){

      institutionInfoOldStep = new ACIntegerCheckBox();

      institutionInfoOldStep.setText("旧措置入所者特例");

      institutionInfoOldStep.setBindPath("KYUSOCHI_FLAG");

      institutionInfoOldStep.setSelectValue(2);

      institutionInfoOldStep.setUnSelectValue(1);

      addInstitutionInfoOldStep();
    }
    return institutionInfoOldStep;

  }

  /**
   * 介護老人保健施設・介護療養型医療施設を取得します。
   * @return 介護老人保健施設・介護療養型医療施設
   */
  public ACLabel getInstitutionInfoCareOldPersonInsuranceLabel(){
    if(institutionInfoCareOldPersonInsuranceLabel==null){

      institutionInfoCareOldPersonInsuranceLabel = new ACLabel();

      institutionInfoCareOldPersonInsuranceLabel.setText("介護老人保健施設・介護療養型医療施設");

      addInstitutionInfoCareOldPersonInsuranceLabel();
    }
    return institutionInfoCareOldPersonInsuranceLabel;

  }

  /**
   * スペース4を取得します。
   * @return スペース4
   */
  public ACLabel getInstitutionInfoSpace4(){
    if(institutionInfoSpace4==null){

      institutionInfoSpace4 = new ACLabel();

      addInstitutionInfoSpace4();
    }
    return institutionInfoSpace4;

  }

  /**
   * 主傷病を取得します。
   * @return 主傷病
   */
  public ACTextField getInstitutionInfoMainDisease(){
    if(institutionInfoMainDisease==null){

      institutionInfoMainDisease = new ACTextField();

      getInstitutionInfoMainDiseaseContainer().setText("主傷病");

      institutionInfoMainDisease.setBindPath("DISEASE");

      institutionInfoMainDisease.setColumns(15);

      institutionInfoMainDisease.setIMEMode(InputSubset.KANJI);

      institutionInfoMainDisease.setMaxLength(64);

      addInstitutionInfoMainDisease();
    }
    return institutionInfoMainDisease;

  }

  /**
   * 主傷病コンテナを取得します。
   * @return 主傷病コンテナ
   */
  protected ACLabelContainer getInstitutionInfoMainDiseaseContainer(){
    if(institutionInfoMainDiseaseContainer==null){
      institutionInfoMainDiseaseContainer = new ACLabelContainer();
      institutionInfoMainDiseaseContainer.setFollowChildEnabled(true);
      institutionInfoMainDiseaseContainer.setVAlignment(VRLayout.CENTER);
      institutionInfoMainDiseaseContainer.add(getInstitutionInfoMainDisease(), null);
    }
    return institutionInfoMainDiseaseContainer;
  }

  /**
   * スペース5を取得します。
   * @return スペース5
   */
  public ACLabel getInstitutionInfoSpace5(){
    if(institutionInfoSpace5==null){

      institutionInfoSpace5 = new ACLabel();

      institutionInfoSpace5.setText("　");

      addInstitutionInfoSpace5();
    }
    return institutionInfoSpace5;

  }

  /**
   * (説明文グループ)を取得します。
   * @return (説明文グループ)
   */
  public ACGroupBox getInstitutionInfoExplanationGroup(){
    if(institutionInfoExplanationGroup==null){

      institutionInfoExplanationGroup = new ACGroupBox();

      institutionInfoExplanationGroup.setAutoWrap(true);

      institutionInfoExplanationGroup.setHgap(0);

      addInstitutionInfoExplanationGroup();
    }
    return institutionInfoExplanationGroup;

  }

  /**
   * 説明文ラベル1を取得します。
   * @return 説明文ラベル1
   */
  public ACLabel getInstitutionInfoExplanationLabel1(){
    if(institutionInfoExplanationLabel1==null){

      institutionInfoExplanationLabel1 = new ACLabel();

      institutionInfoExplanationLabel1.setText("入院・入所日の設定方法");

      institutionInfoExplanationLabel1.setIconPath(ACConstants.ICON_PATH_INFORMATION_24);

      addInstitutionInfoExplanationLabel1();
    }
    return institutionInfoExplanationLabel1;

  }

  /**
   * 説明文ラベル2を取得します。
   * @return 説明文ラベル2
   */
  public ACLabel getInstitutionInfoExplanationLabel2(){
    if(institutionInfoExplanationLabel2==null){

      institutionInfoExplanationLabel2 = new ACLabel();

      institutionInfoExplanationLabel2.setText("　異動情報にて施設系サービスを選択し、設定を　");

      addInstitutionInfoExplanationLabel2();
    }
    return institutionInfoExplanationLabel2;

  }

  /**
   * 説明文ラベル3を取得します。
   * @return 説明文ラベル3
   */
  public ACLabel getInstitutionInfoExplanationLabel3(){
    if(institutionInfoExplanationLabel3==null){

      institutionInfoExplanationLabel3 = new ACLabel();

      institutionInfoExplanationLabel3.setText("　行ってください。");

      addInstitutionInfoExplanationLabel3();
    }
    return institutionInfoExplanationLabel3;

  }

  /**
   * コンストラクタです。
   */
  public QU002Design() {

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
   * (業務ボタンバー)に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClearUpdateMode(), VRLayout.EAST);
    buttons.add(getClearInsertMode(), VRLayout.EAST);
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
   * クリアに内部項目を追加します。
   */
  protected void addClearInsertMode(){

  }

  /**
   * 新規に内部項目を追加します。
   */
  protected void addClearUpdateMode(){

  }

  /**
   * (クライアント領域)に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getBasicInfoAndInfoButtons(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * (クライアント領域・レイアウト)に内部項目を追加します。
   */
  protected void addContentsLayout(){

  }

  /**
   * (基本情報・ボタン領域)に内部項目を追加します。
   */
  protected void addBasicInfoAndInfoButtons(){

    basicInfoAndInfoButtons.add(getBasicInfoAndInfoButtonFlame(), VRLayout.CLIENT);

    basicInfoAndInfoButtons.add(getInfoButtons(), VRLayout.EAST);
  }

  /**
   * (基本情報・ボタン領域・グループ)に内部項目を追加します。
   */
  protected void addBasicInfoAndInfoButtonFlame(){

    basicInfoAndInfoButtonFlame.add(getBasicInfoAndInfoButton(), VRLayout.FLOW);

  }

  /**
   * (基本情報・ボタンレイアウト)に内部項目を追加します。
   */
  protected void addBasicInfoAndInfoButtonLayout(){

  }

  /**
   * (基本情報領域)に内部項目を追加します。
   */
  protected void addBasicInfoAndInfoButton(){

    basicInfoAndInfoButton.add(getBasicInfoPatientCdContainer(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoSexsContainer(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoCheck(), VRLayout.FLOW_INSETLINE_RETURN);

    basicInfoAndInfoButton.add(getBasicInfoNameContena(), VRLayout.FLOW_DOUBLEINSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoBirthContena(), VRLayout.FLOW_INSETLINE_RETURN);

    basicInfoAndInfoButton.add(getBasicInfoFuriganaContena(), VRLayout.FLOW_DOUBLEINSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

    basicInfoAndInfoButton.add(getBasicInfoZips(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoAddressContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (基本情報領域・レイアウト)に内部項目を追加します。
   */
  protected void addBasicInfoLayout(){

  }

  /**
   * 利用者Cdに内部項目を追加します。
   */
  protected void addBasicInfoPatientCd(){

  }

  /**
   * 性別に内部項目を追加します。
   */
  protected void addBasicInfoSexs(){

  }

  /**
   * 性別モデルに内部項目を追加します。
   */
  protected void addBasicInfoSexsModel(){

    getBasicInfoMan().setButtonIndex(1);

    getBasicInfoSexsModel().add(getBasicInfoMan());

    getBasicInfoWoman().setButtonIndex(2);

    getBasicInfoSexsModel().add(getBasicInfoWoman());

  }

  /**
   * 男に内部項目を追加します。
   */
  protected void addBasicInfoMan(){

  }

  /**
   * 女に内部項目を追加します。
   */
  protected void addBasicInfoWoman(){

  }

  /**
   * 一覧に表示・チェックに内部項目を追加します。
   */
  protected void addBasicInfoCheck(){

  }

  /**
   * (氏名・コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoNameContena(){

    basicInfoNameContena.add(getBasicInfoFamilyNameContena(), VRLayout.FLOW);

    basicInfoNameContena.add(getBasicInfoFirstNameContena(), VRLayout.FLOW);

  }

  /**
   * (氏名1・背面コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoFamilyNameContena(){

    basicInfoFamilyNameContena.add(getBasicInfoName1(), VRLayout.FLOW);

  }

  /**
   * 氏名1に内部項目を追加します。
   */
  protected void addBasicInfoName1(){

  }

  /**
   * (氏名2・背面コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoFirstNameContena(){

    basicInfoFirstNameContena.add(getBasicInfoName2(), VRLayout.FLOW);

  }

  /**
   * 氏名2に内部項目を追加します。
   */
  protected void addBasicInfoName2(){

  }

  /**
   * (生年月日・コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoBirthContena(){

    basicInfoBirthContena.add(getBasicInfoBirth(), VRLayout.FLOW);

    basicInfoBirthContena.add(getBasicInfoAgeLabel1(), VRLayout.FLOW);

    basicInfoBirthContena.add(getBasicInfoAge(), VRLayout.FLOW);

    basicInfoBirthContena.add(getBasicInfoAgeLabel2(), VRLayout.FLOW);

  }

  /**
   * 生年月日に内部項目を追加します。
   */
  protected void addBasicInfoBirth(){

  }

  /**
   * 年齢ラベルに内部項目を追加します。
   */
  protected void addBasicInfoAgeLabel1(){

  }

  /**
   * 年齢に内部項目を追加します。
   */
  protected void addBasicInfoAge(){

  }

  /**
   * 歳ラベルに内部項目を追加します。
   */
  protected void addBasicInfoAgeLabel2(){

  }

  /**
   * (フリガナ・コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoFuriganaContena(){

    basicInfoFuriganaContena.add(getBasicInfoFamilyFuriganaContena(), VRLayout.FLOW);

    basicInfoFuriganaContena.add(getBasicInfoFirstFuriganaContena(), VRLayout.FLOW);

  }

  /**
   * (フリガナ1・背面コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoFamilyFuriganaContena(){

    basicInfoFamilyFuriganaContena.add(getBasicInfoFurigana1(), VRLayout.FLOW);

  }

  /**
   * フリガナ1に内部項目を追加します。
   */
  protected void addBasicInfoFurigana1(){

  }

  /**
   * (フリガナ2・背面コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoFirstFuriganaContena(){

    basicInfoFirstFuriganaContena.add(getBasicInfoFurigana2(), VRLayout.FLOW);

  }

  /**
   * フリガナ2に内部項目を追加します。
   */
  protected void addBasicInfoFurigana2(){

  }

  /**
   * (電話番号・コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoTelContena(){

    basicInfoTelContena.add(getBasicInfoTel2(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel3(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel4(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel5(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel6(), VRLayout.FLOW);

  }

  /**
   * 電話番号・テキスト1に内部項目を追加します。
   */
  protected void addBasicInfoTel2(){

  }

  /**
   * 電話番号・ラベル1に内部項目を追加します。
   */
  protected void addBasicInfoTel3(){

  }

  /**
   * 電話番号・テキスト2に内部項目を追加します。
   */
  protected void addBasicInfoTel4(){

  }

  /**
   * 電話番号・ラベル2に内部項目を追加します。
   */
  protected void addBasicInfoTel5(){

  }

  /**
   * 電話番号・テキスト3に内部項目を追加します。
   */
  protected void addBasicInfoTel6(){

  }

  /**
   * (郵便番号・コンテナ)に内部項目を追加します。
   */
  protected void addBasicInfoZips(){

    basicInfoZips.add(getBasicInfoZip1(), VRLayout.FLOW);

    basicInfoZips.add(getBasicInfoZip2(), VRLayout.FLOW);

    basicInfoZips.add(getBasicInfoZip3(), VRLayout.FLOW);

  }

  /**
   * 郵便番号テキスト1に内部項目を追加します。
   */
  protected void addBasicInfoZip1(){

  }

  /**
   * 郵便番号・ラベル1に内部項目を追加します。
   */
  protected void addBasicInfoZip2(){

  }

  /**
   * 郵便番号テキスト2に内部項目を追加します。
   */
  protected void addBasicInfoZip3(){

  }

  /**
   * 住所に内部項目を追加します。
   */
  protected void addBasicInfoAddress(){

  }

  /**
   * (ボタン領域)に内部項目を追加します。
   */
  protected void addInfoButtons(){

    infoButtons.add(getToKohiInfoButton(), VRLayout.FLOW);

  }

  /**
   * 公費・社福軽減情報に内部項目を追加します。
   */
  protected void addToKohiInfoButton(){

  }

  /**
   * (タブ)に内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("介護保険情報", getKaigoInfoAndIdouInfos());

    tabs.addTab("異動・施設情報", getIdouInfoAndInstitutionInfoPanel());

  }

  /**
   * (介護保険情報・異動情報領域)に内部項目を追加します。
   */
  protected void addKaigoInfoAndIdouInfos(){

    kaigoInfoAndIdouInfos.add(getKaigoInfos(), VRLayout.CLIENT);

  }

  /**
   * (介護保険情報領域)に内部項目を追加します。
   */
  protected void addKaigoInfos(){

    kaigoInfos.add(getKaigoInfoRyo(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoTable(), VRLayout.CLIENT);

  }

  /**
   * (介護保険情報領域・レイアウト)に内部項目を追加します。
   */
  protected void addKaigoInfoLayout(){

  }

  /**
   * (介護保険領域)に内部項目を追加します。
   */
  protected void addKaigoInfoRyo(){

    kaigoInfoRyo.add(getKaigoInfo(), VRLayout.NORTH);

    kaigoInfoRyo.add(getKaigoInfoButtons(), VRLayout.NORTH);

  }

  /**
   * (介護保険領域)に内部項目を追加します。
   */
  protected void addKaigoInfo(){

    kaigoInfo.add(getKaigoInfoInsurerIdContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getYokaigodoNowContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoInsuredIdContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBenefitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoKyotakuServiceContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoReportDateContainer(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDivisionContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoYokaigoInfoContainer(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoValidLimits(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDateContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoAuthorizeDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoProvideLimitGroup(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoInterruptionGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * (介護保険領域・レイアウト)に内部項目を追加します。
   */
  protected void addKaigoInfoLayout2(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addKaigoInfoInsurerId(){

  }

  /**
   * 保険者名に内部項目を追加します。
   */
  protected void addKaigoInfoInsurerName(){

  }

  /**
   * 保険者名モデルに内部項目を追加します。
   */
  protected void addKaigoInfoInsurerNameModel(){

  }

  /**
   * 現在の要介護度に内部項目を追加します。
   */
  protected void addYokaigodoNow(){

  }

  /**
   * 被保険者番号に内部項目を追加します。
   */
  protected void addKaigoInfoInsuredId(){

  }

  /**
   * (給付率領域・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoBenefitContainer(){

    kaigoInfoBenefitContainer.add(getKaigoInfoBenefit(), VRLayout.FLOW);

    kaigoInfoBenefitContainer.add(getKaigoInfoBenefitPercent(), VRLayout.FLOW);

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addKaigoInfoBenefit(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoBenefitPercent(){

  }

  /**
   * (居宅サービス計画作成者・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceContena(){

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServiceRadio(), VRLayout.FLOW);

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServicePlanCombo(), VRLayout.FLOW);

  }

  /**
   * (居宅サービス計画作成者・コンテナ・レイアウト)に内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceContenaLayout(){

  }

  /**
   * 居宅サービス・ラジオグループに内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceRadio(){

  }

  /**
   * 居宅サービス・ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceRadioModel(){

    getKaigoInfoKyotakuServiceRadioItem1().setButtonIndex(1);

    getKaigoInfoKyotakuServiceRadioModel().add(getKaigoInfoKyotakuServiceRadioItem1());

    getKaigoInfoKyotakuServiceRadioItem2().setButtonIndex(2);

    getKaigoInfoKyotakuServiceRadioModel().add(getKaigoInfoKyotakuServiceRadioItem2());

    getKaigoInfoKyotakuServiceRadioItem3().setButtonIndex(3);

    getKaigoInfoKyotakuServiceRadioModel().add(getKaigoInfoKyotakuServiceRadioItem3());

  }

  /**
   * 居宅介護支援事業所に内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceRadioItem1(){

  }

  /**
   * 被保険者に内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceRadioItem2(){

  }

  /**
   * 介護予防支援事業所に内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceRadioItem3(){

  }

  /**
   * 居宅サービス計画作成者・コンボに内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServicePlanCombo(){

  }

  /**
   * 居宅サービス計画作成者・コンボモデルに内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServicePlanComboModel(){

  }

  /**
   * 居宅サービス計画作成依頼届出日に内部項目を追加します。
   */
  protected void addKaigoInfoReportDate(){

  }

  /**
   * (申請区分・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoRequestDivisionContena(){

    kaigoInfoRequestDivisionContena.add(getKaigoInfoRequestDivisionRadio(), VRLayout.FLOW);

    kaigoInfoRequestDivisionContena.add(getKaigoInfoRequests(), VRLayout.FLOW);

  }

  /**
   * 申請区分・ラジオグループに内部項目を追加します。
   */
  protected void addKaigoInfoRequestDivisionRadio(){

  }

  /**
   * 申請区分・ラジオグループモデルに内部項目を追加します。
   */
  protected void addKaigoInfoRequestDivisionRadioModel(){

    getKaigoInfoRequestDivisionRadioItem1().setButtonIndex(1);

    getKaigoInfoRequestDivisionRadioModel().add(getKaigoInfoRequestDivisionRadioItem1());

    getKaigoInfoRequestDivisionRadioItem2().setButtonIndex(2);

    getKaigoInfoRequestDivisionRadioModel().add(getKaigoInfoRequestDivisionRadioItem2());

    getKaigoInfoRequestDivisionRadioItem3().setButtonIndex(3);

    getKaigoInfoRequestDivisionRadioModel().add(getKaigoInfoRequestDivisionRadioItem3());

  }

  /**
   * 期間終了後新規に内部項目を追加します。
   */
  protected void addKaigoInfoRequestDivisionRadioItem1(){

  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addKaigoInfoRequestDivisionRadioItem2(){

  }

  /**
   * 変更に内部項目を追加します。
   */
  protected void addKaigoInfoRequestDivisionRadioItem3(){

  }

  /**
   * 申請中に内部項目を追加します。
   */
  protected void addKaigoInfoRequests(){

  }

  /**
   * 要介護情報に内部項目を追加します。
   */
  protected void addKaigoInfoYokaigoInfo(){

  }

  /**
   * 要介護情報モデルに内部項目を追加します。
   */
  protected void addKaigoInfoYokaigoInfoModel(){

  }

  /**
   * (有効期間・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoValidLimits(){

    kaigoInfoValidLimits.add(getKaigoInfoValidLimit1(), VRLayout.FLOW);

    kaigoInfoValidLimits.add(getKaigoInfoValidLimit2(), VRLayout.FLOW);

    kaigoInfoValidLimits.add(getKaigoInfoValidLimit3(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addKaigoInfoValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoValidLimit2(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addKaigoInfoValidLimit3(){

  }

  /**
   * 申請日に内部項目を追加します。
   */
  protected void addKaigoInfoRequestDate(){

  }

  /**
   * 認定日に内部項目を追加します。
   */
  protected void addKaigoInfoAuthorizeDate(){

  }

  /**
   * (支給限度額グループ)に内部項目を追加します。
   */
  protected void addKaigoInfoProvideLimitGroup(){

    kaigoInfoProvideLimitGroup.add(getKaigoInfoProvideLimitContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfoProvideLimitGroup.add(getKaigoInfoExternalUseLimitContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * (支給限度額・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoProvideLimitContena(){

    kaigoInfoProvideLimitContena.add(getKaigoInfoProvideLimit(), VRLayout.FLOW);

    kaigoInfoProvideLimitContena.add(getKaigoInfoProvideLimitLabel(), VRLayout.FLOW);

  }

  /**
   * 支給限度額に内部項目を追加します。
   */
  protected void addKaigoInfoProvideLimit(){

  }

  /**
   * 単位ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoProvideLimitLabel(){

  }

  /**
   * (外部利用型給付上限単位数・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoExternalUseLimitContena(){

    kaigoInfoExternalUseLimitContena.add(getKaigoInfoExternalUseLimit(), VRLayout.FLOW);

    kaigoInfoExternalUseLimitContena.add(getKaigoInfoExternalUseLimitLabel(), VRLayout.FLOW);

  }

  /**
   * 外部利用型給付上限単位数に内部項目を追加します。
   */
  protected void addKaigoInfoExternalUseLimit(){

  }

  /**
   * 単位ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoExternalUseLimitLabel(){

  }

  /**
   * (中断日・中断理由グループ)に内部項目を追加します。
   */
  protected void addKaigoInfoInterruptionGroup(){

    kaigoInfoInterruptionGroup.add(getKaigoInfoInterruptionDateContainer(), VRLayout.FLOW);

    kaigoInfoInterruptionGroup.add(getKaigoInfoInterruptionReasonRadioContainer(), VRLayout.FLOW_RETURN);

    kaigoInfoInterruptionGroup.add(getKaigoInfoExplanationLabel1(), VRLayout.FLOW);

  }

  /**
   * 中断日に内部項目を追加します。
   */
  protected void addKaigoInfoInterruptionDate(){

  }

  /**
   * 中断理由に内部項目を追加します。
   */
  protected void addKaigoInfoInterruptionReasonRadio(){

  }

  /**
   * 中断理由モデルに内部項目を追加します。
   */
  protected void addKaigoInfoInterruptionReasonRadioModel(){

    getKaigoInfoInterruptionReasonRadioItem1().setButtonIndex(1);

    getKaigoInfoInterruptionReasonRadioModel().add(getKaigoInfoInterruptionReasonRadioItem1());

    getKaigoInfoInterruptionReasonRadioItem2().setButtonIndex(2);

    getKaigoInfoInterruptionReasonRadioModel().add(getKaigoInfoInterruptionReasonRadioItem2());

    getKaigoInfoInterruptionReasonRadioItem3().setButtonIndex(3);

    getKaigoInfoInterruptionReasonRadioModel().add(getKaigoInfoInterruptionReasonRadioItem3());

  }

  /**
   * 非更新に内部項目を追加します。
   */
  protected void addKaigoInfoInterruptionReasonRadioItem1(){

  }

  /**
   * 非該当に内部項目を追加します。
   */
  protected void addKaigoInfoInterruptionReasonRadioItem2(){

  }

  /**
   * 死亡に内部項目を追加します。
   */
  protected void addKaigoInfoInterruptionReasonRadioItem3(){

  }

  /**
   * 説明文ラベル1に内部項目を追加します。
   */
  protected void addKaigoInfoExplanationLabel1(){

  }

  /**
   * (介護保険情報・ボタン領域)に内部項目を追加します。
   */
  protected void addKaigoInfoButtons(){

    kaigoInfoButtons.add(getKaigoInfoButtonClear(), VRLayout.WEST);

    kaigoInfoButtons.add(getKaigoInfoButtonInsert(), VRLayout.WEST);

    kaigoInfoButtons.add(getKaigoInfoButtonEdit(), VRLayout.WEST);

    kaigoInfoButtons.add(getKaigoInfoDelete(), VRLayout.WEST);

  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addKaigoInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addKaigoInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addKaigoInfoButtonEdit(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addKaigoInfoDelete(){

  }

  /**
   * (介護情報・テーブル領域)に内部項目を追加します。
   */
  protected void addKaigoInfoTable(){

  }

  /**
   * (介護情報・テーブル領域)カラムモデルに内部項目を追加します。
   */
  protected void addKaigoInfoTableColumnModel(){

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn0());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn1());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn2());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn3());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn4());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn5());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn6());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn7());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn8());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn9());

  }

  /**
   * Noに内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn0(){

  }

  /**
   * 申請日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn1(){

  }

  /**
   * 申請区分に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn2(){

  }

  /**
   * 要介護情報に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn3(){

  }

  /**
   * 有効期間開始日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn4(){

  }

  /**
   * 有効期間終了日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn5(){

  }

  /**
   * 作成依頼届出日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn6(){

  }

  /**
   * 中断年月日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn7(){

  }

  /**
   * 中断理由に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn8(){

  }

  /**
   * 支給限度額に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn9(){

  }

  /**
   * (異動・施設情報・パネル)に内部項目を追加します。
   */
  protected void addIdouInfoAndInstitutionInfoPanel(){

    idouInfoAndInstitutionInfoPanel.add(getIdouInfoAndInstitutionInfos(), VRLayout.CLIENT);

    idouInfoAndInstitutionInfoPanel.add(getInstitutionInfos(), VRLayout.EAST);
  }

  /**
   * (異動情報領域・グループ)に内部項目を追加します。
   */
  protected void addIdouInfoAndInstitutionInfos(){

    idouInfoAndInstitutionInfos.add(getIdouInfoUp(), VRLayout.NORTH);

    idouInfoAndInstitutionInfos.add(getIdouInfoTable(), VRLayout.CLIENT);

  }

  /**
   * (異動・施設情報領域・レイアウト)に内部項目を追加します。
   */
  protected void addIdouInfoAndInstitutionInfoLayout(){

  }

  /**
   * (異動情報領域・上)に内部項目を追加します。
   */
  protected void addIdouInfoUp(){

    idouInfoUp.add(getIdouInfo(), VRLayout.NORTH);

    idouInfoUp.add(getIdouInfoButtons(), VRLayout.NORTH);

  }

  /**
   * (異動情報領域)に内部項目を追加します。
   */
  protected void addIdouInfo(){

    idouInfo.add(getIdouInfoServiseContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    idouInfo.add(getIdouInfoChangeContentContainer(), VRLayout.FLOW_INSETLINE);

    idouInfo.add(getIdouInfoDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    idouInfo.add(getIdouInfoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    idouInfo.add(getIdouInfoReasonContainer(), VRLayout.FLOW_INSETLINE);

    idouInfo.add(getIdouInfoReasonMemoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (異動情報領域・レイアウト)に内部項目を追加します。
   */
  protected void addIdouInfoLayout2(){

  }

  /**
   * サービスに内部項目を追加します。
   */
  protected void addIdouInfoServise(){

  }

  /**
   * サービスモデルに内部項目を追加します。
   */
  protected void addIdouInfoServiseModel(){

  }

  /**
   * 異動事由に内部項目を追加します。
   */
  protected void addIdouInfoChangeContent(){

  }

  /**
   * 異動事由モデルに内部項目を追加します。
   */
  protected void addIdouInfoChangeContentModel(){

  }

  /**
   * 日付に内部項目を追加します。
   */
  protected void addIdouInfoDate(){

  }

  /**
   * 時間に内部項目を追加します。
   */
  protected void addIdouInfoTime(){

  }

  /**
   * 理由/状況に内部項目を追加します。
   */
  protected void addIdouInfoReason(){

  }

  /**
   * 理由/状況モデルに内部項目を追加します。
   */
  protected void addIdouInfoReasonModel(){

  }

  /**
   * その他　内容に内部項目を追加します。
   */
  protected void addIdouInfoReasonMemo(){

  }

  /**
   * (異動情報・ボタン領域)に内部項目を追加します。
   */
  protected void addIdouInfoButtons(){

    idouInfoButtons.add(getIdouInfoButtonDelete(), VRLayout.EAST);
    idouInfoButtons.add(getIdouInfoButtonEdit(), VRLayout.EAST);
    idouInfoButtons.add(getIdouInfoButtonInsert(), VRLayout.EAST);
    idouInfoButtons.add(getIdouInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addIdouInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addIdouInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addIdouInfoButtonEdit(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addIdouInfoButtonDelete(){

  }

  /**
   * (異動情報・テーブル領域)に内部項目を追加します。
   */
  protected void addIdouInfoTable(){

  }

  /**
   * (異動情報・テーブル領域)カラムモデルに内部項目を追加します。
   */
  protected void addIdouInfoTableColumnModel(){

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn0());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn1());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn2());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn3());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn4());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn5());

  }

  /**
   * Noに内部項目を追加します。
   */
  protected void addIdouInfoTableColumn0(){

  }

  /**
   * サービスに内部項目を追加します。
   */
  protected void addIdouInfoTableColumn1(){

  }

  /**
   * 異動事由に内部項目を追加します。
   */
  protected void addIdouInfoTableColumn2(){

  }

  /**
   * 日付に内部項目を追加します。
   */
  protected void addIdouInfoTableColumn3(){

  }

  /**
   * 時間に内部項目を追加します。
   */
  protected void addIdouInfoTableColumn4(){

  }

  /**
   * 理由/状況に内部項目を追加します。
   */
  protected void addIdouInfoTableColumn5(){

  }

  /**
   * (施設情報・領域・グループ)に内部項目を追加します。
   */
  protected void addInstitutionInfos(){

    institutionInfos.add(getInstitutionInfoBearMoneyInfos(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace1(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoTokuteiNyusho(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace2(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoDinnerBearLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoUnitRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoUnitSemiRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoNormalRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoNormalRoomLimitMoneyContena2(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoTasyoRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoCareOldPersonLabel(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace3(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoOldStep(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoCareOldPersonInsuranceLabel(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace4(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoMainDiseaseContainer(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace5(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoExplanationGroup(), VRLayout.FLOW);

  }

  /**
   * (施設情報領域・レイアウト)に内部項目を追加します。
   */
  protected void addInstitutionInfoLayout(){

  }

  /**
   * 利用者負担限度額ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoBearMoneyInfos(){

  }

  /**
   * スペース1に内部項目を追加します。
   */
  protected void addInstitutionInfoSpace1(){

  }

  /**
   * 特定入所者チェックに内部項目を追加します。
   */
  protected void addInstitutionInfoTokuteiNyusho(){

  }

  /**
   * スペース2に内部項目を追加します。
   */
  protected void addInstitutionInfoSpace2(){

  }

  /**
   * （食費負担限度額・コンテナ）に内部項目を追加します。
   */
  protected void addInstitutionInfoDinnerBearLimitMoneyContena(){

    institutionInfoDinnerBearLimitMoneyContena.add(getInstitutionInfoDinnerBearLimitMoneyText(), null);

    institutionInfoDinnerBearLimitMoneyContena.add(getInstitutionInfoDinnerBearLimitMoneyLabel(), null);

  }

  /**
   * 食費負担限度額・テキストに内部項目を追加します。
   */
  protected void addInstitutionInfoDinnerBearLimitMoneyText(){

  }

  /**
   * 食費負担限度額・ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoDinnerBearLimitMoneyLabel(){

  }

  /**
   * （ユニット型個室負担限度額・コンテナ）に内部項目を追加します。
   */
  protected void addInstitutionInfoUnitRoomLimitMoneyContena(){

    institutionInfoUnitRoomLimitMoneyContena.add(getInstitutionInfoUnitRoomLimitMoneyText(), null);

    institutionInfoUnitRoomLimitMoneyContena.add(getInstitutionInfoUnitRoomLimitMoneyLabel(), null);

  }

  /**
   * ユニット型個室負担限度額・テキストに内部項目を追加します。
   */
  protected void addInstitutionInfoUnitRoomLimitMoneyText(){

  }

  /**
   * ユニット型個室負担限度額・ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoUnitRoomLimitMoneyLabel(){

  }

  /**
   * （ユニット型準個室負担限度額・コンテナ）に内部項目を追加します。
   */
  protected void addInstitutionInfoUnitSemiRoomLimitMoneyContena(){

    institutionInfoUnitSemiRoomLimitMoneyContena.add(getInstitutionInfoUnitSemiRoomLimitMoneyText(), null);

    institutionInfoUnitSemiRoomLimitMoneyContena.add(getInstitutionInfoUnitSemiRoomLimitMoneyLabel(), null);

  }

  /**
   * ユニット型準個室負担限度額・テキストに内部項目を追加します。
   */
  protected void addInstitutionInfoUnitSemiRoomLimitMoneyText(){

  }

  /**
   * ユニット型準個室負担限度額・ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoUnitSemiRoomLimitMoneyLabel(){

  }

  /**
   * （従来型個室（特養等）負担限度額・コンテナ）に内部項目を追加します。
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyContena(){

    institutionInfoNormalRoomLimitMoneyContena.add(getInstitutionInfoNormalRoomLimitMoneyText(), null);

    institutionInfoNormalRoomLimitMoneyContena.add(getInstitutionInfoNormalRoomLimitMoneyLabel(), null);

  }

  /**
   * 従来型個室（特養等）負担限度額・テキストに内部項目を追加します。
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyText(){

  }

  /**
   * 従来型個室（特養等）負担限度額・ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyLabel(){

  }

  /**
   * （従来型個室（老健・療養等）負担限度額・コンテナ）に内部項目を追加します。
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyContena2(){

    institutionInfoNormalRoomLimitMoneyContena2.add(getInstitutionInfoNormalRoomLimitMoneyText2(), null);

    institutionInfoNormalRoomLimitMoneyContena2.add(getInstitutionInfoNormalRoomLimitMoneyLabel2(), null);

  }

  /**
   * 従来型個室（老健・療養等）負担限度額・テキストに内部項目を追加します。
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyText2(){

  }

  /**
   * 従来型個室（老健・療養等）負担限度額・ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyLabel2(){

  }

  /**
   * （多床室負担限度額・コンテナ）に内部項目を追加します。
   */
  protected void addInstitutionInfoTasyoRoomLimitMoneyContena(){

    institutionInfoTasyoRoomLimitMoneyContena.add(getInstitutionInfoTasyoRoomLimitMoneyText(), null);

    institutionInfoTasyoRoomLimitMoneyContena.add(getInstitutionInfoTasyoRoomLimitMoneyLabel(), null);

  }

  /**
   * 多床室負担限度額・テキストに内部項目を追加します。
   */
  protected void addInstitutionInfoTasyoRoomLimitMoneyText(){

  }

  /**
   * 多床室負担限度額・ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoTasyoRoomLimitMoneyLabel(){

  }

  /**
   * 介護老人福祉施設・ラベルに内部項目を追加します。
   */
  protected void addInstitutionInfoCareOldPersonLabel(){

  }

  /**
   * スペース3に内部項目を追加します。
   */
  protected void addInstitutionInfoSpace3(){

  }

  /**
   * 旧措置入所者特例に内部項目を追加します。
   */
  protected void addInstitutionInfoOldStep(){

  }

  /**
   * 介護老人保健施設・介護療養型医療施設に内部項目を追加します。
   */
  protected void addInstitutionInfoCareOldPersonInsuranceLabel(){

  }

  /**
   * スペース4に内部項目を追加します。
   */
  protected void addInstitutionInfoSpace4(){

  }

  /**
   * 主傷病に内部項目を追加します。
   */
  protected void addInstitutionInfoMainDisease(){

  }

  /**
   * スペース5に内部項目を追加します。
   */
  protected void addInstitutionInfoSpace5(){

  }

  /**
   * (説明文グループ)に内部項目を追加します。
   */
  protected void addInstitutionInfoExplanationGroup(){

    institutionInfoExplanationGroup.add(getInstitutionInfoExplanationLabel1(), VRLayout.NORTH);

    institutionInfoExplanationGroup.add(getInstitutionInfoExplanationLabel2(), VRLayout.NORTH);

    institutionInfoExplanationGroup.add(getInstitutionInfoExplanationLabel3(), VRLayout.NORTH);

  }

  /**
   * 説明文ラベル1に内部項目を追加します。
   */
  protected void addInstitutionInfoExplanationLabel1(){

  }

  /**
   * 説明文ラベル2に内部項目を追加します。
   */
  protected void addInstitutionInfoExplanationLabel2(){

  }

  /**
   * 説明文ラベル3に内部項目を追加します。
   */
  protected void addInstitutionInfoExplanationLabel3(){

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
      ACFrame.debugStart(new ACAffairInfo(QU002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QU002Design getThis() {
    return this;
  }
}
