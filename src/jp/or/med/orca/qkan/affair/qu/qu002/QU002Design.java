
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
 * 作成日: 2018/02/21  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者登録/修正 (U)
 * プロセス 利用者登録 (002)
 * プログラム 利用者登録 (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
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
 * 利用者登録画面項目デザイン(QU002) 
 */
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

  private ACTextField yokaigodoNow;

  private ACLabelContainer yokaigodoNowContainer;

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

  private ACTextField kaigoInfoInsuredId;

  private ACLabelContainer kaigoInfoInsuredIdContainer;

  private ACLabelContainer kaigoInfoBenefitContainer;

  private ACTextField kaigoInfoBenefit;

  private ACLabel kaigoInfoBenefitPercent;

  private ACLabelContainer kaigoInfoShortCounts;

  private ACTextField kaigoInfoShortCount;

  private ACLabel kaigoInfoShortCountDay;

  private ACLabelContainer kaigoInfoKyotakuServiceContena;

  private VRLayout kaigoInfoKyotakuServiceContenaLayout;

  private ACClearableRadioButtonGroup kaigoInfoKyotakuServiceRadio;

  private ACListModelAdapter kaigoInfoKyotakuServiceRadioModel;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem1;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem2;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem3;

  private QkanDateTextField kaigoInfoReportDate;

  private ACLabelContainer kaigoInfoReportDateContainer;

  private ACComboBox kaigoInfoKyotakuServicePlanCombo;

  private ACComboBoxModelAdapter kaigoInfoKyotakuServicePlanComboModel;

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

  private ACLabelContainer kaigoInfoLimitChanges;

  private ACIntegerCheckBox kaigoInfoLimitChange;

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

  private ACLabelContainer kaigoInfoSystemValidLimits;

  private QkanDateTextField kaigoInfoSystemValidLimit1;

  private ACLabel kaigoInfoSystemValidLimit2;

  private QkanDateTextField kaigoInfoSystemValidLimit3;

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

  private ACTableColumn kaigoInfoTableColumn10;

  private ACTableColumn kaigoInfoTableColumn11;

  private ACTableColumn kaigoInfoTableColumn12;

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

  private ACPanel shisetsuInfoPanel;

  private ACPanel shisetsuInputPanel;

  private ACPanel shisetsuInfSyokuhiPanel;

  private ACGroupBox shisetsuInfoSyokuhiGroup;

  private VRLayout shisetsuInfoSyokuhiLayout;

  private ACLabel shisetsuInfoSpaceLabel;

  private ACIntegerCheckBox shisetsuInfoTokuteiCheck;

  private ACLabelContainer shisetsuInfoDinnerBearLimitMoneyContena;

  private ACTextField shisetsuInfoDinnerBearLimitMoneyText;

  private ACLabel shisetsuInfoDinnerBearLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoUnitRoomLimitMoneyContena;

  private ACTextField shisetsuInfoUnitRoomLimitMoneyText;

  private ACLabel shisetsuInfoUnitRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoUnitSemiRoomLimitMoneyContena;

  private ACTextField shisetsuInfoUnitSemiRoomLimitMoneyText;

  private ACLabel shisetsuInfoUnitSemiRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoNormalRoomLimitMoneyContena;

  private ACTextField shisetsuInfoNormalRoomLimitMoneyText;

  private ACLabel shisetsuInfoNormalRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoNormalRoomLimitMoneyContena2;

  private ACTextField shisetsuInfoNormalRoomLimitMoneyText2;

  private ACLabel shisetsuInfoNormalRoomLimitMoneyLabel2;

  private ACLabelContainer shisetsuInfoTasyoRoomLimitMoneyContena;

  private ACTextField shisetsuInfoTasyoRoomLimitMoneyText;

  private ACLabel shisetsuInfoTasyoRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoTasyoRoomLimitMoneyContena2;

  private ACTextField shisetsuInfoTasyoRoomLimitMoneyText2;

  private ACLabel shisetsuInfoTasyoRoomLimitMoneyLabel2;

  private ACPanel shisetsuInfRigthtPanel;

  private ACGroupBox shisetsuInfoCareOldPersonGroup;

  private ACIntegerCheckBox shisetsuInfoOldStep;

  private ACGroupBox shisetsuInfoCareOldPersonInsuranceGroup;

  private ACTextField shisetsuInfoMainDisease;

  private ACLabelContainer shisetsuInfoMainDiseaseContainer;

  private ACGroupBox shisetsuInfoExplanationGroup;

  private ACLabel shisetsuInfoExplanationLabel1;

  private ACLabel shisetsuInfoExplanationLabel2;

  private ACPanel shisetsuInfoOtherPanel;

  private VRLayout shisetsuInfoOtherLayout;

  private ACPanel shisetsuInfoLimitPanel;

  private ACLabelContainer shisetsuInfoValidLimitContainer;

  private QkanDateTextField shisetsuInfoValidLimitDateStart;

  private ACLabel shisetsuInfoValidLimitLabel;

  private QkanDateTextField shisetsuInfoValidLimitDateEnd;

  private ACPanel shisetsuInfoButtons;

  private ACButton shisetsuInfoButtonClear;

  private ACButton shisetsuInfoButtonInsert;

  private ACButton shisetsuInfoButtonEdit;

  private ACButton shisetsuInfoButtonDelete;

  private ACTable shisetsuInfoTable;

  private VRTableColumnModel shisetsuInfoTableColumnModel;

  private ACTableColumn shisetsuInfoTableColumn0;

  private ACTableColumn shisetsuInfoTableColumn1;

  private ACTableColumn shisetsuInfoTableColumn2;

  private ACTableColumn shisetsuInfoTableColumn3;

  private ACTableColumn shisetsuInfoTableColumn4;

  private ACTableColumn shisetsuInfoTableColumn5;

  private ACPanel jushotiTokureiInfoPanel;

  private ACPanel jushotiTokureiInputPanel;

  private ACGroupBox jushotiTokureiInfoGroup;

  private VRLayout jushotiTokureiInfoLayout2;

  private ACTextField jushotiTokureiInfoInsurerId;

  private ACLabelContainer jushotiTokureiInfoInsurerIdContainer;

  private ACComboBox jushotiTokureiInfoInsurerName;

  private ACLabelContainer jushotiTokureiInfoInsurerNameContainer;

  private ACComboBoxModelAdapter jushotiTokureiInfoInsurerNameModel;

  private ACPanel jushotiTokureiInfoLimitPanel;

  private ACLabelContainer jushotiTokureiInfoValidLimitContainer;

  private QkanDateTextField jushotiTokureiInfoValidLimitDateStart;

  private ACLabel jushotiTokureiInfoValidLimitLabel;

  private QkanDateTextField jushotiTokureiInfoValidLimitDateEnd;

  private ACPanel jushotiTokureiInfoButtons;

  private ACButton jushotiTokureiInfoButtonClear;

  private ACButton jushotiTokureiInfoButtonInsert;

  private ACButton jushotiTokureiInfoButtonEdit;

  private ACButton jushotiTokureiInfoButtonDelete;

  private ACTable jushotiTokureiInfoTable;

  private VRTableColumnModel jushotiTokureiInfoTableColumnModel;

  private ACTableColumn jushotiTokureiInfoTableColumn0;

  private ACTableColumn jushotiTokureiInfoTableColumn1;

  private ACTableColumn jushotiTokureiInfoTableColumn2;

  private ACTableColumn jushotiTokureiInfoTableColumn3;

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
   * (短期入所利用日数の初期値・コンテナ)を取得します。
   * @return (短期入所利用日数の初期値・コンテナ)
   */
  public ACLabelContainer getKaigoInfoShortCounts(){
    if(kaigoInfoShortCounts==null){

      kaigoInfoShortCounts = new ACLabelContainer();

      kaigoInfoShortCounts.setText("短期入所利用日数の初期値");

      addKaigoInfoShortCounts();
    }
    return kaigoInfoShortCounts;

  }

  /**
   * 短期入所利用日数の初期値を取得します。
   * @return 短期入所利用日数の初期値
   */
  public ACTextField getKaigoInfoShortCount(){
    if(kaigoInfoShortCount==null){

      kaigoInfoShortCount = new ACTextField();

      kaigoInfoShortCount.setBindPath("SHORTSTAY_USE_INIT_COUNT");

      kaigoInfoShortCount.setColumns(3);

      kaigoInfoShortCount.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoShortCount.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoShortCount.setMaxLength(3);

      addKaigoInfoShortCount();
    }
    return kaigoInfoShortCount;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getKaigoInfoShortCountDay(){
    if(kaigoInfoShortCountDay==null){

      kaigoInfoShortCountDay = new ACLabel();

      kaigoInfoShortCountDay.setText(" 日");

      addKaigoInfoShortCountDay();
    }
    return kaigoInfoShortCountDay;

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

      kaigoInfoKyotakuServiceContenaLayout.setAutoWrap(false);

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

      kaigoInfoValidLimits.setText("認定有効期間");

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
   * (要支援１の額を超えてサービスを利用・コンテナ)を取得します。
   * @return (要支援１の額を超えてサービスを利用・コンテナ)
   */
  public ACLabelContainer getKaigoInfoLimitChanges(){
    if(kaigoInfoLimitChanges==null){

      kaigoInfoLimitChanges = new ACLabelContainer();

      addKaigoInfoLimitChanges();
    }
    return kaigoInfoLimitChanges;

  }

  /**
   * 要支援１の額を超えてサービスを利用を取得します。
   * @return 要支援１の額を超えてサービスを利用
   */
  public ACIntegerCheckBox getKaigoInfoLimitChange(){
    if(kaigoInfoLimitChange==null){

      kaigoInfoLimitChange = new ACIntegerCheckBox();

      kaigoInfoLimitChange.setText("要支援１の額を超えてサービスを利用");

      kaigoInfoLimitChange.setBindPath("LIMIT_CHANGE_FLAG");

      kaigoInfoLimitChange.setSelectValue(2);

      kaigoInfoLimitChange.setUnSelectValue(1);

      addKaigoInfoLimitChange();
    }
    return kaigoInfoLimitChange;

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
   * (有効期間・コンテナ)を取得します。
   * @return (有効期間・コンテナ)
   */
  public ACLabelContainer getKaigoInfoSystemValidLimits(){
    if(kaigoInfoSystemValidLimits==null){

      kaigoInfoSystemValidLimits = new ACLabelContainer();

      kaigoInfoSystemValidLimits.setText("システム有効期間");

      addKaigoInfoSystemValidLimits();
    }
    return kaigoInfoSystemValidLimits;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getKaigoInfoSystemValidLimit1(){
    if(kaigoInfoSystemValidLimit1==null){

      kaigoInfoSystemValidLimit1 = new QkanDateTextField();

      kaigoInfoSystemValidLimit1.setBindPath("SYSTEM_INSURE_VALID_START");

      addKaigoInfoSystemValidLimit1();
    }
    return kaigoInfoSystemValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getKaigoInfoSystemValidLimit2(){
    if(kaigoInfoSystemValidLimit2==null){

      kaigoInfoSystemValidLimit2 = new ACLabel();

      kaigoInfoSystemValidLimit2.setText(" から ");

      addKaigoInfoSystemValidLimit2();
    }
    return kaigoInfoSystemValidLimit2;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getKaigoInfoSystemValidLimit3(){
    if(kaigoInfoSystemValidLimit3==null){

      kaigoInfoSystemValidLimit3 = new QkanDateTextField();

      kaigoInfoSystemValidLimit3.setBindPath("SYSTEM_INSURE_VALID_END");

      addKaigoInfoSystemValidLimit3();
    }
    return kaigoInfoSystemValidLimit3;

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
   * システム有効開始を取得します。
   * @return システム有効開始
   */
  public ACTableColumn getKaigoInfoTableColumn1(){
    if(kaigoInfoTableColumn1==null){

      kaigoInfoTableColumn1 = new ACTableColumn(0);

      kaigoInfoTableColumn1.setHeaderValue("システム有効開始");

      kaigoInfoTableColumn1.setColumns(10);

      kaigoInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn1();
    }
    return kaigoInfoTableColumn1;

  }

  /**
   * システム有効終了を取得します。
   * @return システム有効終了
   */
  public ACTableColumn getKaigoInfoTableColumn2(){
    if(kaigoInfoTableColumn2==null){

      kaigoInfoTableColumn2 = new ACTableColumn(1);

      kaigoInfoTableColumn2.setHeaderValue("システム有効終了");

      kaigoInfoTableColumn2.setColumns(10);

      kaigoInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn2();
    }
    return kaigoInfoTableColumn2;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTableColumn getKaigoInfoTableColumn3(){
    if(kaigoInfoTableColumn3==null){

      kaigoInfoTableColumn3 = new ACTableColumn(2);

      kaigoInfoTableColumn3.setHeaderValue("給付率");

      kaigoInfoTableColumn3.setColumns(4);

      kaigoInfoTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn3();
    }
    return kaigoInfoTableColumn3;

  }

  /**
   * 申請日を取得します。
   * @return 申請日
   */
  public ACTableColumn getKaigoInfoTableColumn4(){
    if(kaigoInfoTableColumn4==null){

      kaigoInfoTableColumn4 = new ACTableColumn(3);

      kaigoInfoTableColumn4.setHeaderValue("申請日");

      kaigoInfoTableColumn4.setColumns(10);

      kaigoInfoTableColumn4.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn4();
    }
    return kaigoInfoTableColumn4;

  }

  /**
   * 申請区分を取得します。
   * @return 申請区分
   */
  public ACTableColumn getKaigoInfoTableColumn5(){
    if(kaigoInfoTableColumn5==null){

      kaigoInfoTableColumn5 = new ACTableColumn(4);

      kaigoInfoTableColumn5.setHeaderValue("申請区分");

      kaigoInfoTableColumn5.setColumns(10);

      addKaigoInfoTableColumn5();
    }
    return kaigoInfoTableColumn5;

  }

  /**
   * 要介護情報を取得します。
   * @return 要介護情報
   */
  public ACTableColumn getKaigoInfoTableColumn6(){
    if(kaigoInfoTableColumn6==null){

      kaigoInfoTableColumn6 = new ACTableColumn(5);

      kaigoInfoTableColumn6.setHeaderValue("要介護度");

      kaigoInfoTableColumn6.setColumns(7);

      addKaigoInfoTableColumn6();
    }
    return kaigoInfoTableColumn6;

  }

  /**
   * 認定有効期間開始を取得します。
   * @return 認定有効期間開始
   */
  public ACTableColumn getKaigoInfoTableColumn7(){
    if(kaigoInfoTableColumn7==null){

      kaigoInfoTableColumn7 = new ACTableColumn(6);

      kaigoInfoTableColumn7.setHeaderValue("有効期間開始日");

      kaigoInfoTableColumn7.setColumns(10);

      kaigoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn7();
    }
    return kaigoInfoTableColumn7;

  }

  /**
   * 認定有効期間終了を取得します。
   * @return 認定有効期間終了
   */
  public ACTableColumn getKaigoInfoTableColumn8(){
    if(kaigoInfoTableColumn8==null){

      kaigoInfoTableColumn8 = new ACTableColumn(7);

      kaigoInfoTableColumn8.setHeaderValue("有効期間終了日");

      kaigoInfoTableColumn8.setColumns(10);

      kaigoInfoTableColumn8.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn8();
    }
    return kaigoInfoTableColumn8;

  }

  /**
   * 作成依頼届出日を取得します。
   * @return 作成依頼届出日
   */
  public ACTableColumn getKaigoInfoTableColumn9(){
    if(kaigoInfoTableColumn9==null){

      kaigoInfoTableColumn9 = new ACTableColumn(8);

      kaigoInfoTableColumn9.setHeaderValue("作成依頼届出日");

      kaigoInfoTableColumn9.setColumns(10);

      kaigoInfoTableColumn9.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn9();
    }
    return kaigoInfoTableColumn9;

  }

  /**
   * 中断年月日を取得します。
   * @return 中断年月日
   */
  public ACTableColumn getKaigoInfoTableColumn10(){
    if(kaigoInfoTableColumn10==null){

      kaigoInfoTableColumn10 = new ACTableColumn(9);

      kaigoInfoTableColumn10.setHeaderValue("中断年月日");

      kaigoInfoTableColumn10.setColumns(10);

      kaigoInfoTableColumn10.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn10();
    }
    return kaigoInfoTableColumn10;

  }

  /**
   * 中断理由を取得します。
   * @return 中断理由
   */
  public ACTableColumn getKaigoInfoTableColumn11(){
    if(kaigoInfoTableColumn11==null){

      kaigoInfoTableColumn11 = new ACTableColumn(10);

      kaigoInfoTableColumn11.setHeaderValue("中断理由");

      kaigoInfoTableColumn11.setColumns(6);

      addKaigoInfoTableColumn11();
    }
    return kaigoInfoTableColumn11;

  }

  /**
   * 支給限度額を取得します。
   * @return 支給限度額
   */
  public ACTableColumn getKaigoInfoTableColumn12(){
    if(kaigoInfoTableColumn12==null){

      kaigoInfoTableColumn12 = new ACTableColumn(11);

      kaigoInfoTableColumn12.setHeaderValue("支給限度額");

      kaigoInfoTableColumn12.setColumns(7);

      kaigoInfoTableColumn12.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn12();
    }
    return kaigoInfoTableColumn12;

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
   * 特定入所者情報・パネルを取得します。
   * @return 特定入所者情報・パネル
   */
  public ACPanel getShisetsuInfoPanel(){
    if(shisetsuInfoPanel==null){

      shisetsuInfoPanel = new ACPanel();

      addShisetsuInfoPanel();
    }
    return shisetsuInfoPanel;

  }

  /**
   * 特定入所者入力領域・パネルを取得します。
   * @return 特定入所者入力領域・パネル
   */
  public ACPanel getShisetsuInputPanel(){
    if(shisetsuInputPanel==null){

      shisetsuInputPanel = new ACPanel();

      addShisetsuInputPanel();
    }
    return shisetsuInputPanel;

  }

  /**
   * 食費居住費・パネルを取得します。
   * @return 食費居住費・パネル
   */
  public ACPanel getShisetsuInfSyokuhiPanel(){
    if(shisetsuInfSyokuhiPanel==null){

      shisetsuInfSyokuhiPanel = new ACPanel();

      addShisetsuInfSyokuhiPanel();
    }
    return shisetsuInfSyokuhiPanel;

  }

  /**
   * 食費居住費・グループを取得します。
   * @return 食費居住費・グループ
   */
  public ACGroupBox getShisetsuInfoSyokuhiGroup(){
    if(shisetsuInfoSyokuhiGroup==null){

      shisetsuInfoSyokuhiGroup = new ACGroupBox();

      shisetsuInfoSyokuhiGroup.setText("利用者負担限度額");

      shisetsuInfoSyokuhiGroup.setLayout(getShisetsuInfoSyokuhiLayout());

      addShisetsuInfoSyokuhiGroup();
    }
    return shisetsuInfoSyokuhiGroup;

  }

  /**
   * 食費・居住費領域・レイアウトを取得します。
   * @return 食費・居住費領域・レイアウト
   */
  public VRLayout getShisetsuInfoSyokuhiLayout(){
    if(shisetsuInfoSyokuhiLayout==null){

      shisetsuInfoSyokuhiLayout = new VRLayout();

      shisetsuInfoSyokuhiLayout.setAutoWrap(false);

      shisetsuInfoSyokuhiLayout.setHgap(0);

      shisetsuInfoSyokuhiLayout.setLabelMargin(0);

      shisetsuInfoSyokuhiLayout.setVgap(5);

      shisetsuInfoSyokuhiLayout.setHgrid(150);

      addShisetsuInfoSyokuhiLayout();
    }
    return shisetsuInfoSyokuhiLayout;

  }

  /**
   * 特定入所スペーサーを取得します。
   * @return 特定入所スペーサー
   */
  public ACLabel getShisetsuInfoSpaceLabel(){
    if(shisetsuInfoSpaceLabel==null){

      shisetsuInfoSpaceLabel = new ACLabel();

      shisetsuInfoSpaceLabel.setText("　");

      addShisetsuInfoSpaceLabel();
    }
    return shisetsuInfoSpaceLabel;

  }

  /**
   * 特定入所者チェックを取得します。
   * @return 特定入所者チェック
   */
  public ACIntegerCheckBox getShisetsuInfoTokuteiCheck(){
    if(shisetsuInfoTokuteiCheck==null){

      shisetsuInfoTokuteiCheck = new ACIntegerCheckBox();

      shisetsuInfoTokuteiCheck.setText("特定入所者");

      shisetsuInfoTokuteiCheck.setBindPath("TOKUTEI_NYUSHO_FLAG");

      shisetsuInfoTokuteiCheck.setSelectValue(2);

      shisetsuInfoTokuteiCheck.setUnSelectValue(1);

      addShisetsuInfoTokuteiCheck();
    }
    return shisetsuInfoTokuteiCheck;

  }

  /**
   * 食費負担限度額・コンテナを取得します。
   * @return 食費負担限度額・コンテナ
   */
  public ACLabelContainer getShisetsuInfoDinnerBearLimitMoneyContena(){
    if(shisetsuInfoDinnerBearLimitMoneyContena==null){

      shisetsuInfoDinnerBearLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoDinnerBearLimitMoneyContena.setText("食費");

      addShisetsuInfoDinnerBearLimitMoneyContena();
    }
    return shisetsuInfoDinnerBearLimitMoneyContena;

  }

  /**
   * 食費負担限度額・テキストを取得します。
   * @return 食費負担限度額・テキスト
   */
  public ACTextField getShisetsuInfoDinnerBearLimitMoneyText(){
    if(shisetsuInfoDinnerBearLimitMoneyText==null){

      shisetsuInfoDinnerBearLimitMoneyText = new ACTextField();

      shisetsuInfoDinnerBearLimitMoneyText.setBindPath("LIMIT_SHOKUHI");

      shisetsuInfoDinnerBearLimitMoneyText.setColumns(4);

      shisetsuInfoDinnerBearLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoDinnerBearLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoDinnerBearLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoDinnerBearLimitMoneyText.setMaxLength(4);

      addShisetsuInfoDinnerBearLimitMoneyText();
    }
    return shisetsuInfoDinnerBearLimitMoneyText;

  }

  /**
   * 食費負担限度額・ラベルを取得します。
   * @return 食費負担限度額・ラベル
   */
  public ACLabel getShisetsuInfoDinnerBearLimitMoneyLabel(){
    if(shisetsuInfoDinnerBearLimitMoneyLabel==null){

      shisetsuInfoDinnerBearLimitMoneyLabel = new ACLabel();

      shisetsuInfoDinnerBearLimitMoneyLabel.setText("(円)");

      addShisetsuInfoDinnerBearLimitMoneyLabel();
    }
    return shisetsuInfoDinnerBearLimitMoneyLabel;

  }

  /**
   * ユニット型個室負担限度額・コンテナを取得します。
   * @return ユニット型個室負担限度額・コンテナ
   */
  public ACLabelContainer getShisetsuInfoUnitRoomLimitMoneyContena(){
    if(shisetsuInfoUnitRoomLimitMoneyContena==null){

      shisetsuInfoUnitRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoUnitRoomLimitMoneyContena.setText("ユニット型個室");

      addShisetsuInfoUnitRoomLimitMoneyContena();
    }
    return shisetsuInfoUnitRoomLimitMoneyContena;

  }

  /**
   * ユニット型個室負担限度額・テキストを取得します。
   * @return ユニット型個室負担限度額・テキスト
   */
  public ACTextField getShisetsuInfoUnitRoomLimitMoneyText(){
    if(shisetsuInfoUnitRoomLimitMoneyText==null){

      shisetsuInfoUnitRoomLimitMoneyText = new ACTextField();

      shisetsuInfoUnitRoomLimitMoneyText.setBindPath("LIMIT_UNIT_KOSHITSU");

      shisetsuInfoUnitRoomLimitMoneyText.setColumns(4);

      shisetsuInfoUnitRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoUnitRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoUnitRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoUnitRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoUnitRoomLimitMoneyText();
    }
    return shisetsuInfoUnitRoomLimitMoneyText;

  }

  /**
   * ユニット型個室負担限度額・ラベルを取得します。
   * @return ユニット型個室負担限度額・ラベル
   */
  public ACLabel getShisetsuInfoUnitRoomLimitMoneyLabel(){
    if(shisetsuInfoUnitRoomLimitMoneyLabel==null){

      shisetsuInfoUnitRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoUnitRoomLimitMoneyLabel.setText("(円)");

      addShisetsuInfoUnitRoomLimitMoneyLabel();
    }
    return shisetsuInfoUnitRoomLimitMoneyLabel;

  }

  /**
   * ユニット型個室的多床室負担限度額・コンテナを取得します。
   * @return ユニット型個室的多床室負担限度額・コンテナ
   */
  public ACLabelContainer getShisetsuInfoUnitSemiRoomLimitMoneyContena(){
    if(shisetsuInfoUnitSemiRoomLimitMoneyContena==null){

      shisetsuInfoUnitSemiRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoUnitSemiRoomLimitMoneyContena.setText("ユニット型個室的多床室");

      addShisetsuInfoUnitSemiRoomLimitMoneyContena();
    }
    return shisetsuInfoUnitSemiRoomLimitMoneyContena;

  }

  /**
   * ユニット型個室的多床室負担限度額・テキストを取得します。
   * @return ユニット型個室的多床室負担限度額・テキスト
   */
  public ACTextField getShisetsuInfoUnitSemiRoomLimitMoneyText(){
    if(shisetsuInfoUnitSemiRoomLimitMoneyText==null){

      shisetsuInfoUnitSemiRoomLimitMoneyText = new ACTextField();

      shisetsuInfoUnitSemiRoomLimitMoneyText.setBindPath("LIMIT_UNIT_JUNKOSHITSU");

      shisetsuInfoUnitSemiRoomLimitMoneyText.setColumns(4);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoUnitSemiRoomLimitMoneyText();
    }
    return shisetsuInfoUnitSemiRoomLimitMoneyText;

  }

  /**
   * ユニット型個室的多床室負担限度額・ラベルを取得します。
   * @return ユニット型個室的多床室負担限度額・ラベル
   */
  public ACLabel getShisetsuInfoUnitSemiRoomLimitMoneyLabel(){
    if(shisetsuInfoUnitSemiRoomLimitMoneyLabel==null){

      shisetsuInfoUnitSemiRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoUnitSemiRoomLimitMoneyLabel.setText("(円)");

      addShisetsuInfoUnitSemiRoomLimitMoneyLabel();
    }
    return shisetsuInfoUnitSemiRoomLimitMoneyLabel;

  }

  /**
   * 従来型個室特養等負担限度額・コンテナを取得します。
   * @return 従来型個室特養等負担限度額・コンテナ
   */
  public ACLabelContainer getShisetsuInfoNormalRoomLimitMoneyContena(){
    if(shisetsuInfoNormalRoomLimitMoneyContena==null){

      shisetsuInfoNormalRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoNormalRoomLimitMoneyContena.setText("従来型個室(特養等)");

      addShisetsuInfoNormalRoomLimitMoneyContena();
    }
    return shisetsuInfoNormalRoomLimitMoneyContena;

  }

  /**
   * 従来型個室特養等負担限度額・テキストを取得します。
   * @return 従来型個室特養等負担限度額・テキスト
   */
  public ACTextField getShisetsuInfoNormalRoomLimitMoneyText(){
    if(shisetsuInfoNormalRoomLimitMoneyText==null){

      shisetsuInfoNormalRoomLimitMoneyText = new ACTextField();

      shisetsuInfoNormalRoomLimitMoneyText.setBindPath("LIMIT_JURAIGATA1");

      shisetsuInfoNormalRoomLimitMoneyText.setColumns(4);

      shisetsuInfoNormalRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoNormalRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoNormalRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoNormalRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoNormalRoomLimitMoneyText();
    }
    return shisetsuInfoNormalRoomLimitMoneyText;

  }

  /**
   * 従来型個室特養等負担限度額・ラベルを取得します。
   * @return 従来型個室特養等負担限度額・ラベル
   */
  public ACLabel getShisetsuInfoNormalRoomLimitMoneyLabel(){
    if(shisetsuInfoNormalRoomLimitMoneyLabel==null){

      shisetsuInfoNormalRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoNormalRoomLimitMoneyLabel.setText("(円)");

      addShisetsuInfoNormalRoomLimitMoneyLabel();
    }
    return shisetsuInfoNormalRoomLimitMoneyLabel;

  }

  /**
   * 従来型個室老健・療養・介護医療院等負担限度額・コンテナを取得します。
   * @return 従来型個室老健・療養・介護医療院等負担限度額・コンテナ
   */
  public ACLabelContainer getShisetsuInfoNormalRoomLimitMoneyContena2(){
    if(shisetsuInfoNormalRoomLimitMoneyContena2==null){

      shisetsuInfoNormalRoomLimitMoneyContena2 = new ACLabelContainer();

      shisetsuInfoNormalRoomLimitMoneyContena2.setText("従来型個室(老健・療養・介護医療院等)");

      addShisetsuInfoNormalRoomLimitMoneyContena2();
    }
    return shisetsuInfoNormalRoomLimitMoneyContena2;

  }

  /**
   * 従来型個室老健・療養・介護医療院等負担限度額・テキストを取得します。
   * @return 従来型個室老健・療養・介護医療院等負担限度額・テキスト
   */
  public ACTextField getShisetsuInfoNormalRoomLimitMoneyText2(){
    if(shisetsuInfoNormalRoomLimitMoneyText2==null){

      shisetsuInfoNormalRoomLimitMoneyText2 = new ACTextField();

      shisetsuInfoNormalRoomLimitMoneyText2.setBindPath("LIMIT_JURAIGATA2");

      shisetsuInfoNormalRoomLimitMoneyText2.setColumns(4);

      shisetsuInfoNormalRoomLimitMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoNormalRoomLimitMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoNormalRoomLimitMoneyText2.setIMEMode(InputSubset.LATIN);

      shisetsuInfoNormalRoomLimitMoneyText2.setMaxLength(4);

      addShisetsuInfoNormalRoomLimitMoneyText2();
    }
    return shisetsuInfoNormalRoomLimitMoneyText2;

  }

  /**
   * 従来型個室老健・療養・介護医療院等負担限度額・ラベルを取得します。
   * @return 従来型個室老健・療養・介護医療院等負担限度額・ラベル
   */
  public ACLabel getShisetsuInfoNormalRoomLimitMoneyLabel2(){
    if(shisetsuInfoNormalRoomLimitMoneyLabel2==null){

      shisetsuInfoNormalRoomLimitMoneyLabel2 = new ACLabel();

      shisetsuInfoNormalRoomLimitMoneyLabel2.setText("(円)");

      addShisetsuInfoNormalRoomLimitMoneyLabel2();
    }
    return shisetsuInfoNormalRoomLimitMoneyLabel2;

  }

  /**
   * 多床室特養等負担限度額・コンテナを取得します。
   * @return 多床室特養等負担限度額・コンテナ
   */
  public ACLabelContainer getShisetsuInfoTasyoRoomLimitMoneyContena(){
    if(shisetsuInfoTasyoRoomLimitMoneyContena==null){

      shisetsuInfoTasyoRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoTasyoRoomLimitMoneyContena.setText("多床室(特養等)");

      addShisetsuInfoTasyoRoomLimitMoneyContena();
    }
    return shisetsuInfoTasyoRoomLimitMoneyContena;

  }

  /**
   * 多床室特養等負担限度額・テキストを取得します。
   * @return 多床室特養等負担限度額・テキスト
   */
  public ACTextField getShisetsuInfoTasyoRoomLimitMoneyText(){
    if(shisetsuInfoTasyoRoomLimitMoneyText==null){

      shisetsuInfoTasyoRoomLimitMoneyText = new ACTextField();

      shisetsuInfoTasyoRoomLimitMoneyText.setBindPath("LIMIT_TASHOSHITSU2");

      shisetsuInfoTasyoRoomLimitMoneyText.setColumns(4);

      shisetsuInfoTasyoRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoTasyoRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoTasyoRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoTasyoRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoTasyoRoomLimitMoneyText();
    }
    return shisetsuInfoTasyoRoomLimitMoneyText;

  }

  /**
   * 多床室特養等負担限度額・ラベルを取得します。
   * @return 多床室特養等負担限度額・ラベル
   */
  public ACLabel getShisetsuInfoTasyoRoomLimitMoneyLabel(){
    if(shisetsuInfoTasyoRoomLimitMoneyLabel==null){

      shisetsuInfoTasyoRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoTasyoRoomLimitMoneyLabel.setText("(円)");

      addShisetsuInfoTasyoRoomLimitMoneyLabel();
    }
    return shisetsuInfoTasyoRoomLimitMoneyLabel;

  }

  /**
   * 多床室老健・療養・介護医療院等負担限度額・コンテナを取得します。
   * @return 多床室老健・療養・介護医療院等負担限度額・コンテナ
   */
  public ACLabelContainer getShisetsuInfoTasyoRoomLimitMoneyContena2(){
    if(shisetsuInfoTasyoRoomLimitMoneyContena2==null){

      shisetsuInfoTasyoRoomLimitMoneyContena2 = new ACLabelContainer();

      shisetsuInfoTasyoRoomLimitMoneyContena2.setText("多床室(老健・療養・介護医療院等)");

      addShisetsuInfoTasyoRoomLimitMoneyContena2();
    }
    return shisetsuInfoTasyoRoomLimitMoneyContena2;

  }

  /**
   * 多床室老健・療養・介護医療院等負担限度額・テキストを取得します。
   * @return 多床室老健・療養・介護医療院等負担限度額・テキスト
   */
  public ACTextField getShisetsuInfoTasyoRoomLimitMoneyText2(){
    if(shisetsuInfoTasyoRoomLimitMoneyText2==null){

      shisetsuInfoTasyoRoomLimitMoneyText2 = new ACTextField();

      shisetsuInfoTasyoRoomLimitMoneyText2.setBindPath("LIMIT_TASHOSHITSU");

      shisetsuInfoTasyoRoomLimitMoneyText2.setColumns(4);

      shisetsuInfoTasyoRoomLimitMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoTasyoRoomLimitMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoTasyoRoomLimitMoneyText2.setIMEMode(InputSubset.LATIN);

      shisetsuInfoTasyoRoomLimitMoneyText2.setMaxLength(4);

      addShisetsuInfoTasyoRoomLimitMoneyText2();
    }
    return shisetsuInfoTasyoRoomLimitMoneyText2;

  }

  /**
   * 多床室老健・療養・介護医療院等負担限度額・ラベルを取得します。
   * @return 多床室老健・療養・介護医療院等負担限度額・ラベル
   */
  public ACLabel getShisetsuInfoTasyoRoomLimitMoneyLabel2(){
    if(shisetsuInfoTasyoRoomLimitMoneyLabel2==null){

      shisetsuInfoTasyoRoomLimitMoneyLabel2 = new ACLabel();

      shisetsuInfoTasyoRoomLimitMoneyLabel2.setText("(円)");

      addShisetsuInfoTasyoRoomLimitMoneyLabel2();
    }
    return shisetsuInfoTasyoRoomLimitMoneyLabel2;

  }

  /**
   * 右パネルを取得します。
   * @return 右パネル
   */
  public ACPanel getShisetsuInfRigthtPanel(){
    if(shisetsuInfRigthtPanel==null){

      shisetsuInfRigthtPanel = new ACPanel();

      addShisetsuInfRigthtPanel();
    }
    return shisetsuInfRigthtPanel;

  }

  /**
   * 介護老人福祉施設・グループを取得します。
   * @return 介護老人福祉施設・グループ
   */
  public ACGroupBox getShisetsuInfoCareOldPersonGroup(){
    if(shisetsuInfoCareOldPersonGroup==null){

      shisetsuInfoCareOldPersonGroup = new ACGroupBox();

      shisetsuInfoCareOldPersonGroup.setText("介護老人福祉施設");

      addShisetsuInfoCareOldPersonGroup();
    }
    return shisetsuInfoCareOldPersonGroup;

  }

  /**
   * 旧措置入所者特例を取得します。
   * @return 旧措置入所者特例
   */
  public ACIntegerCheckBox getShisetsuInfoOldStep(){
    if(shisetsuInfoOldStep==null){

      shisetsuInfoOldStep = new ACIntegerCheckBox();

      shisetsuInfoOldStep.setText("旧措置入所者特例");

      shisetsuInfoOldStep.setBindPath("KYUSOCHI_FLAG");

      shisetsuInfoOldStep.setSelectValue(2);

      shisetsuInfoOldStep.setUnSelectValue(1);

      addShisetsuInfoOldStep();
    }
    return shisetsuInfoOldStep;

  }

  /**
   * 介護老人保健施設・介護療養型医療施設・介護医療院グループを取得します。
   * @return 介護老人保健施設・介護療養型医療施設・介護医療院グループ
   */
  public ACGroupBox getShisetsuInfoCareOldPersonInsuranceGroup(){
    if(shisetsuInfoCareOldPersonInsuranceGroup==null){

      shisetsuInfoCareOldPersonInsuranceGroup = new ACGroupBox();

      shisetsuInfoCareOldPersonInsuranceGroup.setText("介護老人保健施設・介護療養型医療施設・介護医療院");

      addShisetsuInfoCareOldPersonInsuranceGroup();
    }
    return shisetsuInfoCareOldPersonInsuranceGroup;

  }

  /**
   * 主傷病を取得します。
   * @return 主傷病
   */
  public ACTextField getShisetsuInfoMainDisease(){
    if(shisetsuInfoMainDisease==null){

      shisetsuInfoMainDisease = new ACTextField();

      getShisetsuInfoMainDiseaseContainer().setText("主傷病");

      shisetsuInfoMainDisease.setBindPath("DISEASE");

      shisetsuInfoMainDisease.setColumns(20);

      shisetsuInfoMainDisease.setIMEMode(InputSubset.KANJI);

      shisetsuInfoMainDisease.setMaxLength(64);

      addShisetsuInfoMainDisease();
    }
    return shisetsuInfoMainDisease;

  }

  /**
   * 主傷病コンテナを取得します。
   * @return 主傷病コンテナ
   */
  protected ACLabelContainer getShisetsuInfoMainDiseaseContainer(){
    if(shisetsuInfoMainDiseaseContainer==null){
      shisetsuInfoMainDiseaseContainer = new ACLabelContainer();
      shisetsuInfoMainDiseaseContainer.setFollowChildEnabled(true);
      shisetsuInfoMainDiseaseContainer.setVAlignment(VRLayout.CENTER);
      shisetsuInfoMainDiseaseContainer.add(getShisetsuInfoMainDisease(), null);
    }
    return shisetsuInfoMainDiseaseContainer;
  }

  /**
   * 説明文グループを取得します。
   * @return 説明文グループ
   */
  public ACGroupBox getShisetsuInfoExplanationGroup(){
    if(shisetsuInfoExplanationGroup==null){

      shisetsuInfoExplanationGroup = new ACGroupBox();

      shisetsuInfoExplanationGroup.setAutoWrap(true);

      shisetsuInfoExplanationGroup.setHgap(0);

      addShisetsuInfoExplanationGroup();
    }
    return shisetsuInfoExplanationGroup;

  }

  /**
   * 説明文ラベル1を取得します。
   * @return 説明文ラベル1
   */
  public ACLabel getShisetsuInfoExplanationLabel1(){
    if(shisetsuInfoExplanationLabel1==null){

      shisetsuInfoExplanationLabel1 = new ACLabel();

      shisetsuInfoExplanationLabel1.setText("入院・入所日の設定方法");

      shisetsuInfoExplanationLabel1.setIconPath(ACConstants.ICON_PATH_INFORMATION_24);

      addShisetsuInfoExplanationLabel1();
    }
    return shisetsuInfoExplanationLabel1;

  }

  /**
   * 説明文ラベル2を取得します。
   * @return 説明文ラベル2
   */
  public ACLabel getShisetsuInfoExplanationLabel2(){
    if(shisetsuInfoExplanationLabel2==null){

      shisetsuInfoExplanationLabel2 = new ACLabel();

      shisetsuInfoExplanationLabel2.setText("　異動情報にて施設系サービスを選択し、設定を行ってください。");

      addShisetsuInfoExplanationLabel2();
    }
    return shisetsuInfoExplanationLabel2;

  }

  /**
   * 施設情報・その他パネルを取得します。
   * @return 施設情報・その他パネル
   */
  public ACPanel getShisetsuInfoOtherPanel(){
    if(shisetsuInfoOtherPanel==null){

      shisetsuInfoOtherPanel = new ACPanel();

      shisetsuInfoOtherPanel.setLayout(getShisetsuInfoOtherLayout());

      addShisetsuInfoOtherPanel();
    }
    return shisetsuInfoOtherPanel;

  }

  /**
   * 施設情報その他領域・レイアウトを取得します。
   * @return 施設情報その他領域・レイアウト
   */
  public VRLayout getShisetsuInfoOtherLayout(){
    if(shisetsuInfoOtherLayout==null){

      shisetsuInfoOtherLayout = new VRLayout();

      shisetsuInfoOtherLayout.setAutoWrap(false);

      shisetsuInfoOtherLayout.setVgap(5);

      addShisetsuInfoOtherLayout();
    }
    return shisetsuInfoOtherLayout;

  }

  /**
   * 有効期間領域・パネルを取得します。
   * @return 有効期間領域・パネル
   */
  public ACPanel getShisetsuInfoLimitPanel(){
    if(shisetsuInfoLimitPanel==null){

      shisetsuInfoLimitPanel = new ACPanel();

      addShisetsuInfoLimitPanel();
    }
    return shisetsuInfoLimitPanel;

  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getShisetsuInfoValidLimitContainer(){
    if(shisetsuInfoValidLimitContainer==null){

      shisetsuInfoValidLimitContainer = new ACLabelContainer();

      shisetsuInfoValidLimitContainer.setText("有効期間");

      addShisetsuInfoValidLimitContainer();
    }
    return shisetsuInfoValidLimitContainer;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getShisetsuInfoValidLimitDateStart(){
    if(shisetsuInfoValidLimitDateStart==null){

      shisetsuInfoValidLimitDateStart = new QkanDateTextField();

      shisetsuInfoValidLimitDateStart.setBindPath("SHISETSU_VALID_START");

      addShisetsuInfoValidLimitDateStart();
    }
    return shisetsuInfoValidLimitDateStart;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getShisetsuInfoValidLimitLabel(){
    if(shisetsuInfoValidLimitLabel==null){

      shisetsuInfoValidLimitLabel = new ACLabel();

      shisetsuInfoValidLimitLabel.setText(" から ");

      addShisetsuInfoValidLimitLabel();
    }
    return shisetsuInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getShisetsuInfoValidLimitDateEnd(){
    if(shisetsuInfoValidLimitDateEnd==null){

      shisetsuInfoValidLimitDateEnd = new QkanDateTextField();

      shisetsuInfoValidLimitDateEnd.setBindPath("SHISETSU_VALID_END");

      addShisetsuInfoValidLimitDateEnd();
    }
    return shisetsuInfoValidLimitDateEnd;

  }

  /**
   * 特定入所者情報・ボタン領域を取得します。
   * @return 特定入所者情報・ボタン領域
   */
  public ACPanel getShisetsuInfoButtons(){
    if(shisetsuInfoButtons==null){

      shisetsuInfoButtons = new ACPanel();

      addShisetsuInfoButtons();
    }
    return shisetsuInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getShisetsuInfoButtonClear(){
    if(shisetsuInfoButtonClear==null){

      shisetsuInfoButtonClear = new ACButton();

      shisetsuInfoButtonClear.setText("クリア");

      shisetsuInfoButtonClear.setToolTipText("異動情報をクリアします。");

      shisetsuInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addShisetsuInfoButtonClear();
    }
    return shisetsuInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getShisetsuInfoButtonInsert(){
    if(shisetsuInfoButtonInsert==null){

      shisetsuInfoButtonInsert = new ACButton();

      shisetsuInfoButtonInsert.setText("追加");

      shisetsuInfoButtonInsert.setToolTipText("異動情報を追加します。");

      shisetsuInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addShisetsuInfoButtonInsert();
    }
    return shisetsuInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getShisetsuInfoButtonEdit(){
    if(shisetsuInfoButtonEdit==null){

      shisetsuInfoButtonEdit = new ACButton();

      shisetsuInfoButtonEdit.setText("書替");

      shisetsuInfoButtonEdit.setToolTipText("異動情報を編集します。");

      shisetsuInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addShisetsuInfoButtonEdit();
    }
    return shisetsuInfoButtonEdit;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getShisetsuInfoButtonDelete(){
    if(shisetsuInfoButtonDelete==null){

      shisetsuInfoButtonDelete = new ACButton();

      shisetsuInfoButtonDelete.setText("削除");

      shisetsuInfoButtonDelete.setToolTipText("異動情報を削除します。");

      shisetsuInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addShisetsuInfoButtonDelete();
    }
    return shisetsuInfoButtonDelete;

  }

  /**
   * 特定入所者情報・テーブル領域を取得します。
   * @return 特定入所者情報・テーブル領域
   */
  public ACTable getShisetsuInfoTable(){
    if(shisetsuInfoTable==null){

      shisetsuInfoTable = new ACTable();

      shisetsuInfoTable.setColumnModel(getShisetsuInfoTableColumnModel());

      addShisetsuInfoTable();
    }
    return shisetsuInfoTable;

  }

  /**
   * 特定入所者情報・テーブル領域カラムモデルを取得します。
   * @return 特定入所者情報・テーブル領域カラムモデル
   */
  protected VRTableColumnModel getShisetsuInfoTableColumnModel(){
    if(shisetsuInfoTableColumnModel==null){
      shisetsuInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShisetsuInfoTableColumnModel();
    }
    return shisetsuInfoTableColumnModel;
  }

  /**
   * №を取得します。
   * @return №
   */
  public ACTableColumn getShisetsuInfoTableColumn0(){
    if(shisetsuInfoTableColumn0==null){

      shisetsuInfoTableColumn0 = new ACTableColumn();

      shisetsuInfoTableColumn0.setHeaderValue("No.");

      shisetsuInfoTableColumn0.setColumnName("SHOW_FLAG");

      shisetsuInfoTableColumn0.setColumns(3);

      shisetsuInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shisetsuInfoTableColumn0.setSortable(false);

      addShisetsuInfoTableColumn0();
    }
    return shisetsuInfoTableColumn0;

  }

  /**
   * 有効期間開始を取得します。
   * @return 有効期間開始
   */
  public ACTableColumn getShisetsuInfoTableColumn1(){
    if(shisetsuInfoTableColumn1==null){

      shisetsuInfoTableColumn1 = new ACTableColumn();

      shisetsuInfoTableColumn1.setHeaderValue("有効期間開始");

      shisetsuInfoTableColumn1.setColumnName("SHISETSU_VALID_START");

      shisetsuInfoTableColumn1.setColumns(10);

      shisetsuInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addShisetsuInfoTableColumn1();
    }
    return shisetsuInfoTableColumn1;

  }

  /**
   * 有効期間終了を取得します。
   * @return 有効期間終了
   */
  public ACTableColumn getShisetsuInfoTableColumn2(){
    if(shisetsuInfoTableColumn2==null){

      shisetsuInfoTableColumn2 = new ACTableColumn();

      shisetsuInfoTableColumn2.setHeaderValue("有効期間終了");

      shisetsuInfoTableColumn2.setColumnName("SHISETSU_VALID_END");

      shisetsuInfoTableColumn2.setColumns(10);

      shisetsuInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addShisetsuInfoTableColumn2();
    }
    return shisetsuInfoTableColumn2;

  }

  /**
   * 特定入所者を取得します。
   * @return 特定入所者
   */
  public ACTableColumn getShisetsuInfoTableColumn3(){
    if(shisetsuInfoTableColumn3==null){

      shisetsuInfoTableColumn3 = new ACTableColumn();

      shisetsuInfoTableColumn3.setHeaderValue("特定入所者");

      shisetsuInfoTableColumn3.setColumnName("TOKUTEI_NYUSHO_FLAG");

      shisetsuInfoTableColumn3.setColumns(7);

      shisetsuInfoTableColumn3.setHorizontalAlignment(SwingConstants.CENTER);

      shisetsuInfoTableColumn3.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      shisetsuInfoTableColumn3.setSortable(false);

      addShisetsuInfoTableColumn3();
    }
    return shisetsuInfoTableColumn3;

  }

  /**
   * 旧措置入所者特例を取得します。
   * @return 旧措置入所者特例
   */
  public ACTableColumn getShisetsuInfoTableColumn4(){
    if(shisetsuInfoTableColumn4==null){

      shisetsuInfoTableColumn4 = new ACTableColumn();

      shisetsuInfoTableColumn4.setHeaderValue("旧措置入所者特例");

      shisetsuInfoTableColumn4.setColumnName("KYUSOCHI_FLAG");

      shisetsuInfoTableColumn4.setColumns(10);

      shisetsuInfoTableColumn4.setHorizontalAlignment(SwingConstants.CENTER);

      shisetsuInfoTableColumn4.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      shisetsuInfoTableColumn4.setSortable(false);

      addShisetsuInfoTableColumn4();
    }
    return shisetsuInfoTableColumn4;

  }

  /**
   * 主傷病名を取得します。
   * @return 主傷病名
   */
  public ACTableColumn getShisetsuInfoTableColumn5(){
    if(shisetsuInfoTableColumn5==null){

      shisetsuInfoTableColumn5 = new ACTableColumn();

      shisetsuInfoTableColumn5.setHeaderValue("主傷病名");

      shisetsuInfoTableColumn5.setColumnName("DISEASE");

      shisetsuInfoTableColumn5.setColumns(15);

      addShisetsuInfoTableColumn5();
    }
    return shisetsuInfoTableColumn5;

  }

  /**
   * 住所地特例情報・パネルを取得します。
   * @return 住所地特例情報・パネル
   */
  public ACPanel getJushotiTokureiInfoPanel(){
    if(jushotiTokureiInfoPanel==null){

      jushotiTokureiInfoPanel = new ACPanel();

      addJushotiTokureiInfoPanel();
    }
    return jushotiTokureiInfoPanel;

  }

  /**
   * 住所地特例入力領域・パネルを取得します。
   * @return 住所地特例入力領域・パネル
   */
  public ACPanel getJushotiTokureiInputPanel(){
    if(jushotiTokureiInputPanel==null){

      jushotiTokureiInputPanel = new ACPanel();

      addJushotiTokureiInputPanel();
    }
    return jushotiTokureiInputPanel;

  }

  /**
   * 食費居住費・グループを取得します。
   * @return 食費居住費・グループ
   */
  public ACGroupBox getJushotiTokureiInfoGroup(){
    if(jushotiTokureiInfoGroup==null){

      jushotiTokureiInfoGroup = new ACGroupBox();

      jushotiTokureiInfoGroup.setText("住所地特例情報");

      jushotiTokureiInfoGroup.setLayout(getJushotiTokureiInfoLayout2());

      addJushotiTokureiInfoGroup();
    }
    return jushotiTokureiInfoGroup;

  }

  /**
   * (住所地特例基本領域・レイアウト)を取得します。
   * @return (住所地特例基本領域・レイアウト)
   */
  public VRLayout getJushotiTokureiInfoLayout2(){
    if(jushotiTokureiInfoLayout2==null){

      jushotiTokureiInfoLayout2 = new VRLayout();

      jushotiTokureiInfoLayout2.setAutoWrap(false);

      jushotiTokureiInfoLayout2.setHgap(2);

      jushotiTokureiInfoLayout2.setHgrid(150);

      addJushotiTokureiInfoLayout2();
    }
    return jushotiTokureiInfoLayout2;

  }

  /**
   * 施設所在保険者番号を取得します。
   * @return 施設所在保険者番号
   */
  public ACTextField getJushotiTokureiInfoInsurerId(){
    if(jushotiTokureiInfoInsurerId==null){

      jushotiTokureiInfoInsurerId = new ACTextField();

      getJushotiTokureiInfoInsurerIdContainer().setText("施設所在保険者番号");

      jushotiTokureiInfoInsurerId.setBindPath("JUSHOTI_INSURER_ID");

      jushotiTokureiInfoInsurerId.setColumns(9);

      jushotiTokureiInfoInsurerId.setCharType(VRCharType.ONLY_DIGIT);

      jushotiTokureiInfoInsurerId.setIMEMode(InputSubset.LATIN);

      jushotiTokureiInfoInsurerId.setMaxLength(6);

      addJushotiTokureiInfoInsurerId();
    }
    return jushotiTokureiInfoInsurerId;

  }

  /**
   * 施設所在保険者番号コンテナを取得します。
   * @return 施設所在保険者番号コンテナ
   */
  protected ACLabelContainer getJushotiTokureiInfoInsurerIdContainer(){
    if(jushotiTokureiInfoInsurerIdContainer==null){
      jushotiTokureiInfoInsurerIdContainer = new ACLabelContainer();
      jushotiTokureiInfoInsurerIdContainer.setFollowChildEnabled(true);
      jushotiTokureiInfoInsurerIdContainer.setVAlignment(VRLayout.CENTER);
      jushotiTokureiInfoInsurerIdContainer.add(getJushotiTokureiInfoInsurerId(), null);
    }
    return jushotiTokureiInfoInsurerIdContainer;
  }

  /**
   * 施設所在保険者名を取得します。
   * @return 施設所在保険者名
   */
  public ACComboBox getJushotiTokureiInfoInsurerName(){
    if(jushotiTokureiInfoInsurerName==null){

      jushotiTokureiInfoInsurerName = new ACComboBox();

      getJushotiTokureiInfoInsurerNameContainer().setText("施設所在保険者名");

      jushotiTokureiInfoInsurerName.setBindPath("JUSHOTI_INSURER_ID");

      jushotiTokureiInfoInsurerName.setEditable(false);

      jushotiTokureiInfoInsurerName.setColumns(10);

      jushotiTokureiInfoInsurerName.setModelBindPath("INSURER");

      jushotiTokureiInfoInsurerName.setRenderBindPath("INSURER_NAME");

      jushotiTokureiInfoInsurerName.setMaxColumns(18);

      jushotiTokureiInfoInsurerName.setModel(getJushotiTokureiInfoInsurerNameModel());

      addJushotiTokureiInfoInsurerName();
    }
    return jushotiTokureiInfoInsurerName;

  }

  /**
   * 施設所在保険者名コンテナを取得します。
   * @return 施設所在保険者名コンテナ
   */
  protected ACLabelContainer getJushotiTokureiInfoInsurerNameContainer(){
    if(jushotiTokureiInfoInsurerNameContainer==null){
      jushotiTokureiInfoInsurerNameContainer = new ACLabelContainer();
      jushotiTokureiInfoInsurerNameContainer.setFollowChildEnabled(true);
      jushotiTokureiInfoInsurerNameContainer.setVAlignment(VRLayout.CENTER);
      jushotiTokureiInfoInsurerNameContainer.add(getJushotiTokureiInfoInsurerName(), null);
    }
    return jushotiTokureiInfoInsurerNameContainer;
  }

  /**
   * 施設所在保険者名モデルを取得します。
   * @return 施設所在保険者名モデル
   */
  protected ACComboBoxModelAdapter getJushotiTokureiInfoInsurerNameModel(){
    if(jushotiTokureiInfoInsurerNameModel==null){
      jushotiTokureiInfoInsurerNameModel = new ACComboBoxModelAdapter();
      addJushotiTokureiInfoInsurerNameModel();
    }
    return jushotiTokureiInfoInsurerNameModel;
  }

  /**
   * 有効期間領域・パネルを取得します。
   * @return 有効期間領域・パネル
   */
  public ACPanel getJushotiTokureiInfoLimitPanel(){
    if(jushotiTokureiInfoLimitPanel==null){

      jushotiTokureiInfoLimitPanel = new ACPanel();

      addJushotiTokureiInfoLimitPanel();
    }
    return jushotiTokureiInfoLimitPanel;

  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getJushotiTokureiInfoValidLimitContainer(){
    if(jushotiTokureiInfoValidLimitContainer==null){

      jushotiTokureiInfoValidLimitContainer = new ACLabelContainer();

      jushotiTokureiInfoValidLimitContainer.setText("有効期間");

      addJushotiTokureiInfoValidLimitContainer();
    }
    return jushotiTokureiInfoValidLimitContainer;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getJushotiTokureiInfoValidLimitDateStart(){
    if(jushotiTokureiInfoValidLimitDateStart==null){

      jushotiTokureiInfoValidLimitDateStart = new QkanDateTextField();

      jushotiTokureiInfoValidLimitDateStart.setBindPath("JUSHOTI_VALID_START");

      addJushotiTokureiInfoValidLimitDateStart();
    }
    return jushotiTokureiInfoValidLimitDateStart;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getJushotiTokureiInfoValidLimitLabel(){
    if(jushotiTokureiInfoValidLimitLabel==null){

      jushotiTokureiInfoValidLimitLabel = new ACLabel();

      jushotiTokureiInfoValidLimitLabel.setText(" から ");

      addJushotiTokureiInfoValidLimitLabel();
    }
    return jushotiTokureiInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getJushotiTokureiInfoValidLimitDateEnd(){
    if(jushotiTokureiInfoValidLimitDateEnd==null){

      jushotiTokureiInfoValidLimitDateEnd = new QkanDateTextField();

      jushotiTokureiInfoValidLimitDateEnd.setBindPath("JUSHOTI_VALID_END");

      addJushotiTokureiInfoValidLimitDateEnd();
    }
    return jushotiTokureiInfoValidLimitDateEnd;

  }

  /**
   * 住所地特例情報・ボタン領域を取得します。
   * @return 住所地特例情報・ボタン領域
   */
  public ACPanel getJushotiTokureiInfoButtons(){
    if(jushotiTokureiInfoButtons==null){

      jushotiTokureiInfoButtons = new ACPanel();

      addJushotiTokureiInfoButtons();
    }
    return jushotiTokureiInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getJushotiTokureiInfoButtonClear(){
    if(jushotiTokureiInfoButtonClear==null){

      jushotiTokureiInfoButtonClear = new ACButton();

      jushotiTokureiInfoButtonClear.setText("クリア");

      jushotiTokureiInfoButtonClear.setToolTipText("住所地特例情報をクリアします。");

      jushotiTokureiInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addJushotiTokureiInfoButtonClear();
    }
    return jushotiTokureiInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getJushotiTokureiInfoButtonInsert(){
    if(jushotiTokureiInfoButtonInsert==null){

      jushotiTokureiInfoButtonInsert = new ACButton();

      jushotiTokureiInfoButtonInsert.setText("追加");

      jushotiTokureiInfoButtonInsert.setToolTipText("住所地特例情報を追加します。");

      jushotiTokureiInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addJushotiTokureiInfoButtonInsert();
    }
    return jushotiTokureiInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getJushotiTokureiInfoButtonEdit(){
    if(jushotiTokureiInfoButtonEdit==null){

      jushotiTokureiInfoButtonEdit = new ACButton();

      jushotiTokureiInfoButtonEdit.setText("書替");

      jushotiTokureiInfoButtonEdit.setToolTipText("住所地特例情報を編集します。");

      jushotiTokureiInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addJushotiTokureiInfoButtonEdit();
    }
    return jushotiTokureiInfoButtonEdit;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getJushotiTokureiInfoButtonDelete(){
    if(jushotiTokureiInfoButtonDelete==null){

      jushotiTokureiInfoButtonDelete = new ACButton();

      jushotiTokureiInfoButtonDelete.setText("削除");

      jushotiTokureiInfoButtonDelete.setToolTipText("住所地特例情報を削除します。");

      jushotiTokureiInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addJushotiTokureiInfoButtonDelete();
    }
    return jushotiTokureiInfoButtonDelete;

  }

  /**
   * 住所地特例情報・テーブル領域を取得します。
   * @return 住所地特例情報・テーブル領域
   */
  public ACTable getJushotiTokureiInfoTable(){
    if(jushotiTokureiInfoTable==null){

      jushotiTokureiInfoTable = new ACTable();

      jushotiTokureiInfoTable.setColumnModel(getJushotiTokureiInfoTableColumnModel());

      addJushotiTokureiInfoTable();
    }
    return jushotiTokureiInfoTable;

  }

  /**
   * 住所地特例情報・テーブル領域カラムモデルを取得します。
   * @return 住所地特例情報・テーブル領域カラムモデル
   */
  protected VRTableColumnModel getJushotiTokureiInfoTableColumnModel(){
    if(jushotiTokureiInfoTableColumnModel==null){
      jushotiTokureiInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addJushotiTokureiInfoTableColumnModel();
    }
    return jushotiTokureiInfoTableColumnModel;
  }

  /**
   * №を取得します。
   * @return №
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn0(){
    if(jushotiTokureiInfoTableColumn0==null){

      jushotiTokureiInfoTableColumn0 = new ACTableColumn(0);

      jushotiTokureiInfoTableColumn0.setHeaderValue("No.");

      jushotiTokureiInfoTableColumn0.setColumns(3);

      jushotiTokureiInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      jushotiTokureiInfoTableColumn0.setSortable(false);

      addJushotiTokureiInfoTableColumn0();
    }
    return jushotiTokureiInfoTableColumn0;

  }

  /**
   * 有効期間開始を取得します。
   * @return 有効期間開始
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn1(){
    if(jushotiTokureiInfoTableColumn1==null){

      jushotiTokureiInfoTableColumn1 = new ACTableColumn(0);

      jushotiTokureiInfoTableColumn1.setHeaderValue("有効期間開始");

      jushotiTokureiInfoTableColumn1.setColumnName("JUSHOTI_VALID_START");

      jushotiTokureiInfoTableColumn1.setColumns(10);

      jushotiTokureiInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addJushotiTokureiInfoTableColumn1();
    }
    return jushotiTokureiInfoTableColumn1;

  }

  /**
   * 有効期間終了を取得します。
   * @return 有効期間終了
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn2(){
    if(jushotiTokureiInfoTableColumn2==null){

      jushotiTokureiInfoTableColumn2 = new ACTableColumn(1);

      jushotiTokureiInfoTableColumn2.setHeaderValue("有効期間終了");

      jushotiTokureiInfoTableColumn2.setColumnName("JUSHOTI_VALID_END");

      jushotiTokureiInfoTableColumn2.setColumns(10);

      jushotiTokureiInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addJushotiTokureiInfoTableColumn2();
    }
    return jushotiTokureiInfoTableColumn2;

  }

  /**
   * 施設所在保険者番号を取得します。
   * @return 施設所在保険者番号
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn3(){
    if(jushotiTokureiInfoTableColumn3==null){

      jushotiTokureiInfoTableColumn3 = new ACTableColumn(2);

      jushotiTokureiInfoTableColumn3.setHeaderValue("施設所在保険者番号");

      jushotiTokureiInfoTableColumn3.setColumnName("JUSHOTI_INSURER_ID");

      jushotiTokureiInfoTableColumn3.setColumns(10);

      addJushotiTokureiInfoTableColumn3();
    }
    return jushotiTokureiInfoTableColumn3;

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

    basicInfoAndInfoButton.add(getBasicInfoCheck(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getYokaigodoNowContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 現在の要介護度に内部項目を追加します。
   */
  protected void addYokaigodoNow(){

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

    tabs.addTab("異動情報", getIdouInfoAndInstitutionInfoPanel());

    tabs.addTab("施設情報", getShisetsuInfoPanel());

    tabs.addTab("住所地特例情報", getJushotiTokureiInfoPanel());

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

    kaigoInfo.add(getKaigoInfoInsuredIdContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBenefitContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoShortCounts(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoKyotakuServiceContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDivisionContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoYokaigoInfoContainer(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoValidLimits(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDateContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoAuthorizeDateContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoLimitChanges(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoProvideLimitGroup(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoInterruptionGroup(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoSystemValidLimits(), VRLayout.FLOW_RETURN);

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
   * (短期入所利用日数の初期値・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoShortCounts(){

    kaigoInfoShortCounts.add(getKaigoInfoShortCount(), VRLayout.FLOW);

    kaigoInfoShortCounts.add(getKaigoInfoShortCountDay(), VRLayout.FLOW);

  }

  /**
   * 短期入所利用日数の初期値に内部項目を追加します。
   */
  protected void addKaigoInfoShortCount(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoShortCountDay(){

  }

  /**
   * (居宅サービス計画作成者・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoKyotakuServiceContena(){

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServiceRadio(), VRLayout.FLOW);

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoReportDateContainer(), VRLayout.FLOW_RETURN);

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServicePlanCombo(), VRLayout.FLOW_RETURN);

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
   * 居宅サービス計画作成依頼届出日に内部項目を追加します。
   */
  protected void addKaigoInfoReportDate(){

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
   * (要支援１の額を超えてサービスを利用・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoLimitChanges(){

    kaigoInfoLimitChanges.add(getKaigoInfoLimitChange(), VRLayout.FLOW);

  }

  /**
   * 要支援１の額を超えてサービスを利用に内部項目を追加します。
   */
  protected void addKaigoInfoLimitChange(){

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
   * (有効期間・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoSystemValidLimits(){

    kaigoInfoSystemValidLimits.add(getKaigoInfoSystemValidLimit1(), VRLayout.FLOW);

    kaigoInfoSystemValidLimits.add(getKaigoInfoSystemValidLimit2(), VRLayout.FLOW);

    kaigoInfoSystemValidLimits.add(getKaigoInfoSystemValidLimit3(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addKaigoInfoSystemValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoSystemValidLimit2(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addKaigoInfoSystemValidLimit3(){

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

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn10());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn11());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn12());

  }

  /**
   * Noに内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn0(){

  }

  /**
   * システム有効開始に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn1(){

  }

  /**
   * システム有効終了に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn2(){

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn3(){

  }

  /**
   * 申請日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn4(){

  }

  /**
   * 申請区分に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn5(){

  }

  /**
   * 要介護情報に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn6(){

  }

  /**
   * 認定有効期間開始に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn7(){

  }

  /**
   * 認定有効期間終了に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn8(){

  }

  /**
   * 作成依頼届出日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn9(){

  }

  /**
   * 中断年月日に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn10(){

  }

  /**
   * 中断理由に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn11(){

  }

  /**
   * 支給限度額に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn12(){

  }

  /**
   * (異動・施設情報・パネル)に内部項目を追加します。
   */
  protected void addIdouInfoAndInstitutionInfoPanel(){

    idouInfoAndInstitutionInfoPanel.add(getIdouInfoAndInstitutionInfos(), VRLayout.CLIENT);

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

    idouInfoButtons.add(getIdouInfoButtonClear(), VRLayout.WEST);

    idouInfoButtons.add(getIdouInfoButtonInsert(), VRLayout.WEST);

    idouInfoButtons.add(getIdouInfoButtonEdit(), VRLayout.WEST);

    idouInfoButtons.add(getIdouInfoButtonDelete(), VRLayout.WEST);

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
   * 特定入所者情報・パネルに内部項目を追加します。
   */
  protected void addShisetsuInfoPanel(){

    shisetsuInfoPanel.add(getShisetsuInputPanel(), VRLayout.NORTH);

    shisetsuInfoPanel.add(getShisetsuInfoButtons(), VRLayout.NORTH);

    shisetsuInfoPanel.add(getShisetsuInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 特定入所者入力領域・パネルに内部項目を追加します。
   */
  protected void addShisetsuInputPanel(){

    shisetsuInputPanel.add(getShisetsuInfSyokuhiPanel(), VRLayout.NORTH);

    shisetsuInputPanel.add(getShisetsuInfoOtherPanel(), VRLayout.NORTH);

    shisetsuInputPanel.add(getShisetsuInfoLimitPanel(), VRLayout.NORTH);

  }

  /**
   * 食費居住費・パネルに内部項目を追加します。
   */
  protected void addShisetsuInfSyokuhiPanel(){

    shisetsuInfSyokuhiPanel.add(getShisetsuInfoSyokuhiGroup(), VRLayout.WEST);

    shisetsuInfSyokuhiPanel.add(getShisetsuInfRigthtPanel(), VRLayout.WEST);

  }

  /**
   * 食費居住費・グループに内部項目を追加します。
   */
  protected void addShisetsuInfoSyokuhiGroup(){

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoSpaceLabel(), VRLayout.FLOW);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoTokuteiCheck(), VRLayout.FLOW_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoDinnerBearLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoUnitRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoUnitSemiRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoNormalRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoNormalRoomLimitMoneyContena2(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoTasyoRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoTasyoRoomLimitMoneyContena2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 食費・居住費領域・レイアウトに内部項目を追加します。
   */
  protected void addShisetsuInfoSyokuhiLayout(){

  }

  /**
   * 特定入所スペーサーに内部項目を追加します。
   */
  protected void addShisetsuInfoSpaceLabel(){

  }

  /**
   * 特定入所者チェックに内部項目を追加します。
   */
  protected void addShisetsuInfoTokuteiCheck(){

  }

  /**
   * 食費負担限度額・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoDinnerBearLimitMoneyContena(){

    shisetsuInfoDinnerBearLimitMoneyContena.add(getShisetsuInfoDinnerBearLimitMoneyText(), null);

    shisetsuInfoDinnerBearLimitMoneyContena.add(getShisetsuInfoDinnerBearLimitMoneyLabel(), null);

  }

  /**
   * 食費負担限度額・テキストに内部項目を追加します。
   */
  protected void addShisetsuInfoDinnerBearLimitMoneyText(){

  }

  /**
   * 食費負担限度額・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoDinnerBearLimitMoneyLabel(){

  }

  /**
   * ユニット型個室負担限度額・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoUnitRoomLimitMoneyContena(){

    shisetsuInfoUnitRoomLimitMoneyContena.add(getShisetsuInfoUnitRoomLimitMoneyText(), null);

    shisetsuInfoUnitRoomLimitMoneyContena.add(getShisetsuInfoUnitRoomLimitMoneyLabel(), null);

  }

  /**
   * ユニット型個室負担限度額・テキストに内部項目を追加します。
   */
  protected void addShisetsuInfoUnitRoomLimitMoneyText(){

  }

  /**
   * ユニット型個室負担限度額・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoUnitRoomLimitMoneyLabel(){

  }

  /**
   * ユニット型個室的多床室負担限度額・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoUnitSemiRoomLimitMoneyContena(){

    shisetsuInfoUnitSemiRoomLimitMoneyContena.add(getShisetsuInfoUnitSemiRoomLimitMoneyText(), null);

    shisetsuInfoUnitSemiRoomLimitMoneyContena.add(getShisetsuInfoUnitSemiRoomLimitMoneyLabel(), null);

  }

  /**
   * ユニット型個室的多床室負担限度額・テキストに内部項目を追加します。
   */
  protected void addShisetsuInfoUnitSemiRoomLimitMoneyText(){

  }

  /**
   * ユニット型個室的多床室負担限度額・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoUnitSemiRoomLimitMoneyLabel(){

  }

  /**
   * 従来型個室特養等負担限度額・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyContena(){

    shisetsuInfoNormalRoomLimitMoneyContena.add(getShisetsuInfoNormalRoomLimitMoneyText(), null);

    shisetsuInfoNormalRoomLimitMoneyContena.add(getShisetsuInfoNormalRoomLimitMoneyLabel(), null);

  }

  /**
   * 従来型個室特養等負担限度額・テキストに内部項目を追加します。
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyText(){

  }

  /**
   * 従来型個室特養等負担限度額・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyLabel(){

  }

  /**
   * 従来型個室老健・療養・介護医療院等負担限度額・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyContena2(){

    shisetsuInfoNormalRoomLimitMoneyContena2.add(getShisetsuInfoNormalRoomLimitMoneyText2(), null);

    shisetsuInfoNormalRoomLimitMoneyContena2.add(getShisetsuInfoNormalRoomLimitMoneyLabel2(), null);

  }

  /**
   * 従来型個室老健・療養・介護医療院等負担限度額・テキストに内部項目を追加します。
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyText2(){

  }

  /**
   * 従来型個室老健・療養・介護医療院等負担限度額・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyLabel2(){

  }

  /**
   * 多床室特養等負担限度額・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyContena(){

    shisetsuInfoTasyoRoomLimitMoneyContena.add(getShisetsuInfoTasyoRoomLimitMoneyText(), null);

    shisetsuInfoTasyoRoomLimitMoneyContena.add(getShisetsuInfoTasyoRoomLimitMoneyLabel(), null);

  }

  /**
   * 多床室特養等負担限度額・テキストに内部項目を追加します。
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyText(){

  }

  /**
   * 多床室特養等負担限度額・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyLabel(){

  }

  /**
   * 多床室老健・療養・介護医療院等負担限度額・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyContena2(){

    shisetsuInfoTasyoRoomLimitMoneyContena2.add(getShisetsuInfoTasyoRoomLimitMoneyText2(), null);

    shisetsuInfoTasyoRoomLimitMoneyContena2.add(getShisetsuInfoTasyoRoomLimitMoneyLabel2(), null);

  }

  /**
   * 多床室老健・療養・介護医療院等負担限度額・テキストに内部項目を追加します。
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyText2(){

  }

  /**
   * 多床室老健・療養・介護医療院等負担限度額・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyLabel2(){

  }

  /**
   * 右パネルに内部項目を追加します。
   */
  protected void addShisetsuInfRigthtPanel(){

    shisetsuInfRigthtPanel.add(getShisetsuInfoCareOldPersonGroup(), VRLayout.NORTH);

    shisetsuInfRigthtPanel.add(getShisetsuInfoCareOldPersonInsuranceGroup(), VRLayout.NORTH);

    shisetsuInfRigthtPanel.add(getShisetsuInfoExplanationGroup(), VRLayout.NORTH);

  }

  /**
   * 介護老人福祉施設・グループに内部項目を追加します。
   */
  protected void addShisetsuInfoCareOldPersonGroup(){

    shisetsuInfoCareOldPersonGroup.add(getShisetsuInfoOldStep(), VRLayout.FLOW);

  }

  /**
   * 旧措置入所者特例に内部項目を追加します。
   */
  protected void addShisetsuInfoOldStep(){

  }

  /**
   * 介護老人保健施設・介護療養型医療施設・介護医療院グループに内部項目を追加します。
   */
  protected void addShisetsuInfoCareOldPersonInsuranceGroup(){

    shisetsuInfoCareOldPersonInsuranceGroup.add(getShisetsuInfoMainDiseaseContainer(), VRLayout.FLOW);

  }

  /**
   * 主傷病に内部項目を追加します。
   */
  protected void addShisetsuInfoMainDisease(){

  }

  /**
   * 説明文グループに内部項目を追加します。
   */
  protected void addShisetsuInfoExplanationGroup(){

    shisetsuInfoExplanationGroup.add(getShisetsuInfoExplanationLabel1(), VRLayout.NORTH);

    shisetsuInfoExplanationGroup.add(getShisetsuInfoExplanationLabel2(), VRLayout.NORTH);

  }

  /**
   * 説明文ラベル1に内部項目を追加します。
   */
  protected void addShisetsuInfoExplanationLabel1(){

  }

  /**
   * 説明文ラベル2に内部項目を追加します。
   */
  protected void addShisetsuInfoExplanationLabel2(){

  }

  /**
   * 施設情報・その他パネルに内部項目を追加します。
   */
  protected void addShisetsuInfoOtherPanel(){

  }

  /**
   * 施設情報その他領域・レイアウトに内部項目を追加します。
   */
  protected void addShisetsuInfoOtherLayout(){

  }

  /**
   * 有効期間領域・パネルに内部項目を追加します。
   */
  protected void addShisetsuInfoLimitPanel(){

    shisetsuInfoLimitPanel.add(getShisetsuInfoValidLimitContainer(), VRLayout.FLOW);

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addShisetsuInfoValidLimitContainer(){

    shisetsuInfoValidLimitContainer.add(getShisetsuInfoValidLimitDateStart(), VRLayout.FLOW);

    shisetsuInfoValidLimitContainer.add(getShisetsuInfoValidLimitLabel(), VRLayout.FLOW);

    shisetsuInfoValidLimitContainer.add(getShisetsuInfoValidLimitDateEnd(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addShisetsuInfoValidLimitDateStart(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addShisetsuInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addShisetsuInfoValidLimitDateEnd(){

  }

  /**
   * 特定入所者情報・ボタン領域に内部項目を追加します。
   */
  protected void addShisetsuInfoButtons(){

    shisetsuInfoButtons.add(getShisetsuInfoButtonClear(), VRLayout.WEST);

    shisetsuInfoButtons.add(getShisetsuInfoButtonInsert(), VRLayout.WEST);

    shisetsuInfoButtons.add(getShisetsuInfoButtonEdit(), VRLayout.WEST);

    shisetsuInfoButtons.add(getShisetsuInfoButtonDelete(), VRLayout.WEST);

  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addShisetsuInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addShisetsuInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addShisetsuInfoButtonEdit(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addShisetsuInfoButtonDelete(){

  }

  /**
   * 特定入所者情報・テーブル領域に内部項目を追加します。
   */
  protected void addShisetsuInfoTable(){

  }

  /**
   * 特定入所者情報・テーブル領域カラムモデルに内部項目を追加します。
   */
  protected void addShisetsuInfoTableColumnModel(){

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn0());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn1());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn2());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn3());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn4());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn5());

  }

  /**
   * №に内部項目を追加します。
   */
  protected void addShisetsuInfoTableColumn0(){

  }

  /**
   * 有効期間開始に内部項目を追加します。
   */
  protected void addShisetsuInfoTableColumn1(){

  }

  /**
   * 有効期間終了に内部項目を追加します。
   */
  protected void addShisetsuInfoTableColumn2(){

  }

  /**
   * 特定入所者に内部項目を追加します。
   */
  protected void addShisetsuInfoTableColumn3(){

  }

  /**
   * 旧措置入所者特例に内部項目を追加します。
   */
  protected void addShisetsuInfoTableColumn4(){

  }

  /**
   * 主傷病名に内部項目を追加します。
   */
  protected void addShisetsuInfoTableColumn5(){

  }

  /**
   * 住所地特例情報・パネルに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoPanel(){

    jushotiTokureiInfoPanel.add(getJushotiTokureiInputPanel(), VRLayout.NORTH);

    jushotiTokureiInfoPanel.add(getJushotiTokureiInfoButtons(), VRLayout.NORTH);

    jushotiTokureiInfoPanel.add(getJushotiTokureiInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 住所地特例入力領域・パネルに内部項目を追加します。
   */
  protected void addJushotiTokureiInputPanel(){

    jushotiTokureiInputPanel.add(getJushotiTokureiInfoGroup(), VRLayout.NORTH);

    jushotiTokureiInputPanel.add(getJushotiTokureiInfoLimitPanel(), VRLayout.NORTH);

  }

  /**
   * 食費居住費・グループに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoGroup(){

    jushotiTokureiInfoGroup.add(getJushotiTokureiInfoInsurerIdContainer(), VRLayout.FLOW_INSETLINE);

    jushotiTokureiInfoGroup.add(getJushotiTokureiInfoInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (住所地特例基本領域・レイアウト)に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoLayout2(){

  }

  /**
   * 施設所在保険者番号に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoInsurerId(){

  }

  /**
   * 施設所在保険者名に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoInsurerName(){

  }

  /**
   * 施設所在保険者名モデルに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoInsurerNameModel(){

  }

  /**
   * 有効期間領域・パネルに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoLimitPanel(){

    jushotiTokureiInfoLimitPanel.add(getJushotiTokureiInfoValidLimitContainer(), VRLayout.FLOW);

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoValidLimitContainer(){

    jushotiTokureiInfoValidLimitContainer.add(getJushotiTokureiInfoValidLimitDateStart(), VRLayout.FLOW);

    jushotiTokureiInfoValidLimitContainer.add(getJushotiTokureiInfoValidLimitLabel(), VRLayout.FLOW);

    jushotiTokureiInfoValidLimitContainer.add(getJushotiTokureiInfoValidLimitDateEnd(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoValidLimitDateStart(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoValidLimitDateEnd(){

  }

  /**
   * 住所地特例情報・ボタン領域に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoButtons(){

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonClear(), VRLayout.WEST);

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonInsert(), VRLayout.WEST);

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonEdit(), VRLayout.WEST);

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonDelete(), VRLayout.WEST);

  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoButtonEdit(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoButtonDelete(){

  }

  /**
   * 住所地特例情報・テーブル領域に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoTable(){

  }

  /**
   * 住所地特例情報・テーブル領域カラムモデルに内部項目を追加します。
   */
  protected void addJushotiTokureiInfoTableColumnModel(){

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn0());

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn1());

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn2());

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn3());

  }

  /**
   * №に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoTableColumn0(){

  }

  /**
   * 有効期間開始に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoTableColumn1(){

  }

  /**
   * 有効期間終了に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoTableColumn2(){

  }

  /**
   * 施設所在保険者番号に内部項目を追加します。
   */
  protected void addJushotiTokureiInfoTableColumn3(){

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
