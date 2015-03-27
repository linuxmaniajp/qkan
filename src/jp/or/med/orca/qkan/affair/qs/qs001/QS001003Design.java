
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
 * 作成日: 2006/06/09  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: 2014/10/23  MIS九州株式会社 日高 しのぶ
 * システム 給付管理台帳 (Q)
 * サブシステム サービス作成/変更 (S)
 * プロセス サービス予定・実績 (001)
 * プログラム 利用・提供票印刷 (QS001003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * 利用・提供票印刷画面項目デザイン(QS001003) 
 */
@SuppressWarnings("serial")
public class QS001003Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel uppers;

  private ACPanel upperLefts;

  private ACPanel patients;

  private ACTextField patentName;

  private ACLabelContainer patentNameContainer;

  private ACTextField serviceYearMonth;

  private ACLabelContainer serviceYearMonthContainer;

  private ACPanel prividers;

  private ACClearableRadioButtonGroup planManufacturer;

  private ACLabelContainer planManufacturerContainer;

  private ACListModelAdapter planManufacturerModel;

  private ACRadioButtonItem supportProvider;

  private ACRadioButtonItem patent;

  private ACRadioButtonItem preventSupportProvider;

  private ACLabelContainer supportProviderContainer;

  private ACLabel supportProviderCd;

  private ACComboBox supportProviderName;

  private ACComboBoxModelAdapter supportProviderNameModel;

  private ACComboBox personInCharge;

  private ACLabelContainer personInChargeContainer;

  private ACComboBoxModelAdapter personInChargeModel;

  private ACPanel upperRights;

  private QkanDateTextField dateOfMakingOutsideFrame;

  private ACLabelContainer dateOfMakingOutsideFrameContainer;

  private QkanDateTextField dateOfMaking;

  private ACLabelContainer dateOfMakingContainer;

  private QkanDateTextField dateOfWrittenReport;

  private ACLabelContainer dateOfWrittenReportContainer;

  private ACLabel solid2;

  private ACPanel middles;

  private ACGroupBox stateOfYouKaigo;

  private ACLabel youKaigodoType1;

  private ACLabel youKaigodoType2;

  private ACPanel limitAmountInformation;

  private ACLabelContainer limitAmountContainer;

  private ACTextField limitAmountContent;

  private ACLabel solid4;

  private ACLabelContainer limitAmountApplicationPeriod;

  private ACTextField applicationPeriodBegin;

  private ACLabel solid5;

  private ACTextField applicationPeriodEnd;

  private ACPanel shortStayAndPublicExpense;

  private ACLabelContainer shortStayUseDays;

  private ACLabel solid6;

  private ACTextField shortStayUseDay;

  private ACLabel solid8;

  private ACLabelContainer publicExpenses;

  private ACIntegerCheckBox publicExpense;

  private ACPanel lowers;

  private ACGroupBox slitTypes;

  private ACClearableRadioButtonGroup slitType;

  private ACListModelAdapter slitTypeModel;

  private ACRadioButtonItem useVoteType;

  private ACRadioButtonItem offerVote;

  private ACGroupBox slitKinds;

  private ACClearableRadioButtonGroup slitKind;

  private ACListModelAdapter slitKindModel;

  private ACRadioButtonItem useVoteAndAttachedTable;

  private ACRadioButtonItem useVoteKind;

  private ACRadioButtonItem attachedTable;

  private ACGroupBox slitKeisyos;

  private ACClearableRadioButtonGroup slitKeisyo;

  private ACListModelAdapter slitKeisyoModel;

  private ACRadioButtonItem sama;

  private ACRadioButtonItem dono;

  private ACRadioButtonItem nashi;

  private ACPanel printButtonArea;

  private ACPanel printButtons;

  private ACButton print;

  private ACButton end;

  //getter

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 上段領域を取得します。
   * @return 上段領域
   */
  public ACPanel getUppers(){
    if(uppers==null){

      uppers = new ACPanel();

      addUppers();
    }
    return uppers;

  }

  /**
   * 上段領域左を取得します。
   * @return 上段領域左
   */
  public ACPanel getUpperLefts(){
    if(upperLefts==null){

      upperLefts = new ACPanel();

      addUpperLefts();
    }
    return upperLefts;

  }

  /**
   * 利用者情報領域を取得します。
   * @return 利用者情報領域
   */
  public ACPanel getPatients(){
    if(patients==null){

      patients = new ACPanel();

      addPatients();
    }
    return patients;

  }

  /**
   * 利用者名ラベルを取得します。
   * @return 利用者名ラベル
   */
  public ACTextField getPatentName(){
    if(patentName==null){

      patentName = new ACTextField();

      getPatentNameContainer().setText("利用者氏名");

      patentName.setBindPath("PATIENT_NAME");

      patentName.setEditable(false);

      patentName.setColumns(34);

      addPatentName();
    }
    return patentName;

  }

  /**
   * 利用者名ラベルコンテナを取得します。
   * @return 利用者名ラベルコンテナ
   */
  protected ACLabelContainer getPatentNameContainer(){
    if(patentNameContainer==null){
      patentNameContainer = new ACLabelContainer();
      patentNameContainer.setFollowChildEnabled(true);
      patentNameContainer.setVAlignment(VRLayout.CENTER);
      patentNameContainer.add(getPatentName(), null);
    }
    return patentNameContainer;
  }

  /**
   * 年月ラベルを取得します。
   * @return 年月ラベル
   */
  public ACTextField getServiceYearMonth(){
    if(serviceYearMonth==null){

      serviceYearMonth = new ACTextField();

      getServiceYearMonthContainer().setText("対象年月");

      serviceYearMonth.setBindPath("TARGET_DATE");

      serviceYearMonth.setEditable(false);

      serviceYearMonth.setColumns(8);

      addServiceYearMonth();
    }
    return serviceYearMonth;

  }

  /**
   * 年月ラベルコンテナを取得します。
   * @return 年月ラベルコンテナ
   */
  protected ACLabelContainer getServiceYearMonthContainer(){
    if(serviceYearMonthContainer==null){
      serviceYearMonthContainer = new ACLabelContainer();
      serviceYearMonthContainer.setFollowChildEnabled(true);
      serviceYearMonthContainer.setVAlignment(VRLayout.CENTER);
      serviceYearMonthContainer.add(getServiceYearMonth(), null);
    }
    return serviceYearMonthContainer;
  }

  /**
   * 事業者情報領域を取得します。
   * @return 事業者情報領域
   */
  public ACPanel getPrividers(){
    if(prividers==null){

      prividers = new ACPanel();

      addPrividers();
    }
    return prividers;

  }

  /**
   * 計画作成者ラジオグループを取得します。
   * @return 計画作成者ラジオグループ
   */
  public ACClearableRadioButtonGroup getPlanManufacturer(){
    if(planManufacturer==null){

      planManufacturer = new ACClearableRadioButtonGroup();

      getPlanManufacturerContainer().setText("居宅計画作成者");

      planManufacturer.setUseClearButton(false);

      planManufacturer.setModel(getPlanManufacturerModel());

      addPlanManufacturer();
    }
    return planManufacturer;

  }

  /**
   * 計画作成者ラジオグループコンテナを取得します。
   * @return 計画作成者ラジオグループコンテナ
   */
  protected ACLabelContainer getPlanManufacturerContainer(){
    if(planManufacturerContainer==null){
      planManufacturerContainer = new ACLabelContainer();
      planManufacturerContainer.setFollowChildEnabled(true);
      planManufacturerContainer.setVAlignment(VRLayout.CENTER);
      planManufacturerContainer.add(getPlanManufacturer(), null);
    }
    return planManufacturerContainer;
  }

  /**
   * 計画作成者ラジオグループモデルを取得します。
   * @return 計画作成者ラジオグループモデル
   */
  protected ACListModelAdapter getPlanManufacturerModel(){
    if(planManufacturerModel==null){
      planManufacturerModel = new ACListModelAdapter();
      addPlanManufacturerModel();
    }
    return planManufacturerModel;
  }

  /**
   * 居宅介護支援事業者を取得します。
   * @return 居宅介護支援事業者
   */
  public ACRadioButtonItem getSupportProvider(){
    if(supportProvider==null){

      supportProvider = new ACRadioButtonItem();

      supportProvider.setText("居宅介護支援事業所");

      supportProvider.setGroup(getPlanManufacturer());

      addSupportProvider();
    }
    return supportProvider;

  }

  /**
   * 被保険者を取得します。
   * @return 被保険者
   */
  public ACRadioButtonItem getPatent(){
    if(patent==null){

      patent = new ACRadioButtonItem();

      patent.setText("被保険者");

      patent.setGroup(getPlanManufacturer());

      addPatent();
    }
    return patent;

  }

  /**
   * 介護予防支援事業所を取得します。
   * @return 介護予防支援事業所
   */
  public ACRadioButtonItem getPreventSupportProvider(){
    if(preventSupportProvider==null){

      preventSupportProvider = new ACRadioButtonItem();

      preventSupportProvider.setText("介護予防支援事業所");

      preventSupportProvider.setGroup(getPlanManufacturer());

      addPreventSupportProvider();
    }
    return preventSupportProvider;

  }

  /**
   * 居宅支援事業者情報コンテナを取得します。
   * @return 居宅支援事業者情報コンテナ
   */
  public ACLabelContainer getSupportProviderContainer(){
    if(supportProviderContainer==null){

      supportProviderContainer = new ACLabelContainer();

      supportProviderContainer.setText("居宅支援事業所");

      supportProviderContainer.setAutoWrap(false);

      supportProviderContainer.setHgap(0);

      addSupportProviderContainer();
    }
    return supportProviderContainer;

  }

  /**
   * 事業者番号ラベルを取得します。
   * @return 事業者番号ラベル
   */
  public ACLabel getSupportProviderCd(){
    if(supportProviderCd==null){

      supportProviderCd = new ACLabel();

      supportProviderCd.setColumns(10);

      addSupportProviderCd();
    }
    return supportProviderCd;

  }

  /**
   * 事業者名称コンボを取得します。
   * @return 事業者名称コンボ
   */
  public ACComboBox getSupportProviderName(){
    if(supportProviderName==null){

      supportProviderName = new ACComboBox();

      supportProviderName.setBindPath("PROVIDER_ID");

      supportProviderName.setEditable(false);

      supportProviderName.setRenderBindPath("PROVIDER_NAME");

      supportProviderName.setMaxColumns(30);

      supportProviderName.setModel(getSupportProviderNameModel());

      addSupportProviderName();
    }
    return supportProviderName;

  }

  /**
   * 事業者名称コンボモデルを取得します。
   * @return 事業者名称コンボモデル
   */
  protected ACComboBoxModelAdapter getSupportProviderNameModel(){
    if(supportProviderNameModel==null){
      supportProviderNameModel = new ACComboBoxModelAdapter();
      addSupportProviderNameModel();
    }
    return supportProviderNameModel;
  }

  /**
   * 担当者コンボを取得します。
   * @return 担当者コンボ
   */
  public ACComboBox getPersonInCharge(){
    if(personInCharge==null){

      personInCharge = new ACComboBox();

      getPersonInChargeContainer().setText("担当者名");

      personInCharge.setBindPath("STAFF_NAME");

      personInCharge.setEditable(false);

      personInCharge.setRenderBindPath("STAFF_NAME");

      personInCharge.setMaxColumns(30);

      personInCharge.setModel(getPersonInChargeModel());

      addPersonInCharge();
    }
    return personInCharge;

  }

  /**
   * 担当者コンボコンテナを取得します。
   * @return 担当者コンボコンテナ
   */
  protected ACLabelContainer getPersonInChargeContainer(){
    if(personInChargeContainer==null){
      personInChargeContainer = new ACLabelContainer();
      personInChargeContainer.setFollowChildEnabled(true);
      personInChargeContainer.setVAlignment(VRLayout.CENTER);
      personInChargeContainer.add(getPersonInCharge(), VRLayout.CLIENT);
    }
    return personInChargeContainer;
  }

  /**
   * 担当者コンボモデルを取得します。
   * @return 担当者コンボモデル
   */
  protected ACComboBoxModelAdapter getPersonInChargeModel(){
    if(personInChargeModel==null){
      personInChargeModel = new ACComboBoxModelAdapter();
      addPersonInChargeModel();
    }
    return personInChargeModel;
  }

  /**
   * 上段領域右を取得します。
   * @return 上段領域右
   */
  public ACPanel getUpperRights(){
    if(upperRights==null){

      upperRights = new ACPanel();

      upperRights.setHgrid(300);

      addUpperRights();
    }
    return upperRights;

  }

  /**
   * 作成年月日（別表）を取得します。
   * @return 作成年月日（別表）
   */
  public QkanDateTextField getDateOfMakingOutsideFrame(){
    if(dateOfMakingOutsideFrame==null){

      dateOfMakingOutsideFrame = new QkanDateTextField();

      getDateOfMakingOutsideFrameContainer().setText("作成年月日（別表）");

      dateOfMakingOutsideFrame.setBindPath("CREATE_DATE_OUTER");

      addDateOfMakingOutsideFrame();
    }
    return dateOfMakingOutsideFrame;

  }

  /**
   * 作成年月日（別表）コンテナを取得します。
   * @return 作成年月日（別表）コンテナ
   */
  protected ACLabelContainer getDateOfMakingOutsideFrameContainer(){
    if(dateOfMakingOutsideFrameContainer==null){
      dateOfMakingOutsideFrameContainer = new ACLabelContainer();
      dateOfMakingOutsideFrameContainer.setFollowChildEnabled(true);
      dateOfMakingOutsideFrameContainer.setVAlignment(VRLayout.CENTER);
      dateOfMakingOutsideFrameContainer.add(getDateOfMakingOutsideFrame(), null);
    }
    return dateOfMakingOutsideFrameContainer;
  }

  /**
   * 作成年月日を取得します。
   * @return 作成年月日
   */
  public QkanDateTextField getDateOfMaking(){
    if(dateOfMaking==null){

      dateOfMaking = new QkanDateTextField();

      getDateOfMakingContainer().setText("作成年月日");

      dateOfMaking.setBindPath("CREATE_DATE_INNER");

      addDateOfMaking();
    }
    return dateOfMaking;

  }

  /**
   * 作成年月日コンテナを取得します。
   * @return 作成年月日コンテナ
   */
  protected ACLabelContainer getDateOfMakingContainer(){
    if(dateOfMakingContainer==null){
      dateOfMakingContainer = new ACLabelContainer();
      dateOfMakingContainer.setFollowChildEnabled(true);
      dateOfMakingContainer.setVAlignment(VRLayout.CENTER);
      dateOfMakingContainer.add(getDateOfMaking(), null);
    }
    return dateOfMakingContainer;
  }

  /**
   * 届出年月日を取得します。
   * @return 届出年月日
   */
  public QkanDateTextField getDateOfWrittenReport(){
    if(dateOfWrittenReport==null){

      dateOfWrittenReport = new QkanDateTextField();

      getDateOfWrittenReportContainer().setText("届出年月日");

      dateOfWrittenReport.setBindPath("DATE_OF_WRITTEN_REPORT");

      addDateOfWrittenReport();
    }
    return dateOfWrittenReport;

  }

  /**
   * 届出年月日コンテナを取得します。
   * @return 届出年月日コンテナ
   */
  protected ACLabelContainer getDateOfWrittenReportContainer(){
    if(dateOfWrittenReportContainer==null){
      dateOfWrittenReportContainer = new ACLabelContainer();
      dateOfWrittenReportContainer.setFollowChildEnabled(true);
      dateOfWrittenReportContainer.setVAlignment(VRLayout.CENTER);
      dateOfWrittenReportContainer.add(getDateOfWrittenReport(), null);
    }
    return dateOfWrittenReportContainer;
  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getSolid2(){
    if(solid2==null){

      solid2 = new ACLabel();

      solid2.setText("（被保険者自己作成の場合のみ）");

      addSolid2();
    }
    return solid2;

  }

  /**
   * 中段領域を取得します。
   * @return 中段領域
   */
  public ACPanel getMiddles(){
    if(middles==null){

      middles = new ACPanel();

      middles.setAutoWrap(false);

      addMiddles();
    }
    return middles;

  }

  /**
   * 要介護状態区分領域を取得します。
   * @return 要介護状態区分領域
   */
  public ACGroupBox getStateOfYouKaigo(){
    if(stateOfYouKaigo==null){

      stateOfYouKaigo = new ACGroupBox();

      stateOfYouKaigo.setText("要介護状態区分");

      stateOfYouKaigo.setAutoWrap(false);

      addStateOfYouKaigo();
    }
    return stateOfYouKaigo;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getYouKaigodoType1(){
    if(youKaigodoType1==null){

      youKaigodoType1 = new ACLabel();

      youKaigodoType1.setBindPath("YOKAIGODO_TYPE1");

      addYouKaigodoType1();
    }
    return youKaigodoType1;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getYouKaigodoType2(){
    if(youKaigodoType2==null){

      youKaigodoType2 = new ACLabel();

      youKaigodoType2.setBindPath("YOKAIGODO_TYPE2");

      addYouKaigodoType2();
    }
    return youKaigodoType2;

  }

  /**
   * 限度額情報領域を取得します。
   * @return 限度額情報領域
   */
  public ACPanel getLimitAmountInformation(){
    if(limitAmountInformation==null){

      limitAmountInformation = new ACPanel();

      addLimitAmountInformation();
    }
    return limitAmountInformation;

  }

  /**
   * 限度額コンテナを取得します。
   * @return 限度額コンテナ
   */
  public ACLabelContainer getLimitAmountContainer(){
    if(limitAmountContainer==null){

      limitAmountContainer = new ACLabelContainer();

      limitAmountContainer.setText("支給限度基準額");

      addLimitAmountContainer();
    }
    return limitAmountContainer;

  }

  /**
   * 支給限度基準額を取得します。
   * @return 支給限度基準額
   */
  public ACTextField getLimitAmountContent(){
    if(limitAmountContent==null){

      limitAmountContent = new ACTextField();

      limitAmountContent.setBindPath("LIMIT_AMOUNT_CONTENT");

      limitAmountContent.setEditable(false);

      limitAmountContent.setColumns(9);

      limitAmountContent.setCharType(VRCharType.ONLY_DIGIT);

      limitAmountContent.setHorizontalAlignment(SwingConstants.RIGHT);

      limitAmountContent.setIMEMode(InputSubset.LATIN);

      limitAmountContent.setMaxLength(15);

      addLimitAmountContent();
    }
    return limitAmountContent;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getSolid4(){
    if(solid4==null){

      solid4 = new ACLabel();

      solid4.setText("単位");

      addSolid4();
    }
    return solid4;

  }

  /**
   * 限度額適用期間コンテナを取得します。
   * @return 限度額適用期間コンテナ
   */
  public ACLabelContainer getLimitAmountApplicationPeriod(){
    if(limitAmountApplicationPeriod==null){

      limitAmountApplicationPeriod = new ACLabelContainer();

      limitAmountApplicationPeriod.setText("限度額適用期間");

      addLimitAmountApplicationPeriod();
    }
    return limitAmountApplicationPeriod;

  }

  /**
   * 適用期間開始を取得します。
   * @return 適用期間開始
   */
  public ACTextField getApplicationPeriodBegin(){
    if(applicationPeriodBegin==null){

      applicationPeriodBegin = new ACTextField();

      applicationPeriodBegin.setBindPath("INSURE_VALID_START");

      applicationPeriodBegin.setEditable(false);

      applicationPeriodBegin.setColumns(8);

      addApplicationPeriodBegin();
    }
    return applicationPeriodBegin;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getSolid5(){
    if(solid5==null){

      solid5 = new ACLabel();

      solid5.setText("から");

      addSolid5();
    }
    return solid5;

  }

  /**
   * 適用期間終了を取得します。
   * @return 適用期間終了
   */
  public ACTextField getApplicationPeriodEnd(){
    if(applicationPeriodEnd==null){

      applicationPeriodEnd = new ACTextField();

      applicationPeriodEnd.setBindPath("INSURE_VALID_END");

      applicationPeriodEnd.setEditable(false);

      applicationPeriodEnd.setColumns(8);

      addApplicationPeriodEnd();
    }
    return applicationPeriodEnd;

  }

  /**
   * 短期入所公費情報領域を取得します。
   * @return 短期入所公費情報領域
   */
  public ACPanel getShortStayAndPublicExpense(){
    if(shortStayAndPublicExpense==null){

      shortStayAndPublicExpense = new ACPanel();

      addShortStayAndPublicExpense();
    }
    return shortStayAndPublicExpense;

  }

  /**
   * 短期入所利用日数コンテナを取得します。
   * @return 短期入所利用日数コンテナ
   */
  public ACLabelContainer getShortStayUseDays(){
    if(shortStayUseDays==null){

      shortStayUseDays = new ACLabelContainer();

      addShortStayUseDays();
    }
    return shortStayUseDays;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getSolid6(){
    if(solid6==null){

      solid6 = new ACLabel();

      solid6.setText("前月までの短期入所利用日数");

      addSolid6();
    }
    return solid6;

  }

  /**
   * 短期入所利用日数を取得します。
   * @return 短期入所利用日数
   */
  public ACTextField getShortStayUseDay(){
    if(shortStayUseDay==null){

      shortStayUseDay = new ACTextField();

      shortStayUseDay.setBindPath("SHORT_STAY_USE_DAY");

      shortStayUseDay.setColumns(3);

      shortStayUseDay.setCharType(VRCharType.ONLY_DIGIT);

      shortStayUseDay.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayUseDay.setIMEMode(InputSubset.LATIN);

      shortStayUseDay.setMaxLength(15);

      addShortStayUseDay();
    }
    return shortStayUseDay;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getSolid8(){
    if(solid8==null){

      solid8 = new ACLabel();

      solid8.setText("日");

      addSolid8();
    }
    return solid8;

  }

  /**
   * 公費コンテナを取得します。
   * @return 公費コンテナ
   */
  public ACLabelContainer getPublicExpenses(){
    if(publicExpenses==null){

      publicExpenses = new ACLabelContainer();

      addPublicExpenses();
    }
    return publicExpenses;

  }

  /**
   * 公費チェックを取得します。
   * @return 公費チェック
   */
  public ACIntegerCheckBox getPublicExpense(){
    if(publicExpense==null){

      publicExpense = new ACIntegerCheckBox();

      publicExpense.setText("公費も含めた給付率で別表を作成(E)");

      publicExpense.setBindPath("WITH_PUBLIC_EXPENSE");

      publicExpense.setMnemonic('E');

      addPublicExpense();
    }
    return publicExpense;

  }

  /**
   * 下段領域を取得します。
   * @return 下段領域
   */
  public ACPanel getLowers(){
    if(lowers==null){

      lowers = new ACPanel();

      lowers.setAutoWrap(false);

      addLowers();
    }
    return lowers;

  }

  /**
   * 帳票種別選択フレームを取得します。
   * @return 帳票種別選択フレーム
   */
  public ACGroupBox getSlitTypes(){
    if(slitTypes==null){

      slitTypes = new ACGroupBox();

      slitTypes.setText("帳票種別選択");

      addSlitTypes();
    }
    return slitTypes;

  }

  /**
   * 種別選択を取得します。
   * @return 種別選択
   */
  public ACClearableRadioButtonGroup getSlitType(){
    if(slitType==null){

      slitType = new ACClearableRadioButtonGroup();

      slitType.setBindPath("SLIT_TYPE");

      slitType.setUseClearButton(false);

      slitType.setModel(getSlitTypeModel());

      addSlitType();
    }
    return slitType;

  }

  /**
   * 種別選択モデルを取得します。
   * @return 種別選択モデル
   */
  protected ACListModelAdapter getSlitTypeModel(){
    if(slitTypeModel==null){
      slitTypeModel = new ACListModelAdapter();
      addSlitTypeModel();
    }
    return slitTypeModel;
  }

  /**
   * 利用票を取得します。
   * @return 利用票
   */
  public ACRadioButtonItem getUseVoteType(){
    if(useVoteType==null){

      useVoteType = new ACRadioButtonItem();

      useVoteType.setText("利用票");

      useVoteType.setGroup(getSlitType());

      addUseVoteType();
    }
    return useVoteType;

  }

  /**
   * 提供票を取得します。
   * @return 提供票
   */
  public ACRadioButtonItem getOfferVote(){
    if(offerVote==null){

      offerVote = new ACRadioButtonItem();

      offerVote.setText("提供票");

      offerVote.setGroup(getSlitType());

      addOfferVote();
    }
    return offerVote;

  }

  /**
   * 帳票種類選択フレームを取得します。
   * @return 帳票種類選択フレーム
   */
  public ACGroupBox getSlitKinds(){
    if(slitKinds==null){

      slitKinds = new ACGroupBox();

      slitKinds.setText("印刷する帳票の選択");

      addSlitKinds();
    }
    return slitKinds;

  }

  /**
   * 種類選択を取得します。
   * @return 種類選択
   */
  public ACClearableRadioButtonGroup getSlitKind(){
    if(slitKind==null){

      slitKind = new ACClearableRadioButtonGroup();

      slitKind.setBindPath("SLIT_KIND");

      slitKind.setUseClearButton(false);

      slitKind.setModel(getSlitKindModel());

      addSlitKind();
    }
    return slitKind;

  }

  /**
   * 種類選択モデルを取得します。
   * @return 種類選択モデル
   */
  protected ACListModelAdapter getSlitKindModel(){
    if(slitKindModel==null){
      slitKindModel = new ACListModelAdapter();
      addSlitKindModel();
    }
    return slitKindModel;
  }

  /**
   * 利用票・別表を取得します。
   * @return 利用票・別表
   */
  public ACRadioButtonItem getUseVoteAndAttachedTable(){
    if(useVoteAndAttachedTable==null){

      useVoteAndAttachedTable = new ACRadioButtonItem();

      useVoteAndAttachedTable.setText("本票と別表");

      useVoteAndAttachedTable.setGroup(getSlitKind());

      addUseVoteAndAttachedTable();
    }
    return useVoteAndAttachedTable;

  }

  /**
   * 利用票を取得します。
   * @return 利用票
   */
  public ACRadioButtonItem getUseVoteKind(){
    if(useVoteKind==null){

      useVoteKind = new ACRadioButtonItem();

      useVoteKind.setText("本票");

      useVoteKind.setGroup(getSlitKind());

      addUseVoteKind();
    }
    return useVoteKind;

  }

  /**
   * 別表を取得します。
   * @return 別表
   */
  public ACRadioButtonItem getAttachedTable(){
    if(attachedTable==null){

      attachedTable = new ACRadioButtonItem();

      attachedTable.setText("別表");

      attachedTable.setGroup(getSlitKind());

      addAttachedTable();
    }
    return attachedTable;

  }

  /**
   * 敬称種類選択フレームを取得します。
   * @return 敬称種類選択フレーム
   */
  public ACGroupBox getSlitKeisyos(){
    if(slitKeisyos==null){

      slitKeisyos = new ACGroupBox();

      slitKeisyos.setText("印刷する利用者の敬称");

      addSlitKeisyos();
    }
    return slitKeisyos;

  }

  /**
   * 種類選択を取得します。
   * @return 種類選択
   */
  public ACClearableRadioButtonGroup getSlitKeisyo(){
    if(slitKeisyo==null){

      slitKeisyo = new ACClearableRadioButtonGroup();

      slitKeisyo.setBindPath("SLIT_KEISYO");

      slitKeisyo.setUseClearButton(false);

      slitKeisyo.setModel(getSlitKeisyoModel());

      /** @TODO H26年度追加 */

      addSlitKeisyo();
    }
    return slitKeisyo;

  }

  /**
   * 種類選択モデルを取得します。
   * @return 種類選択モデル
   */
  protected ACListModelAdapter getSlitKeisyoModel(){
    if(slitKeisyoModel==null){
      slitKeisyoModel = new ACListModelAdapter();
      addSlitKeisyoModel();
    }
    return slitKeisyoModel;
  }

  /**
   * 様を取得します。
   * @return 様
   */
  public ACRadioButtonItem getSama(){
    if(sama==null){

      sama = new ACRadioButtonItem();

      sama.setText("様");

      sama.setGroup(getSlitKeisyo());

      addSama();
    }
    return sama;

  }

  /**
   * 殿を取得します。
   * @return 殿
   */
  public ACRadioButtonItem getDono(){
    if(dono==null){

      dono = new ACRadioButtonItem();

      dono.setText("殿");

      dono.setGroup(getSlitKeisyo());

      addDono();
    }
    return dono;

  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNashi(){
    if(nashi==null){

      nashi = new ACRadioButtonItem();

      nashi.setText("なし");

      nashi.setGroup(getSlitKeisyo());

      addNashi();
    }
    return nashi;

  }

  /**
   * パネルを取得します。
   * @return パネル
   */
  public ACPanel getPrintButtonArea(){
    if(printButtonArea==null){

      printButtonArea = new ACPanel();

      addPrintButtonArea();
    }
    return printButtonArea;

  }

  /**
   * ボタンパネルを取得します。
   * @return ボタンパネル
   */
  public ACPanel getPrintButtons(){
    if(printButtons==null){

      printButtons = new ACPanel();

      printButtons.setAutoWrap(false);

      addPrintButtons();
    }
    return printButtons;

  }

  /**
   * 印刷を取得します。
   * @return 印刷
   */
  public ACButton getPrint(){
    if(print==null){

      print = new ACButton();

      print.setText("印刷(P)");

      print.setToolTipText("画面の設定で印刷します。");

      print.setMnemonic('P');

      addPrint();
    }
    return print;

  }

  /**
   * 閉じるを取得します。
   * @return 閉じる
   */
  public ACButton getEnd(){
    if(end==null){

      end = new ACButton();

      end.setText("閉じる(C)");

      end.setToolTipText("印刷せずに画面を閉じます。");

      end.setMnemonic('C');

      addEnd();
    }
    return end;

  }

  /**
   * コンストラクタです。
   */
  public QS001003Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(900, 310);

      // ウィンドウを中央に配置
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getContents(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getUppers(), VRLayout.NORTH);

    contents.add(getMiddles(), VRLayout.NORTH);

    contents.add(getLowers(), VRLayout.NORTH);

  }

  /**
   * 上段領域に内部項目を追加します。
   */
  protected void addUppers(){

    uppers.add(getUpperLefts(), VRLayout.CLIENT);

    uppers.add(getUpperRights(), VRLayout.EAST);
  }

  /**
   * 上段領域左に内部項目を追加します。
   */
  protected void addUpperLefts(){

    upperLefts.add(getPatients(), VRLayout.NORTH);

    upperLefts.add(getPrividers(), VRLayout.NORTH);

  }

  /**
   * 利用者情報領域に内部項目を追加します。
   */
  protected void addPatients(){

    patients.add(getPatentNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getServiceYearMonthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 利用者名ラベルに内部項目を追加します。
   */
  protected void addPatentName(){

  }

  /**
   * 年月ラベルに内部項目を追加します。
   */
  protected void addServiceYearMonth(){

  }

  /**
   * 事業者情報領域に内部項目を追加します。
   */
  protected void addPrividers(){

    prividers.add(getPlanManufacturerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    prividers.add(getPersonInChargeContainer(), VRLayout.SOUTH);
    prividers.add(getSupportProviderContainer(), VRLayout.SOUTH);
  }

  /**
   * 計画作成者ラジオグループに内部項目を追加します。
   */
  protected void addPlanManufacturer(){

  }

  /**
   * 計画作成者ラジオグループモデルに内部項目を追加します。
   */
  protected void addPlanManufacturerModel(){

    getSupportProvider().setButtonIndex(1);

    getPlanManufacturerModel().add(getSupportProvider());

    getPatent().setButtonIndex(2);

    getPlanManufacturerModel().add(getPatent());

    getPreventSupportProvider().setButtonIndex(3);

    getPlanManufacturerModel().add(getPreventSupportProvider());

  }

  /**
   * 居宅介護支援事業者に内部項目を追加します。
   */
  protected void addSupportProvider(){

  }

  /**
   * 被保険者に内部項目を追加します。
   */
  protected void addPatent(){

  }

  /**
   * 介護予防支援事業所に内部項目を追加します。
   */
  protected void addPreventSupportProvider(){

  }

  /**
   * 居宅支援事業者情報コンテナに内部項目を追加します。
   */
  protected void addSupportProviderContainer(){

    supportProviderContainer.add(getSupportProviderCd(), VRLayout.FLOW_RETURN);

    supportProviderContainer.add(getSupportProviderName(), VRLayout.SOUTH);
  }

  /**
   * 事業者番号ラベルに内部項目を追加します。
   */
  protected void addSupportProviderCd(){

  }

  /**
   * 事業者名称コンボに内部項目を追加します。
   */
  protected void addSupportProviderName(){

  }

  /**
   * 事業者名称コンボモデルに内部項目を追加します。
   */
  protected void addSupportProviderNameModel(){

  }

  /**
   * 担当者コンボに内部項目を追加します。
   */
  protected void addPersonInCharge(){

  }

  /**
   * 担当者コンボモデルに内部項目を追加します。
   */
  protected void addPersonInChargeModel(){

  }

  /**
   * 上段領域右に内部項目を追加します。
   */
  protected void addUpperRights(){

    upperRights.add(getDateOfMakingOutsideFrameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    upperRights.add(getDateOfMakingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    upperRights.add(getDateOfWrittenReportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    upperRights.add(getSolid2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 作成年月日（別表）に内部項目を追加します。
   */
  protected void addDateOfMakingOutsideFrame(){

  }

  /**
   * 作成年月日に内部項目を追加します。
   */
  protected void addDateOfMaking(){

  }

  /**
   * 届出年月日に内部項目を追加します。
   */
  protected void addDateOfWrittenReport(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addSolid2(){

  }

  /**
   * 中段領域に内部項目を追加します。
   */
  protected void addMiddles(){

    middles.add(getStateOfYouKaigo(), VRLayout.FLOW);

    middles.add(getLimitAmountInformation(), VRLayout.FLOW);

    middles.add(getShortStayAndPublicExpense(), VRLayout.FLOW);

  }

  /**
   * 要介護状態区分領域に内部項目を追加します。
   */
  protected void addStateOfYouKaigo(){

    stateOfYouKaigo.add(getYouKaigodoType1(), VRLayout.FLOW_RETURN);

    stateOfYouKaigo.add(getYouKaigodoType2(), VRLayout.FLOW_RETURN);

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addYouKaigodoType1(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addYouKaigodoType2(){

  }

  /**
   * 限度額情報領域に内部項目を追加します。
   */
  protected void addLimitAmountInformation(){

    limitAmountInformation.add(getLimitAmountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    limitAmountInformation.add(getLimitAmountApplicationPeriod(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 限度額コンテナに内部項目を追加します。
   */
  protected void addLimitAmountContainer(){

    limitAmountContainer.add(getLimitAmountContent(), null);

    limitAmountContainer.add(getSolid4(), null);

  }

  /**
   * 支給限度基準額に内部項目を追加します。
   */
  protected void addLimitAmountContent(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addSolid4(){

  }

  /**
   * 限度額適用期間コンテナに内部項目を追加します。
   */
  protected void addLimitAmountApplicationPeriod(){

    limitAmountApplicationPeriod.add(getApplicationPeriodBegin(), null);

    limitAmountApplicationPeriod.add(getSolid5(), null);

    limitAmountApplicationPeriod.add(getApplicationPeriodEnd(), null);

  }

  /**
   * 適用期間開始に内部項目を追加します。
   */
  protected void addApplicationPeriodBegin(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addSolid5(){

  }

  /**
   * 適用期間終了に内部項目を追加します。
   */
  protected void addApplicationPeriodEnd(){

  }

  /**
   * 短期入所公費情報領域に内部項目を追加します。
   */
  protected void addShortStayAndPublicExpense(){

    shortStayAndPublicExpense.add(getShortStayUseDays(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayAndPublicExpense.add(getPublicExpenses(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 短期入所利用日数コンテナに内部項目を追加します。
   */
  protected void addShortStayUseDays(){

    shortStayUseDays.add(getSolid6(), null);

    shortStayUseDays.add(getShortStayUseDay(), null);

    shortStayUseDays.add(getSolid8(), null);

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addSolid6(){

  }

  /**
   * 短期入所利用日数に内部項目を追加します。
   */
  protected void addShortStayUseDay(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addSolid8(){

  }

  /**
   * 公費コンテナに内部項目を追加します。
   */
  protected void addPublicExpenses(){

    publicExpenses.add(getPublicExpense(), null);

  }

  /**
   * 公費チェックに内部項目を追加します。
   */
  protected void addPublicExpense(){

  }

  /**
   * 下段領域に内部項目を追加します。
   */
  protected void addLowers(){

    lowers.add(getSlitTypes(), VRLayout.WEST);

    lowers.add(getSlitKinds(), VRLayout.WEST);

    lowers.add(getSlitKeisyos(), VRLayout.WEST);

    lowers.add(getPrintButtonArea(), VRLayout.CLIENT);

  }

  /**
   * 帳票種別選択フレームに内部項目を追加します。
   */
  protected void addSlitTypes(){

    slitTypes.add(getSlitType(), null);

  }

  /**
   * 種別選択に内部項目を追加します。
   */
  protected void addSlitType(){

  }

  /**
   * 種別選択モデルに内部項目を追加します。
   */
  protected void addSlitTypeModel(){

    getUseVoteType().setButtonIndex(1);

    getSlitTypeModel().add(getUseVoteType());

    getOfferVote().setButtonIndex(2);

    getSlitTypeModel().add(getOfferVote());

  }

  /**
   * 利用票に内部項目を追加します。
   */
  protected void addUseVoteType(){

  }

  /**
   * 提供票に内部項目を追加します。
   */
  protected void addOfferVote(){

  }

  /**
   * 帳票種類選択フレームに内部項目を追加します。
   */
  protected void addSlitKinds(){

    slitKinds.add(getSlitKind(), null);

  }

  /**
   * 種類選択に内部項目を追加します。
   */
  protected void addSlitKind(){

  }

  /**
   * 種類選択モデルに内部項目を追加します。
   */
  protected void addSlitKindModel(){

    getUseVoteAndAttachedTable().setButtonIndex(1);

    getSlitKindModel().add(getUseVoteAndAttachedTable());

    getUseVoteKind().setButtonIndex(2);

    getSlitKindModel().add(getUseVoteKind());

    getAttachedTable().setButtonIndex(3);

    getSlitKindModel().add(getAttachedTable());

  }

  /**
   * 利用票・別表に内部項目を追加します。
   */
  protected void addUseVoteAndAttachedTable(){

  }

  /**
   * 利用票に内部項目を追加します。
   */
  protected void addUseVoteKind(){

  }

  /**
   * 別表に内部項目を追加します。
   */
  protected void addAttachedTable(){

  }

  /**
   * 敬称種類選択フレームに内部項目を追加します。
   */
  protected void addSlitKeisyos(){

    slitKeisyos.add(getSlitKeisyo(), null);

  }

  /**
   * 種類選択に内部項目を追加します。
   */
  protected void addSlitKeisyo(){

  }

  /**
   * 種類選択モデルに内部項目を追加します。
   */
  protected void addSlitKeisyoModel(){

    getSama().setButtonIndex(1);

    getSlitKeisyoModel().add(getSama());

    getDono().setButtonIndex(2);

    getSlitKeisyoModel().add(getDono());

    getNashi().setButtonIndex(3);

    getSlitKeisyoModel().add(getNashi());

  }

  /**
   * 様に内部項目を追加します。
   */
  protected void addSama(){

  }

  /**
   * 殿に内部項目を追加します。
   */
  protected void addDono(){

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNashi(){

  }

  /**
   * パネルに内部項目を追加します。
   */
  protected void addPrintButtonArea(){

    printButtonArea.add(getPrintButtons(), VRLayout.SOUTH);
  }

  /**
   * ボタンパネルに内部項目を追加します。
   */
  protected void addPrintButtons(){

    printButtons.add(getEnd(), VRLayout.EAST);
    printButtons.add(getPrint(), VRLayout.EAST);
  }

  /**
   * 印刷に内部項目を追加します。
   */
  protected void addPrint(){

  }

  /**
   * 閉じるに内部項目を追加します。
   */
  protected void addEnd(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QS001003Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001003Design getThis() {
    return this;
  }
}
