
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
 * 作成日: 2015/02/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防短期入所生活介護 (QS001_12411_201504)
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
 * サービスパターン介護予防短期入所生活介護画面項目デザイン(QS001_12411_201504) 
 */
public class QS001_12411_201504Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup shortStayLifeTimeContenaFacilityDivision;

  private ACLabelContainer shortStayLifeTimeContenaFacilityDivisionContainer;

  private ACListModelAdapter shortStayLifeTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem shortStayLifeSingle;

  private ACRadioButtonItem shortStayLifeDouble;

  private ACRadioButtonItem shortStayLifeSingleUnit;

  private ACRadioButtonItem shortStayLifeDoubleUnit;

  private ACLabelContainer shortStayLifeHospitalRoomDivisionContena;

  private ACValueArrayRadioButtonGroup shortStayLifeHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayLifeUnitHospitalRoomDivisionRadio;

  private ACListModelAdapter shortStayLifeUnitHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitHospitalRoomDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup nightWorkConditionRadio;

  private ACLabelContainer nightWorkConditionRadioContainer;

  private ACListModelAdapter nightWorkConditionRadioModel;

  private ACRadioButtonItem nightWorkConditionRadioItem1;

  private ACRadioButtonItem nightWorkConditionRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaActionAddRadioGroup;

  private ACLabelContainer dementiaActionAddRadioGroupContainer;

  private ACListModelAdapter dementiaActionAddRadioGroupModel;

  private ACRadioButtonItem dementiaActionAddRadioItem1;

  private ACRadioButtonItem dementiaActionAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayLifeAdditionFunctionTrainingRadio;

  private ACLabelContainer shortStayLifeAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter shortStayLifeAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem2;

  private ACRadioButtonItem shortStayLifeAdditionFunctionTrainingRadioItem1;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup shortStayLifeMeetingAndSendingOff;

  private ACLabelContainer shortStayLifeMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayLifeMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayLifeMeetingAndSendingOffRoundTrip;

  private ACValueArrayRadioButtonGroup shortStayLifeMedicalExpensesRadio;

  private ACLabelContainer shortStayLifeMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayLifeMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayLifeMedicalExpensesRadioItem2;

  private ACValueArrayRadioButtonGroup shortStayLifeSubtraction;

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

  private ACValueArrayRadioButtonGroup shortStayLifeUnitCareAddRadio;

  private ACLabelContainer shortStayLifeUnitCareAddRadioContainer;

  private ACListModelAdapter shortStayLifeUnitCareAddRadioModel;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem1;

  private ACRadioButtonItem shortStayLifeUnitCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem;

  private ACLabelContainer individualfunctionTrainingSystemContainer;

  private ACListModelAdapter individualfunctionTrainingSystemModel;

  private ACRadioButtonItem individualfunctionTrainingSystemItem1;

  private ACRadioButtonItem individualfunctionTrainingSystemItem2;

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

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 施設等の区分を取得します。
   * @return 施設等の区分
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeTimeContenaFacilityDivision(){
    if(shortStayLifeTimeContenaFacilityDivision==null){

      shortStayLifeTimeContenaFacilityDivision = new ACValueArrayRadioButtonGroup();

      getShortStayLifeTimeContenaFacilityDivisionContainer().setText("施設等の区分");

      shortStayLifeTimeContenaFacilityDivision.setBindPath("1240101");

      shortStayLifeTimeContenaFacilityDivision.setUseClearButton(false);

      shortStayLifeTimeContenaFacilityDivision.setModel(getShortStayLifeTimeContenaFacilityDivisionModel());

      shortStayLifeTimeContenaFacilityDivision.setValues(new int[]{1,2,3,4});

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

      shortStayLifeHospitalRoomDivisionContena.setFollowChildEnabled(true);

      addShortStayLifeHospitalRoomDivisionContena();
    }
    return shortStayLifeHospitalRoomDivisionContena;

  }

  /**
   * 病室区分（通常）を取得します。
   * @return 病室区分（通常）
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeHospitalRoomDivisionRadio(){
    if(shortStayLifeHospitalRoomDivisionRadio==null){

      shortStayLifeHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      shortStayLifeHospitalRoomDivisionRadio.setBindPath("1240102");

      shortStayLifeHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayLifeHospitalRoomDivisionRadio.setModel(getShortStayLifeHospitalRoomDivisionRadioModel());

      shortStayLifeHospitalRoomDivisionRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getShortStayLifeUnitHospitalRoomDivisionRadio(){
    if(shortStayLifeUnitHospitalRoomDivisionRadio==null){

      shortStayLifeUnitHospitalRoomDivisionRadio = new ACValueArrayRadioButtonGroup();

      shortStayLifeUnitHospitalRoomDivisionRadio.setBindPath("1240103");

      shortStayLifeUnitHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayLifeUnitHospitalRoomDivisionRadio.setModel(getShortStayLifeUnitHospitalRoomDivisionRadioModel());

      shortStayLifeUnitHospitalRoomDivisionRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getNightWorkConditionRadio(){
    if(nightWorkConditionRadio==null){

      nightWorkConditionRadio = new ACValueArrayRadioButtonGroup();

      getNightWorkConditionRadioContainer().setText("夜間勤務条件基準");

      nightWorkConditionRadio.setBindPath("1240104");

      nightWorkConditionRadio.setUseClearButton(false);

      nightWorkConditionRadio.setModel(getNightWorkConditionRadioModel());

      nightWorkConditionRadio.setValues(new int[]{1,2});

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
   * 認知症行動・心理症状緊急対応加算を取得します。
   * @return 認知症行動・心理症状緊急対応加算
   */
  public ACValueArrayRadioButtonGroup getDementiaActionAddRadioGroup(){
    if(dementiaActionAddRadioGroup==null){

      dementiaActionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaActionAddRadioGroupContainer().setText("認知症行動・" + ACConstants.LINE_SEPARATOR + "心理症状緊急対応加算" + ACConstants.LINE_SEPARATOR + "（1月に7日を限度）");

      dementiaActionAddRadioGroup.setBindPath("1240114");

      dementiaActionAddRadioGroup.setNoSelectIndex(0);

      dementiaActionAddRadioGroup.setUseClearButton(false);

      dementiaActionAddRadioGroup.setModel(getDementiaActionAddRadioGroupModel());

      dementiaActionAddRadioGroup.setValues(new int[]{1,2});

      addDementiaActionAddRadioGroup();
    }
    return dementiaActionAddRadioGroup;

  }

  /**
   * 認知症行動・心理症状緊急対応加算コンテナを取得します。
   * @return 認知症行動・心理症状緊急対応加算コンテナ
   */
  protected ACLabelContainer getDementiaActionAddRadioGroupContainer(){
    if(dementiaActionAddRadioGroupContainer==null){
      dementiaActionAddRadioGroupContainer = new ACLabelContainer();
      dementiaActionAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaActionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaActionAddRadioGroupContainer.add(getDementiaActionAddRadioGroup(), null);
    }
    return dementiaActionAddRadioGroupContainer;
  }

  /**
   * 認知症行動・心理症状緊急対応加算モデルを取得します。
   * @return 認知症行動・心理症状緊急対応加算モデル
   */
  protected ACListModelAdapter getDementiaActionAddRadioGroupModel(){
    if(dementiaActionAddRadioGroupModel==null){
      dementiaActionAddRadioGroupModel = new ACListModelAdapter();
      addDementiaActionAddRadioGroupModel();
    }
    return dementiaActionAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem1(){
    if(dementiaActionAddRadioItem1==null){

      dementiaActionAddRadioItem1 = new ACRadioButtonItem();

      dementiaActionAddRadioItem1.setText("なし");

      dementiaActionAddRadioItem1.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem1();
    }
    return dementiaActionAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaActionAddRadioItem2(){
    if(dementiaActionAddRadioItem2==null){

      dementiaActionAddRadioItem2 = new ACRadioButtonItem();

      dementiaActionAddRadioItem2.setText("あり");

      dementiaActionAddRadioItem2.setGroup(getDementiaActionAddRadioGroup());

      dementiaActionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaActionAddRadioItem2();
    }
    return dementiaActionAddRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1240112");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症利用者受入加算コンテナを取得します。
   * @return 若年性認知症利用者受入加算コンテナ
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * 若年性認知症利用者受入加算モデルを取得します。
   * @return 若年性認知症利用者受入加算モデル
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("なし");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("あり");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * 機能訓練指導体制加算を取得します。
   * @return 機能訓練指導体制加算
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeAdditionFunctionTrainingRadio(){
    if(shortStayLifeAdditionFunctionTrainingRadio==null){

      shortStayLifeAdditionFunctionTrainingRadio = new ACValueArrayRadioButtonGroup();

      getShortStayLifeAdditionFunctionTrainingRadioContainer().setText("機能訓練指導加算");

      shortStayLifeAdditionFunctionTrainingRadio.setBindPath("1240105");

      shortStayLifeAdditionFunctionTrainingRadio.setUseClearButton(false);

      shortStayLifeAdditionFunctionTrainingRadio.setModel(getShortStayLifeAdditionFunctionTrainingRadioModel());

      shortStayLifeAdditionFunctionTrainingRadio.setValues(new int[]{1,2});

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
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 送迎区分を取得します。
   * @return 送迎区分
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeMeetingAndSendingOff(){
    if(shortStayLifeMeetingAndSendingOff==null){

      shortStayLifeMeetingAndSendingOff = new ACValueArrayRadioButtonGroup();

      getShortStayLifeMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayLifeMeetingAndSendingOff.setBindPath("6");

      shortStayLifeMeetingAndSendingOff.setUseClearButton(false);

      shortStayLifeMeetingAndSendingOff.setModel(getShortStayLifeMeetingAndSendingOffModel());

      shortStayLifeMeetingAndSendingOff.setValues(new int[]{1,2,3});

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
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACValueArrayRadioButtonGroup getShortStayLifeMedicalExpensesRadio(){
    if(shortStayLifeMedicalExpensesRadio==null){

      shortStayLifeMedicalExpensesRadio = new ACValueArrayRadioButtonGroup();

      getShortStayLifeMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayLifeMedicalExpensesRadio.setBindPath("1240107");

      shortStayLifeMedicalExpensesRadio.setUseClearButton(false);

      shortStayLifeMedicalExpensesRadio.setModel(getShortStayLifeMedicalExpensesRadioModel());

      shortStayLifeMedicalExpensesRadio.setValues(new int[]{1,2});

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
  public ACValueArrayRadioButtonGroup getShortStayLifeSubtraction(){
    if(shortStayLifeSubtraction==null){

      shortStayLifeSubtraction = new ACValueArrayRadioButtonGroup();

      getShortStayLifeSubtractionContainer().setText("人員減算");

      shortStayLifeSubtraction.setBindPath("1240108");

      shortStayLifeSubtraction.setUseClearButton(false);

      shortStayLifeSubtraction.setModel(getShortStayLifeSubtractionModel());

      shortStayLifeSubtraction.setValues(new int[]{1,2,3});

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
   * 介護・看護職員が欠員を取得します。
   * @return 介護・看護職員が欠員
   */
  public ACRadioButtonItem getShortStayLifeSubtractionLack(){
    if(shortStayLifeSubtractionLack==null){

      shortStayLifeSubtractionLack = new ACRadioButtonItem();

      shortStayLifeSubtractionLack.setText("介護・看護職員が欠員");

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

      shortStayLifeDinnerContainer.setFollowChildEnabled(true);

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

      shortStayLifeDinnerOffer.setBindPath("1240109");

      shortStayLifeDinnerOffer.setEditable(false);

      shortStayLifeDinnerOffer.setModelBindPath("1240109");

      shortStayLifeDinnerOffer.setRenderBindPath("CONTENT");

      shortStayLifeDinnerOffer.setModel(getShortStayLifeDinnerOfferModel());

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

      shortStayLifeDinnerCost.setBindPath("1240110");

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
  public ACValueArrayRadioButtonGroup getShortStayLifeUnitCareAddRadio(){
    if(shortStayLifeUnitCareAddRadio==null){

      shortStayLifeUnitCareAddRadio = new ACValueArrayRadioButtonGroup();

      getShortStayLifeUnitCareAddRadioContainer().setText("ユニットケアの整備");

      shortStayLifeUnitCareAddRadio.setBindPath("1240111");

      shortStayLifeUnitCareAddRadio.setUseClearButton(false);

      shortStayLifeUnitCareAddRadio.setModel(getShortStayLifeUnitCareAddRadioModel());

      shortStayLifeUnitCareAddRadio.setValues(new int[]{1,2});

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
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1240113");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * サービス提供体制強化加算コンテナを取得します。
   * @return サービス提供体制強化加算コンテナ
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * サービス提供体制強化加算モデルを取得します。
   * @return サービス提供体制強化加算モデル
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("なし");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * Iイ型を取得します。
   * @return Iイ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III型を取得します。
   * @return III型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * 個別機能訓練加算を取得します。
   * @return 個別機能訓練加算
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem(){
    if(individualfunctionTrainingSystem==null){

      individualfunctionTrainingSystem = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystemContainer().setText("個別機能訓練加算");

      individualfunctionTrainingSystem.setBindPath("1240115");

      individualfunctionTrainingSystem.setNoSelectIndex(0);

      individualfunctionTrainingSystem.setUseClearButton(false);

      individualfunctionTrainingSystem.setModel(getIndividualfunctionTrainingSystemModel());

      individualfunctionTrainingSystem.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem();
    }
    return individualfunctionTrainingSystem;

  }

  /**
   * 個別機能訓練加算コンテナを取得します。
   * @return 個別機能訓練加算コンテナ
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystemContainer(){
    if(individualfunctionTrainingSystemContainer==null){
      individualfunctionTrainingSystemContainer = new ACLabelContainer();
      individualfunctionTrainingSystemContainer.setFollowChildEnabled(true);
      individualfunctionTrainingSystemContainer.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystemContainer.add(getIndividualfunctionTrainingSystem(), null);
    }
    return individualfunctionTrainingSystemContainer;
  }

  /**
   * 個別機能訓練加算モデルを取得します。
   * @return 個別機能訓練加算モデル
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystemModel(){
    if(individualfunctionTrainingSystemModel==null){
      individualfunctionTrainingSystemModel = new ACListModelAdapter();
      addIndividualfunctionTrainingSystemModel();
    }
    return individualfunctionTrainingSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem1(){
    if(individualfunctionTrainingSystemItem1==null){

      individualfunctionTrainingSystemItem1 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem1.setText("なし");

      individualfunctionTrainingSystemItem1.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem1();
    }
    return individualfunctionTrainingSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem2(){
    if(individualfunctionTrainingSystemItem2==null){

      individualfunctionTrainingSystemItem2 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem2.setText("あり");

      individualfunctionTrainingSystemItem2.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem2();
    }
    return individualfunctionTrainingSystemItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001_12411_201504Design() {

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

    tab1.add(getDementiaActionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getShortStayLifeAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 認知症行動・心理症状緊急対応加算に内部項目を追加します。
   */
  protected void addDementiaActionAddRadioGroup(){

  }

  /**
   * 認知症行動・心理症状緊急対応加算モデルに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioGroupModel(){

    getDementiaActionAddRadioItem1().setButtonIndex(1);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem1());

    getDementiaActionAddRadioItem2().setButtonIndex(2);

    getDementiaActionAddRadioGroupModel().add(getDementiaActionAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaActionAddRadioItem2(){

  }

  /**
   * 若年性認知症利用者受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症利用者受入加算モデルに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

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
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getShortStayLifeMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    tab2.add(getShortStayLifeAddition30Orver(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getShortStayLifeUnitCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getIndividualfunctionTrainingSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * 介護・看護職員が欠員に内部項目を追加します。
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
   * サービス提供体制強化加算に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * サービス提供体制強化加算モデルに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * 個別機能訓練加算に内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystem(){

  }

  /**
   * 個別機能訓練加算モデルに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemModel(){

    getIndividualfunctionTrainingSystemItem1().setButtonIndex(1);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem1());

    getIndividualfunctionTrainingSystemItem2().setButtonIndex(2);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addIndividualfunctionTrainingSystemItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_12411_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_12411_201504Design getThis() {
    return this;
  }
}
