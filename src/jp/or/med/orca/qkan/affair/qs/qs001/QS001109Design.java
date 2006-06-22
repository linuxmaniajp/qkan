
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
 * プログラム サービスパターン短期入所生活介護 (QS001109)
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
 * サービスパターン短期入所生活介護画面項目デザイン(QS001109) 
 */
public class QS001109Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup shortStayLifeTimeContenaFacilityDivision;

  private ACLabelContainer shortStayLifeTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter shortStayLifeTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem shortStayLifeSingle;

  private ACRadioButtonItem shortStayLifeDouble;

  private ACRadioButtonItem shortStayLifeSingleUnit;

  private ACRadioButtonItem shortStayLifeDoubleUnit;

  private ACLabelContainer shortStayLifeHospitalRoomDivisionContena;

  private ACClearableRadioButtonGroup shortStayLifeHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup nightWorkConditionRadio;

  private ACLabelContainer nightWorkConditionRadioContainer;

  private ACListModelAdapter nightWorkConditionRadioModel;

  private ACRadioButtonItem nightWorkConditionRadioItem1;

  private ACRadioButtonItem nightWorkConditionRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeAdditionFunctionTrainingRadio;

  private ACLabelContainer shortStayLifeAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter shortStayLifeAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem2;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem1;

  private ACClearableRadioButtonGroup shortStayLifeMeetingAndSendingOff;

  private ACLabelContainer shortStayLifeMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayLifeMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayLifeDieticianManageRadio;

  private ACLabelContainer shortStayLifeDieticianManageRadioContainer;

  private ACListModelAdapter shortStayLifeDieticianManageRadioModel;

  private ACRadioButtonItem shortStayLifeDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayLifeDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayLifeDieticianManageRadioItem3;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup shortStayLifeMedicalExpensesRadio;

  private ACLabelContainer shortStayLifeMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayLifeMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeSubtraction;

  private ACLabelContainer shortStayLifeSubtractionContainer;

  private ACListModelAdapter shortStayLifeSubtractionModel;

  private ACRadioButtonItem shortStayLifeSubtractionNot;

  private ACRadioButtonItem shortStayLifeSubtractionExcess;

  private ACRadioButtonItem shortStayLifeSubtractionLack;

  private ACBackLabelContainer shortStayLifeDinnerContainer;

  private ACComboBox shortStayLifeDinnerOffer;

  private ACLabelContainer shortStayLifeDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayLifeDinnerOfferModel;

  private ACTextField shortStayLifeDinnerCost;

  private ACLabelContainer shortStayLifeDinnerCostContainer;

  private ACIntegerCheckBox shortStayLifeAddition30Orver;

  private ACClearableRadioButtonGroup shortStayLifeUnitCareAddRadio;

  private ACLabelContainer shortStayLifeUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayLifeUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeEmergencyShortNetworkAddRadio;

  private ACLabelContainer shortStayLifeEmergencyShortNetworkAddRadioContainer;

  private ACListModelAdapter shortStayLifeEmergencyShortNetworkAddRadioModel;

  private ACRadioButtonItem shortStayLifeEmergencyShortNetworkAddRadioItem1;

  private ACRadioButtonItem shortStayLifeEmergencyShortNetworkAddRadioItem2;

  private ACGroupBox shortStayLifeStayheavyAddGroup;

  private ACClearableRadioButtonGroup shortStayLifeNightNursingSystemAddRadio;

  private ACLabelContainer shortStayLifeNightNursingSystemAddRadioContainer;

  private ACListModelAdapter shortStayLifeNightNursingSystemAddRadioModel;

  private ACRadioButtonItem shortStayLifeNightNursingSystemAddRadioItem1;

  private ACRadioButtonItem shortStayLifeNightNursingSystemAddRadioItem2;

  private ACClearableRadioButtonGroup shortStayLifeStayheavyAddRadio;

  private ACLabelContainer shortStayLifeStayheavyAddRadioContainer;

  private ACListModelAdapter shortStayLifeStayheavyAddRadioModel;

  private ACRadioButtonItem shortStayLifeStayheavyAddRadioItem1;

  private ACRadioButtonItem shortStayLifeStayheavyAddRadioItem2;

  //getter

  /**
   * タブペインを取得します。
   * @return タブペイン
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * タブ1を取得します。
   * @return タブ1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACClearableRadioButtonGroup getShortStayLifeTimeContenaFacilityDivision(){
    if(shortStayLifeTimeContenaFacilityDivision==null){

      shortStayLifeTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      getShortStayLifeTimeContenaFacilityDivisionContainer().setText("施設等の区分");

      shortStayLifeTimeContenaFacilityDivision.setBindPath("1210101");

      shortStayLifeTimeContenaFacilityDivision.setModel(getShortStayLifeTimeContenaFacilityDivisionModel());

      shortStayLifeTimeContenaFacilityDivision.setUseClearButton(false);

      addShortStayLifeTimeContenaFacilityDivision();
    }
    return shortStayLifeTimeContenaFacilityDivision;

  }

  /**
   * 施設等の区分コンテナを取得します。
   * @return 施設等の区分コンテナ
   */
  protected ACLabelContainer getShortStayLifeTimeContenaFacilityDivisionContainer(){
    if(shortStayLifeTimeContenaFacilityDivisionContainer==null){
      shortStayLifeTimeContenaFacilityDivisionContainer = new ACLabelContainer();
      shortStayLifeTimeContenaFacilityDivisionContainer.setFollowChildEnabled(true);
      shortStayLifeTimeContenaFacilityDivisionContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeTimeContenaFacilityDivisionContainer.add(getShortStayLifeTimeContenaFacilityDivision(), null);
    }
    return shortStayLifeTimeContenaFacilityDivisionContainer;
  }

  /**
   * 施設等の区分モデルを取得します。
   * @return 施設等の区分モデル
   */
  protected ACListModelAdapter getShortStayLifeTimeContenaFacilityDivisionModel(){
    if(shortStayLifeTimeContenaFacilityDivisionModel==null){
      shortStayLifeTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addShortStayLifeTimeContenaFacilityDivisionModel();
    }
    return shortStayLifeTimeContenaFacilityDivisionModel;
  }

  /**
   * 単独型を取得します。
   * @return 単独型
   */
  public ACRadioButtonItem getShortStayLifeSingle(){
    if(shortStayLifeSingle==null){

      shortStayLifeSingle = new ACRadioButtonItem();

      shortStayLifeSingle.setText("単独型");

      shortStayLifeSingle.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeSingle.setConstraints(VRLayout.FLOW);

      addShortStayLifeSingle();
    }
    return shortStayLifeSingle;

  }

  /**
   * 併設型を取得します。
   * @return 併設型
   */
  public ACRadioButtonItem getShortStayLifeDouble(){
    if(shortStayLifeDouble==null){

      shortStayLifeDouble = new ACRadioButtonItem();

      shortStayLifeDouble.setText("併設型");

      shortStayLifeDouble.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeDouble.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeDouble();
    }
    return shortStayLifeDouble;

  }

  /**
   * 単独型ユニット型を取得します。
   * @return 単独型ユニット型
   */
  public ACRadioButtonItem getShortStayLifeSingleUnit(){
    if(shortStayLifeSingleUnit==null){

      shortStayLifeSingleUnit = new ACRadioButtonItem();

      shortStayLifeSingleUnit.setText("単独型ユニット型");

      shortStayLifeSingleUnit.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeSingleUnit.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeSingleUnit();
    }
    return shortStayLifeSingleUnit;

  }

  /**
   * 併設型ユニット型を取得します。
   * @return 併設型ユニット型
   */
  public ACRadioButtonItem getShortStayLifeDoubleUnit(){
    if(shortStayLifeDoubleUnit==null){

      shortStayLifeDoubleUnit = new ACRadioButtonItem();

      shortStayLifeDoubleUnit.setText("併設型ユニット型");

      shortStayLifeDoubleUnit.setGroup(getShortStayLifeTimeContenaFacilityDivision());

      shortStayLifeDoubleUnit.setConstraints(VRLayout.FLOW);

      addShortStayLifeDoubleUnit();
    }
    return shortStayLifeDoubleUnit;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  public ACLabelContainer getShortStayLifeHospitalRoomDivisionContena(){
    if(shortStayLifeHospitalRoomDivisionContena==null){

      shortStayLifeHospitalRoomDivisionContena = new ACLabelContainer();

      shortStayLifeHospitalRoomDivisionContena.setText("病室区分");

      addShortStayLifeHospitalRoomDivisionContena();
    }
    return shortStayLifeHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（通常）を取得します。
   * @return 病室区分（通常）
   */
  public ACClearableRadioButtonGroup getShortStayLifeHospitalRoomDivisionRadio(){
    if(shortStayLifeHospitalRoomDivisionRadio==null){

      shortStayLifeHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayLifeHospitalRoomDivisionRadio.setBindPath("1210103");

      shortStayLifeHospitalRoomDivisionRadio.setModel(getShortStayLifeHospitalRoomDivisionRadioModel());

      shortStayLifeHospitalRoomDivisionRadio.setUseClearButton(false);

      addShortStayLifeHospitalRoomDivisionRadio();
    }
    return shortStayLifeHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（通常）モデルを取得します。
   * @return 病室区分（通常）モデル
   */
  protected ACListModelAdapter getShortStayLifeHospitalRoomDivisionRadioModel(){
    if(shortStayLifeHospitalRoomDivisionRadioModel==null){
      shortStayLifeHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayLifeHospitalRoomDivisionRadioModel();
    }
    return shortStayLifeHospitalRoomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayLifeHospitalRoomDivisionRadioItem1(){
    if(shortStayLifeHospitalRoomDivisionRadioItem1==null){

      shortStayLifeHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayLifeHospitalRoomDivisionRadioItem1.setText("従来型個室");

      shortStayLifeHospitalRoomDivisionRadioItem1.setGroup(getShortStayLifeHospitalRoomDivisionRadio());

      shortStayLifeHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeHospitalRoomDivisionRadioItem1();
    }
    return shortStayLifeHospitalRoomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayLifeHospitalRoomDivisionRadioItem2(){
    if(shortStayLifeHospitalRoomDivisionRadioItem2==null){

      shortStayLifeHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayLifeHospitalRoomDivisionRadioItem2.setText("多床室");

      shortStayLifeHospitalRoomDivisionRadioItem2.setGroup(getShortStayLifeHospitalRoomDivisionRadio());

      shortStayLifeHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeHospitalRoomDivisionRadioItem2();
    }
    return shortStayLifeHospitalRoomDivisionRadioItem2;

  }

  /**
   * 病室区分（ユニット）を取得します。
   * @return 病室区分（ユニット）
   */
  public ACClearableRadioButtonGroup getShortStayLifeUnitHospitalRoomDivisionRadio(){
    if(shortStayLifeUnitHospitalRoomDivisionRadio==null){

      shortStayLifeUnitHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      shortStayLifeUnitHospitalRoomDivisionRadio.setBindPath("1210104");

      shortStayLifeUnitHospitalRoomDivisionRadio.setModel(getShortStayLifeUnitHospitalRoomDivisionRadioModel());

      shortStayLifeUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      addShortStayLifeUnitHospitalRoomDivisionRadio();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分（ユニット）モデルを取得します。
   * @return 病室区分（ユニット）モデル
   */
  protected ACListModelAdapter getShortStayLifeUnitHospitalRoomDivisionRadioModel(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioModel==null){
      shortStayLifeUnitHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayLifeUnitHospitalRoomDivisionRadioModel();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioModel;
  }

  /**
   * ユニット型個室を取得します。
   * @return ユニット型個室
   */
  public ACRadioButtonItem getShortStayLifeUnitHospitalRoomDivisionRadioItem1(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioItem1==null){

      shortStayLifeUnitHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setText("ユニット型個室");

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setGroup(getShortStayLifeUnitHospitalRoomDivisionRadio());

      shortStayLifeUnitHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeUnitHospitalRoomDivisionRadioItem1();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioItem1;

  }

  /**
   * ユニット型準個室を取得します。
   * @return ユニット型準個室
   */
  public ACRadioButtonItem getShortStayLifeUnitHospitalRoomDivisionRadioItem2(){
    if(shortStayLifeUnitHospitalRoomDivisionRadioItem2==null){

      shortStayLifeUnitHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setText("ユニット型準個室");

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setGroup(getShortStayLifeUnitHospitalRoomDivisionRadio());

      shortStayLifeUnitHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitHospitalRoomDivisionRadioItem2();
    }
    return shortStayLifeUnitHospitalRoomDivisionRadioItem2;

  }

  /**
   * 夜間勤務条件基準を取得します。
   * @return 夜間勤務条件基準
   */
  public ACClearableRadioButtonGroup getNightWorkConditionRadio(){
    if(nightWorkConditionRadio==null){

      nightWorkConditionRadio = new ACClearableRadioButtonGroup();

      getNightWorkConditionRadioContainer().setText("夜間勤務条件基準");

      nightWorkConditionRadio.setBindPath("1210105");

      nightWorkConditionRadio.setModel(getNightWorkConditionRadioModel());

      nightWorkConditionRadio.setUseClearButton(false);

      addNightWorkConditionRadio();
    }
    return nightWorkConditionRadio;

  }

  /**
   * 夜間勤務条件基準コンテナを取得します。
   * @return 夜間勤務条件基準コンテナ
   */
  protected ACLabelContainer getNightWorkConditionRadioContainer(){
    if(nightWorkConditionRadioContainer==null){
      nightWorkConditionRadioContainer = new ACLabelContainer();
      nightWorkConditionRadioContainer.setFollowChildEnabled(true);
      nightWorkConditionRadioContainer.setVAlignment(VRLayout.CENTER);
      nightWorkConditionRadioContainer.add(getNightWorkConditionRadio(), null);
    }
    return nightWorkConditionRadioContainer;
  }

  /**
   * 夜間勤務条件基準モデルを取得します。
   * @return 夜間勤務条件基準モデル
   */
  protected ACListModelAdapter getNightWorkConditionRadioModel(){
    if(nightWorkConditionRadioModel==null){
      nightWorkConditionRadioModel = new ACListModelAdapter();
      addNightWorkConditionRadioModel();
    }
    return nightWorkConditionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getNightWorkConditionRadioItem1(){
    if(nightWorkConditionRadioItem1==null){

      nightWorkConditionRadioItem1 = new ACRadioButtonItem();

      nightWorkConditionRadioItem1.setText("基準型");

      nightWorkConditionRadioItem1.setGroup(getNightWorkConditionRadio());

      nightWorkConditionRadioItem1.setConstraints(VRLayout.FLOW);

      addNightWorkConditionRadioItem1();
    }
    return nightWorkConditionRadioItem1;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getNightWorkConditionRadioItem2(){
    if(nightWorkConditionRadioItem2==null){

      nightWorkConditionRadioItem2 = new ACRadioButtonItem();

      nightWorkConditionRadioItem2.setText("減算型");

      nightWorkConditionRadioItem2.setGroup(getNightWorkConditionRadio());

      nightWorkConditionRadioItem2.setConstraints(VRLayout.FLOW);

      addNightWorkConditionRadioItem2();
    }
    return nightWorkConditionRadioItem2;

  }

  /**
   * 機能訓練指導体制加算を取得します。
   * @return 機能訓練指導体制加算
   */
  public ACClearableRadioButtonGroup getShortStayLifeAdditionFunctionTrainingRadio(){
    if(shortStayLifeAdditionFunctionTrainingRadio==null){

      shortStayLifeAdditionFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeAdditionFunctionTrainingRadioContainer().setText("機能訓練指導加算");

      shortStayLifeAdditionFunctionTrainingRadio.setBindPath("1210106");

      shortStayLifeAdditionFunctionTrainingRadio.setModel(getShortStayLifeAdditionFunctionTrainingRadioModel());

      shortStayLifeAdditionFunctionTrainingRadio.setUseClearButton(false);

      addShortStayLifeAdditionFunctionTrainingRadio();
    }
    return shortStayLifeAdditionFunctionTrainingRadio;

  }

  /**
   * 機能訓練指導体制加算コンテナを取得します。
   * @return 機能訓練指導体制加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeAdditionFunctionTrainingRadioContainer(){
    if(shortStayLifeAdditionFunctionTrainingRadioContainer==null){
      shortStayLifeAdditionFunctionTrainingRadioContainer = new ACLabelContainer();
      shortStayLifeAdditionFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      shortStayLifeAdditionFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeAdditionFunctionTrainingRadioContainer.add(getShortStayLifeAdditionFunctionTrainingRadio(), null);
    }
    return shortStayLifeAdditionFunctionTrainingRadioContainer;
  }

  /**
   * 機能訓練指導体制加算モデルを取得します。
   * @return 機能訓練指導体制加算モデル
   */
  protected ACListModelAdapter getShortStayLifeAdditionFunctionTrainingRadioModel(){
    if(shortStayLifeAdditionFunctionTrainingRadioModel==null){
      shortStayLifeAdditionFunctionTrainingRadioModel = new ACListModelAdapter();
      addShortStayLifeAdditionFunctionTrainingRadioModel();
    }
    return shortStayLifeAdditionFunctionTrainingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeAdditionFunctionTrainingRadioItem2(){
    if(shortStayLifeAdditionFunctionTrainingRadioItem2==null){

      shortStayLifeAdditionFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      shortStayLifeAdditionFunctionTrainingRadioItem2.setText("なし");

      shortStayLifeAdditionFunctionTrainingRadioItem2.setGroup(getShortStayLifeAdditionFunctionTrainingRadio());

      shortStayLifeAdditionFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeAdditionFunctionTrainingRadioItem2();
    }
    return shortStayLifeAdditionFunctionTrainingRadioItem2;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeAdditionFunctionTrainingRadioItem1(){
    if(shortStayLifeAdditionFunctionTrainingRadioItem1==null){

      shortStayLifeAdditionFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      shortStayLifeAdditionFunctionTrainingRadioItem1.setText("あり");

      shortStayLifeAdditionFunctionTrainingRadioItem1.setGroup(getShortStayLifeAdditionFunctionTrainingRadio());

      shortStayLifeAdditionFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeAdditionFunctionTrainingRadioItem1();
    }
    return shortStayLifeAdditionFunctionTrainingRadioItem1;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACClearableRadioButtonGroup getShortStayLifeMeetingAndSendingOff(){
    if(shortStayLifeMeetingAndSendingOff==null){

      shortStayLifeMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayLifeMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayLifeMeetingAndSendingOff.setBindPath("6");

      shortStayLifeMeetingAndSendingOff.setModel(getShortStayLifeMeetingAndSendingOffModel());

      shortStayLifeMeetingAndSendingOff.setUseClearButton(false);

      addShortStayLifeMeetingAndSendingOff();
    }
    return shortStayLifeMeetingAndSendingOff;

  }

  /**
   * 送迎区分コンテナを取得します。
   * @return 送迎区分コンテナ
   */
  protected ACLabelContainer getShortStayLifeMeetingAndSendingOffContainer(){
    if(shortStayLifeMeetingAndSendingOffContainer==null){
      shortStayLifeMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayLifeMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayLifeMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeMeetingAndSendingOffContainer.add(getShortStayLifeMeetingAndSendingOff(), null);
    }
    return shortStayLifeMeetingAndSendingOffContainer;
  }

  /**
   * 送迎区分モデルを取得します。
   * @return 送迎区分モデル
   */
  protected ACListModelAdapter getShortStayLifeMeetingAndSendingOffModel(){
    if(shortStayLifeMeetingAndSendingOffModel==null){
      shortStayLifeMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayLifeMeetingAndSendingOffModel();
    }
    return shortStayLifeMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffNone(){
    if(shortStayLifeMeetingAndSendingOffNone==null){

      shortStayLifeMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffNone.setText("送迎なし");

      shortStayLifeMeetingAndSendingOffNone.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffNone();
    }
    return shortStayLifeMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffOneWay(){
    if(shortStayLifeMeetingAndSendingOffOneWay==null){

      shortStayLifeMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayLifeMeetingAndSendingOffOneWay.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffOneWay();
    }
    return shortStayLifeMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayLifeMeetingAndSendingOffRoundTrip(){
    if(shortStayLifeMeetingAndSendingOffRoundTrip==null){

      shortStayLifeMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayLifeMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayLifeMeetingAndSendingOffRoundTrip.setGroup(getShortStayLifeMeetingAndSendingOff());

      shortStayLifeMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayLifeMeetingAndSendingOffRoundTrip();
    }
    return shortStayLifeMeetingAndSendingOffRoundTrip;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getShortStayLifeDieticianManageRadio(){
    if(shortStayLifeDieticianManageRadio==null){

      shortStayLifeDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeDieticianManageRadioContainer().setText("栄養管理体制加算");

      shortStayLifeDieticianManageRadio.setBindPath("1210108");

      shortStayLifeDieticianManageRadio.setModel(getShortStayLifeDieticianManageRadioModel());

      shortStayLifeDieticianManageRadio.setUseClearButton(false);

      addShortStayLifeDieticianManageRadio();
    }
    return shortStayLifeDieticianManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeDieticianManageRadioContainer(){
    if(shortStayLifeDieticianManageRadioContainer==null){
      shortStayLifeDieticianManageRadioContainer = new ACLabelContainer();
      shortStayLifeDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayLifeDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDieticianManageRadioContainer.add(getShortStayLifeDieticianManageRadio(), null);
    }
    return shortStayLifeDieticianManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getShortStayLifeDieticianManageRadioModel(){
    if(shortStayLifeDieticianManageRadioModel==null){
      shortStayLifeDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayLifeDieticianManageRadioModel();
    }
    return shortStayLifeDieticianManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeDieticianManageRadioItem1(){
    if(shortStayLifeDieticianManageRadioItem1==null){

      shortStayLifeDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayLifeDieticianManageRadioItem1.setText("なし");

      shortStayLifeDieticianManageRadioItem1.setGroup(getShortStayLifeDieticianManageRadio());

      shortStayLifeDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeDieticianManageRadioItem1();
    }
    return shortStayLifeDieticianManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getShortStayLifeDieticianManageRadioItem2(){
    if(shortStayLifeDieticianManageRadioItem2==null){

      shortStayLifeDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayLifeDieticianManageRadioItem2.setText("管理栄養士");

      shortStayLifeDieticianManageRadioItem2.setGroup(getShortStayLifeDieticianManageRadio());

      shortStayLifeDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeDieticianManageRadioItem2();
    }
    return shortStayLifeDieticianManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getShortStayLifeDieticianManageRadioItem3(){
    if(shortStayLifeDieticianManageRadioItem3==null){

      shortStayLifeDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayLifeDieticianManageRadioItem3.setText("栄養士");

      shortStayLifeDieticianManageRadioItem3.setGroup(getShortStayLifeDieticianManageRadio());

      shortStayLifeDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayLifeDieticianManageRadioItem3();
    }
    return shortStayLifeDieticianManageRadioItem3;

  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getShortStayLifeMedicalExpensesRadio(){
    if(shortStayLifeMedicalExpensesRadio==null){

      shortStayLifeMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayLifeMedicalExpensesRadio.setBindPath("1210109");

      shortStayLifeMedicalExpensesRadio.setModel(getShortStayLifeMedicalExpensesRadioModel());

      shortStayLifeMedicalExpensesRadio.setUseClearButton(false);

      addShortStayLifeMedicalExpensesRadio();
    }
    return shortStayLifeMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeMedicalExpensesRadioContainer(){
    if(shortStayLifeMedicalExpensesRadioContainer==null){
      shortStayLifeMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayLifeMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayLifeMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeMedicalExpensesRadioContainer.add(getShortStayLifeMedicalExpensesRadio(), null);
    }
    return shortStayLifeMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayLifeMedicalExpensesRadioModel(){
    if(shortStayLifeMedicalExpensesRadioModel==null){
      shortStayLifeMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayLifeMedicalExpensesRadioModel();
    }
    return shortStayLifeMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem1(){
    if(shortStayLifeMedicalExpensesRadioItem1==null){

      shortStayLifeMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem1.setText("なし");

      shortStayLifeMedicalExpensesRadioItem1.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem1();
    }
    return shortStayLifeMedicalExpensesRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeMedicalExpensesRadioItem2(){
    if(shortStayLifeMedicalExpensesRadioItem2==null){

      shortStayLifeMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayLifeMedicalExpensesRadioItem2.setText("あり");

      shortStayLifeMedicalExpensesRadioItem2.setGroup(getShortStayLifeMedicalExpensesRadio());

      shortStayLifeMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeMedicalExpensesRadioItem2();
    }
    return shortStayLifeMedicalExpensesRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getShortStayLifeSubtraction(){
    if(shortStayLifeSubtraction==null){

      shortStayLifeSubtraction = new ACClearableRadioButtonGroup();

      getShortStayLifeSubtractionContainer().setText("人員減算");

      shortStayLifeSubtraction.setBindPath("1210110");

      shortStayLifeSubtraction.setModel(getShortStayLifeSubtractionModel());

      shortStayLifeSubtraction.setUseClearButton(false);

      addShortStayLifeSubtraction();
    }
    return shortStayLifeSubtraction;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayLifeSubtractionContainer(){
    if(shortStayLifeSubtractionContainer==null){
      shortStayLifeSubtractionContainer = new ACLabelContainer();
      shortStayLifeSubtractionContainer.setFollowChildEnabled(true);
      shortStayLifeSubtractionContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeSubtractionContainer.add(getShortStayLifeSubtraction(), null);
    }
    return shortStayLifeSubtractionContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayLifeSubtractionModel(){
    if(shortStayLifeSubtractionModel==null){
      shortStayLifeSubtractionModel = new ACListModelAdapter();
      addShortStayLifeSubtractionModel();
    }
    return shortStayLifeSubtractionModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeSubtractionNot(){
    if(shortStayLifeSubtractionNot==null){

      shortStayLifeSubtractionNot = new ACRadioButtonItem();

      shortStayLifeSubtractionNot.setText("なし");

      shortStayLifeSubtractionNot.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionNot.setConstraints(VRLayout.FLOW);

      addShortStayLifeSubtractionNot();
    }
    return shortStayLifeSubtractionNot;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayLifeSubtractionExcess(){
    if(shortStayLifeSubtractionExcess==null){

      shortStayLifeSubtractionExcess = new ACRadioButtonItem();

      shortStayLifeSubtractionExcess.setText("定員超過");

      shortStayLifeSubtractionExcess.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayLifeSubtractionExcess();
    }
    return shortStayLifeSubtractionExcess;

  }

  /**
   * 看護・介護職員の不足を取得します。
   * @return 看護・介護職員の不足
   */
  public ACRadioButtonItem getShortStayLifeSubtractionLack(){
    if(shortStayLifeSubtractionLack==null){

      shortStayLifeSubtractionLack = new ACRadioButtonItem();

      shortStayLifeSubtractionLack.setText("看護・介護職員の不足");

      shortStayLifeSubtractionLack.setGroup(getShortStayLifeSubtraction());

      shortStayLifeSubtractionLack.setConstraints(VRLayout.FLOW);

      addShortStayLifeSubtractionLack();
    }
    return shortStayLifeSubtractionLack;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getShortStayLifeDinnerContainer(){
    if(shortStayLifeDinnerContainer==null){

      shortStayLifeDinnerContainer = new ACBackLabelContainer();

      addShortStayLifeDinnerContainer();
    }
    return shortStayLifeDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayLifeDinnerOffer(){
    if(shortStayLifeDinnerOffer==null){

      shortStayLifeDinnerOffer = new ACComboBox();

      getShortStayLifeDinnerOfferContainer().setText("食事提供");

      shortStayLifeDinnerOffer.setBindPath("1210111");

      shortStayLifeDinnerOffer.setEditable(false);

      shortStayLifeDinnerOffer.setModelBindPath("1210111");

      shortStayLifeDinnerOffer.setModel(getShortStayLifeDinnerOfferModel());

      shortStayLifeDinnerOffer.setRenderBindPath("CONTENT");

      addShortStayLifeDinnerOffer();
    }
    return shortStayLifeDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayLifeDinnerOfferContainer(){
    if(shortStayLifeDinnerOfferContainer==null){
      shortStayLifeDinnerOfferContainer = new ACLabelContainer();
      shortStayLifeDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayLifeDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDinnerOfferContainer.add(getShortStayLifeDinnerOffer(), null);
    }
    return shortStayLifeDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayLifeDinnerOfferModel(){
    if(shortStayLifeDinnerOfferModel==null){
      shortStayLifeDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayLifeDinnerOfferModel();
    }
    return shortStayLifeDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayLifeDinnerCost(){
    if(shortStayLifeDinnerCost==null){

      shortStayLifeDinnerCost = new ACTextField();

      getShortStayLifeDinnerCostContainer().setText("食事費用");

      shortStayLifeDinnerCost.setBindPath("1210114");

      shortStayLifeDinnerCost.setColumns(4);

      shortStayLifeDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayLifeDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayLifeDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayLifeDinnerCost.setMaxLength(5);

      addShortStayLifeDinnerCost();
    }
    return shortStayLifeDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayLifeDinnerCostContainer(){
    if(shortStayLifeDinnerCostContainer==null){
      shortStayLifeDinnerCostContainer = new ACLabelContainer();
      shortStayLifeDinnerCostContainer.setFollowChildEnabled(true);
      shortStayLifeDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeDinnerCostContainer.add(getShortStayLifeDinnerCost(), null);
    }
    return shortStayLifeDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayLifeAddition30Orver(){
    if(shortStayLifeAddition30Orver==null){

      shortStayLifeAddition30Orver = new ACIntegerCheckBox();

      shortStayLifeAddition30Orver.setText("30日超");

      shortStayLifeAddition30Orver.setBindPath("5");

      shortStayLifeAddition30Orver.setSelectValue(2);

      shortStayLifeAddition30Orver.setUnSelectValue(1);

      addShortStayLifeAddition30Orver();
    }
    return shortStayLifeAddition30Orver;

  }

  /**
   * ユニットケアの整備を取得します。
   * @return ユニットケアの整備
   */
  public ACClearableRadioButtonGroup getShortStayLifeUnitCareAddRadio(){
    if(shortStayLifeUnitCareAddRadio==null){

      shortStayLifeUnitCareAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeUnitCareAddRadioContainer().setText("ユニットケアの整備");

      shortStayLifeUnitCareAddRadio.setBindPath("1210115");

      shortStayLifeUnitCareAddRadio.setModel(getShortStayLifeUnitCareAddRadioModel());

      shortStayLifeUnitCareAddRadio.setUseClearButton(false);

      addShortStayLifeUnitCareAddRadio();
    }
    return shortStayLifeUnitCareAddRadio;

  }

  /**
   * ユニットケアの整備コンテナを取得します。
   * @return ユニットケアの整備コンテナ
   */
  protected ACLabelContainer getShortStayLifeUnitCareAddRadioContainer(){
    if(shortStayLifeUnitCareAddRadioContainer==null){
      shortStayLifeUnitCareAddRadioContainer = new ACLabelContainer();
      shortStayLifeUnitCareAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeUnitCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeUnitCareAddRadioContainer.add(getShortStayLifeUnitCareAddRadio(), null);
    }
    return shortStayLifeUnitCareAddRadioContainer;
  }

  /**
   * ユニットケアの整備モデルを取得します。
   * @return ユニットケアの整備モデル
   */
  protected ACListModelAdapter getShortStayLifeUnitCareAddRadioModel(){
    if(shortStayLifeUnitCareAddRadioModel==null){
      shortStayLifeUnitCareAddRadioModel = new ACListModelAdapter();
      addShortStayLifeUnitCareAddRadioModel();
    }
    return shortStayLifeUnitCareAddRadioModel;
  }

  /**
   * 未整備を取得します。
   * @return 未整備
   */
  public ACRadioButtonItem getShortStayLifeUnitCareAddRadioItem1(){
    if(shortStayLifeUnitCareAddRadioItem1==null){

      shortStayLifeUnitCareAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeUnitCareAddRadioItem1.setText("未整備");

      shortStayLifeUnitCareAddRadioItem1.setGroup(getShortStayLifeUnitCareAddRadio());

      shortStayLifeUnitCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitCareAddRadioItem1();
    }
    return shortStayLifeUnitCareAddRadioItem1;

  }

  /**
   * 整備を取得します。
   * @return 整備
   */
  public ACRadioButtonItem getShortStayLifeUnitCareAddRadioItem2(){
    if(shortStayLifeUnitCareAddRadioItem2==null){

      shortStayLifeUnitCareAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeUnitCareAddRadioItem2.setText("整備");

      shortStayLifeUnitCareAddRadioItem2.setGroup(getShortStayLifeUnitCareAddRadio());

      shortStayLifeUnitCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeUnitCareAddRadioItem2();
    }
    return shortStayLifeUnitCareAddRadioItem2;

  }

  /**
   * 緊急短期入所ネットワーク加算を取得します。
   * @return 緊急短期入所ネットワーク加算
   */
  public ACClearableRadioButtonGroup getShortStayLifeEmergencyShortNetworkAddRadio(){
    if(shortStayLifeEmergencyShortNetworkAddRadio==null){

      shortStayLifeEmergencyShortNetworkAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeEmergencyShortNetworkAddRadioContainer().setText("緊急短期入所ネットワーク加算");

      shortStayLifeEmergencyShortNetworkAddRadio.setBindPath("1210116");

      shortStayLifeEmergencyShortNetworkAddRadio.setModel(getShortStayLifeEmergencyShortNetworkAddRadioModel());

      shortStayLifeEmergencyShortNetworkAddRadio.setUseClearButton(false);

      addShortStayLifeEmergencyShortNetworkAddRadio();
    }
    return shortStayLifeEmergencyShortNetworkAddRadio;

  }

  /**
   * 緊急短期入所ネットワーク加算コンテナを取得します。
   * @return 緊急短期入所ネットワーク加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeEmergencyShortNetworkAddRadioContainer(){
    if(shortStayLifeEmergencyShortNetworkAddRadioContainer==null){
      shortStayLifeEmergencyShortNetworkAddRadioContainer = new ACLabelContainer();
      shortStayLifeEmergencyShortNetworkAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeEmergencyShortNetworkAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeEmergencyShortNetworkAddRadioContainer.add(getShortStayLifeEmergencyShortNetworkAddRadio(), null);
    }
    return shortStayLifeEmergencyShortNetworkAddRadioContainer;
  }

  /**
   * 緊急短期入所ネットワーク加算モデルを取得します。
   * @return 緊急短期入所ネットワーク加算モデル
   */
  protected ACListModelAdapter getShortStayLifeEmergencyShortNetworkAddRadioModel(){
    if(shortStayLifeEmergencyShortNetworkAddRadioModel==null){
      shortStayLifeEmergencyShortNetworkAddRadioModel = new ACListModelAdapter();
      addShortStayLifeEmergencyShortNetworkAddRadioModel();
    }
    return shortStayLifeEmergencyShortNetworkAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeEmergencyShortNetworkAddRadioItem1(){
    if(shortStayLifeEmergencyShortNetworkAddRadioItem1==null){

      shortStayLifeEmergencyShortNetworkAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeEmergencyShortNetworkAddRadioItem1.setText("なし");

      shortStayLifeEmergencyShortNetworkAddRadioItem1.setGroup(getShortStayLifeEmergencyShortNetworkAddRadio());

      shortStayLifeEmergencyShortNetworkAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeEmergencyShortNetworkAddRadioItem1();
    }
    return shortStayLifeEmergencyShortNetworkAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeEmergencyShortNetworkAddRadioItem2(){
    if(shortStayLifeEmergencyShortNetworkAddRadioItem2==null){

      shortStayLifeEmergencyShortNetworkAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeEmergencyShortNetworkAddRadioItem2.setText("あり");

      shortStayLifeEmergencyShortNetworkAddRadioItem2.setGroup(getShortStayLifeEmergencyShortNetworkAddRadio());

      shortStayLifeEmergencyShortNetworkAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeEmergencyShortNetworkAddRadioItem2();
    }
    return shortStayLifeEmergencyShortNetworkAddRadioItem2;

  }

  /**
   * 在宅中重度加算を取得します。
   * @return 在宅中重度加算
   */
  public ACGroupBox getShortStayLifeStayheavyAddGroup(){
    if(shortStayLifeStayheavyAddGroup==null){

      shortStayLifeStayheavyAddGroup = new ACGroupBox();

      shortStayLifeStayheavyAddGroup.setText("在宅中重度加算");

      addShortStayLifeStayheavyAddGroup();
    }
    return shortStayLifeStayheavyAddGroup;

  }

  /**
   * 夜間看護体制加算を取得します。
   * @return 夜間看護体制加算
   */
  public ACClearableRadioButtonGroup getShortStayLifeNightNursingSystemAddRadio(){
    if(shortStayLifeNightNursingSystemAddRadio==null){

      shortStayLifeNightNursingSystemAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeNightNursingSystemAddRadioContainer().setText("夜間看護体制加算");

      shortStayLifeNightNursingSystemAddRadio.setBindPath("1210117");

      shortStayLifeNightNursingSystemAddRadio.setModel(getShortStayLifeNightNursingSystemAddRadioModel());

      shortStayLifeNightNursingSystemAddRadio.setUseClearButton(false);

      addShortStayLifeNightNursingSystemAddRadio();
    }
    return shortStayLifeNightNursingSystemAddRadio;

  }

  /**
   * 夜間看護体制加算コンテナを取得します。
   * @return 夜間看護体制加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeNightNursingSystemAddRadioContainer(){
    if(shortStayLifeNightNursingSystemAddRadioContainer==null){
      shortStayLifeNightNursingSystemAddRadioContainer = new ACLabelContainer();
      shortStayLifeNightNursingSystemAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeNightNursingSystemAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeNightNursingSystemAddRadioContainer.add(getShortStayLifeNightNursingSystemAddRadio(), null);
    }
    return shortStayLifeNightNursingSystemAddRadioContainer;
  }

  /**
   * 夜間看護体制加算モデルを取得します。
   * @return 夜間看護体制加算モデル
   */
  protected ACListModelAdapter getShortStayLifeNightNursingSystemAddRadioModel(){
    if(shortStayLifeNightNursingSystemAddRadioModel==null){
      shortStayLifeNightNursingSystemAddRadioModel = new ACListModelAdapter();
      addShortStayLifeNightNursingSystemAddRadioModel();
    }
    return shortStayLifeNightNursingSystemAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeNightNursingSystemAddRadioItem1(){
    if(shortStayLifeNightNursingSystemAddRadioItem1==null){

      shortStayLifeNightNursingSystemAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeNightNursingSystemAddRadioItem1.setText("なし");

      shortStayLifeNightNursingSystemAddRadioItem1.setGroup(getShortStayLifeNightNursingSystemAddRadio());

      shortStayLifeNightNursingSystemAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeNightNursingSystemAddRadioItem1();
    }
    return shortStayLifeNightNursingSystemAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeNightNursingSystemAddRadioItem2(){
    if(shortStayLifeNightNursingSystemAddRadioItem2==null){

      shortStayLifeNightNursingSystemAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeNightNursingSystemAddRadioItem2.setText("あり");

      shortStayLifeNightNursingSystemAddRadioItem2.setGroup(getShortStayLifeNightNursingSystemAddRadio());

      shortStayLifeNightNursingSystemAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeNightNursingSystemAddRadioItem2();
    }
    return shortStayLifeNightNursingSystemAddRadioItem2;

  }

  /**
   * 在宅中重度者受入加算を取得します。
   * @return 在宅中重度者受入加算
   */
  public ACClearableRadioButtonGroup getShortStayLifeStayheavyAddRadio(){
    if(shortStayLifeStayheavyAddRadio==null){

      shortStayLifeStayheavyAddRadio = new ACClearableRadioButtonGroup();

      getShortStayLifeStayheavyAddRadioContainer().setText("在宅中重度者受入加算");

      shortStayLifeStayheavyAddRadio.setBindPath("1210118");

      shortStayLifeStayheavyAddRadio.setModel(getShortStayLifeStayheavyAddRadioModel());

      shortStayLifeStayheavyAddRadio.setUseClearButton(false);

      addShortStayLifeStayheavyAddRadio();
    }
    return shortStayLifeStayheavyAddRadio;

  }

  /**
   * 在宅中重度者受入加算コンテナを取得します。
   * @return 在宅中重度者受入加算コンテナ
   */
  protected ACLabelContainer getShortStayLifeStayheavyAddRadioContainer(){
    if(shortStayLifeStayheavyAddRadioContainer==null){
      shortStayLifeStayheavyAddRadioContainer = new ACLabelContainer();
      shortStayLifeStayheavyAddRadioContainer.setFollowChildEnabled(true);
      shortStayLifeStayheavyAddRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayLifeStayheavyAddRadioContainer.add(getShortStayLifeStayheavyAddRadio(), null);
    }
    return shortStayLifeStayheavyAddRadioContainer;
  }

  /**
   * 在宅中重度者受入加算モデルを取得します。
   * @return 在宅中重度者受入加算モデル
   */
  protected ACListModelAdapter getShortStayLifeStayheavyAddRadioModel(){
    if(shortStayLifeStayheavyAddRadioModel==null){
      shortStayLifeStayheavyAddRadioModel = new ACListModelAdapter();
      addShortStayLifeStayheavyAddRadioModel();
    }
    return shortStayLifeStayheavyAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayLifeStayheavyAddRadioItem1(){
    if(shortStayLifeStayheavyAddRadioItem1==null){

      shortStayLifeStayheavyAddRadioItem1 = new ACRadioButtonItem();

      shortStayLifeStayheavyAddRadioItem1.setText("なし");

      shortStayLifeStayheavyAddRadioItem1.setGroup(getShortStayLifeStayheavyAddRadio());

      shortStayLifeStayheavyAddRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayLifeStayheavyAddRadioItem1();
    }
    return shortStayLifeStayheavyAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayLifeStayheavyAddRadioItem2(){
    if(shortStayLifeStayheavyAddRadioItem2==null){

      shortStayLifeStayheavyAddRadioItem2 = new ACRadioButtonItem();

      shortStayLifeStayheavyAddRadioItem2.setText("あり");

      shortStayLifeStayheavyAddRadioItem2.setGroup(getShortStayLifeStayheavyAddRadio());

      shortStayLifeStayheavyAddRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayLifeStayheavyAddRadioItem2();
    }
    return shortStayLifeStayheavyAddRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001109Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * タブペインに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getShortStayLifeTimeContenaFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeHospitalRoomDivisionContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightWorkConditionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 施設等の区分に内部項目を追加します。
   */
  protected void addShortStayLifeTimeContenaFacilityDivision(){

  }

  /**
   * 施設等の区分モデルに内部項目を追加します。
   */
  protected void addShortStayLifeTimeContenaFacilityDivisionModel(){

    getShortStayLifeSingle().setButtonIndex(1);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeSingle());

    getShortStayLifeDouble().setButtonIndex(2);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeDouble());

    getShortStayLifeSingleUnit().setButtonIndex(3);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeSingleUnit());

    getShortStayLifeDoubleUnit().setButtonIndex(4);
    getShortStayLifeTimeContenaFacilityDivisionModel().add(getShortStayLifeDoubleUnit());

  }

  /**
   * 単独型に内部項目を追加します。
   */
  protected void addShortStayLifeSingle(){

  }

  /**
   * 併設型に内部項目を追加します。
   */
  protected void addShortStayLifeDouble(){

  }

  /**
   * 単独型ユニット型に内部項目を追加します。
   */
  protected void addShortStayLifeSingleUnit(){

  }

  /**
   * 併設型ユニット型に内部項目を追加します。
   */
  protected void addShortStayLifeDoubleUnit(){

  }

  /**
   * 病室区分コンテナに内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionContena(){

    shortStayLifeHospitalRoomDivisionContena.add(getShortStayLifeHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeHospitalRoomDivisionContena.add(getShortStayLifeUnitHospitalRoomDivisionRadio(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分（通常）に内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（通常）モデルに内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioModel(){

    getShortStayLifeHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayLifeHospitalRoomDivisionRadioModel().add(getShortStayLifeHospitalRoomDivisionRadioItem1());

    getShortStayLifeHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayLifeHospitalRoomDivisionRadioModel().add(getShortStayLifeHospitalRoomDivisionRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayLifeHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 病室区分（ユニット）に内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分（ユニット）モデルに内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioModel(){

    getShortStayLifeUnitHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayLifeUnitHospitalRoomDivisionRadioModel().add(getShortStayLifeUnitHospitalRoomDivisionRadioItem1());

    getShortStayLifeUnitHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayLifeUnitHospitalRoomDivisionRadioModel().add(getShortStayLifeUnitHospitalRoomDivisionRadioItem2());

  }

  /**
   * ユニット型個室に内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioItem1(){

  }

  /**
   * ユニット型準個室に内部項目を追加します。
   */
  protected void addShortStayLifeUnitHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 夜間勤務条件基準に内部項目を追加します。
   */
  protected void addNightWorkConditionRadio(){

  }

  /**
   * 夜間勤務条件基準モデルに内部項目を追加します。
   */
  protected void addNightWorkConditionRadioModel(){

    getNightWorkConditionRadioItem1().setButtonIndex(1);
    getNightWorkConditionRadioModel().add(getNightWorkConditionRadioItem1());

    getNightWorkConditionRadioItem2().setButtonIndex(2);
    getNightWorkConditionRadioModel().add(getNightWorkConditionRadioItem2());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addNightWorkConditionRadioItem1(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addNightWorkConditionRadioItem2(){

  }

  /**
   * 機能訓練指導体制加算に内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadio(){

  }

  /**
   * 機能訓練指導体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioModel(){

    getShortStayLifeAdditionFunctionTrainingRadioItem2().setButtonIndex(1);
    getShortStayLifeAdditionFunctionTrainingRadioModel().add(getShortStayLifeAdditionFunctionTrainingRadioItem2());

    getShortStayLifeAdditionFunctionTrainingRadioItem1().setButtonIndex(2);
    getShortStayLifeAdditionFunctionTrainingRadioModel().add(getShortStayLifeAdditionFunctionTrainingRadioItem1());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * 送迎区分に内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOff(){

  }

  /**
   * 送迎区分モデルに内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffModel(){

    getShortStayLifeMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffNone());

    getShortStayLifeMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffOneWay());

    getShortStayLifeMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayLifeMeetingAndSendingOffModel().add(getShortStayLifeMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayLifeMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addShortStayLifeDieticianManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeDieticianManageRadioModel(){

    getShortStayLifeDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayLifeDieticianManageRadioModel().add(getShortStayLifeDieticianManageRadioItem1());

    getShortStayLifeDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayLifeDieticianManageRadioModel().add(getShortStayLifeDieticianManageRadioItem2());

    getShortStayLifeDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayLifeDieticianManageRadioModel().add(getShortStayLifeDieticianManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeDieticianManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addShortStayLifeDieticianManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addShortStayLifeDieticianManageRadioItem3(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayLifeMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayLifeAddition30Orver(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeEmergencyShortNetworkAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeStayheavyAddGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioModel(){

    getShortStayLifeMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem1());

    getShortStayLifeMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayLifeMedicalExpensesRadioModel().add(getShortStayLifeMedicalExpensesRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeMedicalExpensesRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayLifeSubtraction(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionModel(){

    getShortStayLifeSubtractionNot().setButtonIndex(1);
    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionNot());

    getShortStayLifeSubtractionExcess().setButtonIndex(2);
    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionExcess());

    getShortStayLifeSubtractionLack().setButtonIndex(3);
    getShortStayLifeSubtractionModel().add(getShortStayLifeSubtractionLack());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionNot(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionExcess(){

  }

  /**
   * 看護・介護職員の不足に内部項目を追加します。
   */
  protected void addShortStayLifeSubtractionLack(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addShortStayLifeDinnerContainer(){

    shortStayLifeDinnerContainer.add(getShortStayLifeDinnerOfferContainer(), VRLayout.FLOW);

    shortStayLifeDinnerContainer.add(getShortStayLifeDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayLifeDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayLifeDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayLifeDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayLifeAddition30Orver(){

  }

  /**
   * ユニットケアの整備に内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadio(){

  }

  /**
   * ユニットケアの整備モデルに内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadioModel(){

    getShortStayLifeUnitCareAddRadioItem1().setButtonIndex(1);
    getShortStayLifeUnitCareAddRadioModel().add(getShortStayLifeUnitCareAddRadioItem1());

    getShortStayLifeUnitCareAddRadioItem2().setButtonIndex(2);
    getShortStayLifeUnitCareAddRadioModel().add(getShortStayLifeUnitCareAddRadioItem2());

  }

  /**
   * 未整備に内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadioItem1(){

  }

  /**
   * 整備に内部項目を追加します。
   */
  protected void addShortStayLifeUnitCareAddRadioItem2(){

  }

  /**
   * 緊急短期入所ネットワーク加算に内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadio(){

  }

  /**
   * 緊急短期入所ネットワーク加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadioModel(){

    getShortStayLifeEmergencyShortNetworkAddRadioItem1().setButtonIndex(1);
    getShortStayLifeEmergencyShortNetworkAddRadioModel().add(getShortStayLifeEmergencyShortNetworkAddRadioItem1());

    getShortStayLifeEmergencyShortNetworkAddRadioItem2().setButtonIndex(2);
    getShortStayLifeEmergencyShortNetworkAddRadioModel().add(getShortStayLifeEmergencyShortNetworkAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeEmergencyShortNetworkAddRadioItem2(){

  }

  /**
   * 在宅中重度加算に内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddGroup(){

    shortStayLifeStayheavyAddGroup.add(getShortStayLifeNightNursingSystemAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayLifeStayheavyAddGroup.add(getShortStayLifeStayheavyAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 夜間看護体制加算に内部項目を追加します。
   */
  protected void addShortStayLifeNightNursingSystemAddRadio(){

  }

  /**
   * 夜間看護体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeNightNursingSystemAddRadioModel(){

    getShortStayLifeNightNursingSystemAddRadioItem1().setButtonIndex(1);
    getShortStayLifeNightNursingSystemAddRadioModel().add(getShortStayLifeNightNursingSystemAddRadioItem1());

    getShortStayLifeNightNursingSystemAddRadioItem2().setButtonIndex(2);
    getShortStayLifeNightNursingSystemAddRadioModel().add(getShortStayLifeNightNursingSystemAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeNightNursingSystemAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeNightNursingSystemAddRadioItem2(){

  }

  /**
   * 在宅中重度者受入加算に内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadio(){

  }

  /**
   * 在宅中重度者受入加算モデルに内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadioModel(){

    getShortStayLifeStayheavyAddRadioItem1().setButtonIndex(1);
    getShortStayLifeStayheavyAddRadioModel().add(getShortStayLifeStayheavyAddRadioItem1());

    getShortStayLifeStayheavyAddRadioItem2().setButtonIndex(2);
    getShortStayLifeStayheavyAddRadioModel().add(getShortStayLifeStayheavyAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayLifeStayheavyAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001109Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001109Design getThis() {
    return this;
  }
}
